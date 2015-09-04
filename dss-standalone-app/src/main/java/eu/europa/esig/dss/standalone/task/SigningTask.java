package eu.europa.esig.dss.standalone.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.FutureTask;

import javafx.application.Platform;
import javafx.concurrent.Task;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import eu.europa.esig.dss.BLevelParameters;
import eu.europa.esig.dss.DSSDocument;
import eu.europa.esig.dss.FileDocument;
import eu.europa.esig.dss.RemoteCertificate;
import eu.europa.esig.dss.RemoteDocument;
import eu.europa.esig.dss.RemoteSignatureParameters;
import eu.europa.esig.dss.SignatureValue;
import eu.europa.esig.dss.ToBeSigned;
import eu.europa.esig.dss.signature.RemoteDocumentSignatureService;
import eu.europa.esig.dss.standalone.model.SignatureModel;
import eu.europa.esig.dss.token.DSSPrivateKeyEntry;
import eu.europa.esig.dss.token.MSCAPISignatureToken;
import eu.europa.esig.dss.token.Pkcs11SignatureToken;
import eu.europa.esig.dss.token.Pkcs12SignatureToken;
import eu.europa.esig.dss.token.SignatureTokenConnection;
import eu.europa.esig.dss.x509.CertificateToken;

public class SigningTask extends Task<DSSDocument> {

	private RemoteDocumentSignatureService<RemoteDocument, RemoteSignatureParameters> service;
	private SignatureModel model;

	public SigningTask(RemoteDocumentSignatureService<RemoteDocument, RemoteSignatureParameters> service, SignatureModel model) {
		this.service = service;
		this.model = model;
	}

	@Override
	protected DSSDocument call() throws Exception {

		updateProgress(0, 100);

		SignatureTokenConnection token = getToken(model);
		List<DSSPrivateKeyEntry> keys = token.getKeys();

		updateProgress(10, 100);

		DSSPrivateKeyEntry signer = getSigner(keys);
		if (signer == null) {
			failed();
		}

		updateProgress(20, 100);

		RemoteDocument toSignDocument = new RemoteDocument(new FileDocument(model.getFileToSign()));

		RemoteSignatureParameters parameters = new RemoteSignatureParameters();
		parameters.setDigestAlgorithm(model.getDigestAlgorithm());
		parameters.setSignatureLevel(model.getSignatureLevel());
		parameters.setSignaturePackaging(model.getSignaturePackaging());
		BLevelParameters bLevelParams = new BLevelParameters();
		bLevelParams.setSigningDate(new Date());
		parameters.setBLevelParams(bLevelParams);

		parameters.setSigningCertificate(new RemoteCertificate(signer.getCertificate().getEncoded()));
		CertificateToken[] certificateChain = signer.getCertificateChain();
		if (ArrayUtils.isNotEmpty(certificateChain)) {
			List<RemoteCertificate> certificateChainList = new ArrayList<RemoteCertificate>();
			for (CertificateToken certificateToken : certificateChain) {
				certificateChainList.add(new RemoteCertificate(certificateToken.getEncoded()));
			}
			parameters.setCertificateChain(certificateChainList);
		}

		updateProgress(25, 100);
		ToBeSigned toBeSigned = service.getDataToSign(toSignDocument, parameters);
		updateProgress(50, 100);
		SignatureValue signatureValue = token.sign(toBeSigned, model.getDigestAlgorithm(), signer);
		updateProgress(75, 100);
		DSSDocument signDocument = service.signDocument(toSignDocument, parameters, signatureValue);
		updateProgress(100, 100);

		return signDocument;
	}

	private DSSPrivateKeyEntry getSigner(List<DSSPrivateKeyEntry> keys) throws Exception {
		if (CollectionUtils.isEmpty(keys)) {
			updateMessage("No certificate found");
		} else if (CollectionUtils.size(keys) == 1) {
			return keys.get(0);
		} else {
			FutureTask<DSSPrivateKeyEntry> future = new FutureTask<DSSPrivateKeyEntry>(new SelectCertificateTask(keys));
			Platform.runLater(future);
			DSSPrivateKeyEntry key = 	future.get();
			if (key == null) {
				updateMessage("No selected certificate");
			}
		}
		return null;
	}

	private SignatureTokenConnection getToken(SignatureModel model) {
		switch (model.getTokenType()) {
			case PKCS11:
				return new Pkcs11SignatureToken(model.getPkcsFile().getAbsolutePath(), model.getPassword().toCharArray());
			case PKCS12:
				return new Pkcs12SignatureToken(model.getPassword().toCharArray(), model.getPkcsFile());
			case MSCAPI:
				return new MSCAPISignatureToken();
			default:
				throw new IllegalArgumentException("Unsupported token type " + model.getTokenType());
		}
	}

	@Override
	protected void updateProgress(double workDone, double max) {
		super.updateProgress(workDone, max);
	}

	@Override
	protected void updateMessage(String message) {
		super.updateMessage(message);
	}

}
