/**
 * DSS - Digital Signature Services
 * Copyright (C) 2015 European Commission, provided under the CEF programme
 *
 * This file is part of the "DSS - Digital Signature Services" project.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package eu.europa.esig.dss.pdf;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.SignatureException;
import java.util.List;

import eu.europa.esig.dss.DSSDocument;
import eu.europa.esig.dss.DSSException;
import eu.europa.esig.dss.DigestAlgorithm;
import eu.europa.esig.dss.pades.PAdESSignatureParameters;
import eu.europa.esig.dss.pades.SignatureFieldParameters;
import eu.europa.esig.dss.x509.CertificatePool;

/**
 * The usage of this interface permits the user to choose the underlying PDF library used to create PDF signatures.
 *
 *
 */
public interface PDFSignatureService {

	/**
	 * Returns the digest value of a PDF document
	 *
	 * @param toSignDocument
	 * @param parameters
	 * @param digestAlgorithm
	 * @return
	 * @throws DSSException
	 */
	byte[] digest(final InputStream toSignDocument, final PAdESSignatureParameters parameters, final DigestAlgorithm digestAlgorithm) throws DSSException;

	/**
	 * Signs a PDF document
	 *
	 * @param pdfData
	 * @param signatureValue
	 * @param signedStream
	 * @param parameters
	 * @param digestAlgorithm
	 * @throws DSSException
	 */
	void sign(final InputStream pdfData, final byte[] signatureValue, final OutputStream signedStream, final PAdESSignatureParameters parameters,
			final DigestAlgorithm digestAlgorithm) throws DSSException;

	/**
	 * Retrieves and triggers validation of the signatures from a PDF document
	 *
	 * @param validationCertPool
	 * @param document
	 * @param callback
	 * @throws DSSException
	 * @throws SignatureException
	 */
	void validateSignatures(final CertificatePool validationCertPool, final DSSDocument document, final SignatureValidationCallback callback)
			throws DSSException;

	void addDssDictionary(InputStream inputStream, OutputStream outpuStream, List<DSSDictionaryCallback> callbacks) throws DSSException;

	/**
	 * This method returns not signed signature-fields
	 * 
	 * @param document
	 *            the pdf document
	 * @return the list of empty signature fields
	 */
	List<String> getAvailableSignatureFields(DSSDocument document);

	/**
	 * This method allows to add a new signature field to an existing pdf document
	 * 
	 * @param document
	 *            the pdf document
	 * @param parameters
	 *            the parameters with the coordinates,... of the signature field
	 * @return the pdf document with the new added signature field
	 */
	DSSDocument addNewSignatureField(DSSDocument document, SignatureFieldParameters parameters);

}