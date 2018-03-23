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
package eu.europa.esig.dss.validation.reports;

/**
 * This class is a container for all reports generated by the certificate validation
 * process: diagnostic data, detailed report and simple report.
 */
public class CertificateReports extends AbstractReports {

	/**
	 * This is the simple report generated at the end of the validation process.
	 */
	protected eu.europa.esig.dss.jaxb.simplecertificatereport.SimpleCertificateReport simpleReport;

	protected SimpleCertificateReport simpleReportWrapper;

	private String xmlSimpleReport;

	/**
	 * This is the default constructor to instantiate this container.
	 *
	 * @param diagnosticDataJaxb
	 *            the JAXB {@code DiagnosticData}
	 * @param detailedReport
	 *            the JAXB {@code DetailedReport}
	 * @param simpleReport
	 *            the JAXB {@code SimpleCertificateReport}
	 */
	public CertificateReports(final eu.europa.esig.dss.jaxb.diagnostic.DiagnosticData diagnosticDataJaxb,
			final eu.europa.esig.dss.jaxb.detailedreport.DetailedReport detailedReport,
			final eu.europa.esig.dss.jaxb.simplecertificatereport.SimpleCertificateReport simpleReport) {
		super(diagnosticDataJaxb, detailedReport);
		this.simpleReport = simpleReport;
		this.simpleReportWrapper = new SimpleCertificateReport(simpleReport);
	}

	/**
	 * This method returns the wrapper to manipulate the JAXB SimpleCertificateReport
	 *
	 * @return the wrapper {@code SimpleCertificateReport}
	 */
	public SimpleCertificateReport getSimpleReport() {
		return simpleReportWrapper;
	}

	/**
	 * This method returns the JAXB SimpleCertificateReport
	 * 
	 * @return the JAXB {@code SimpleCertificateReport}
	 */
	public eu.europa.esig.dss.jaxb.simplecertificatereport.SimpleCertificateReport getSimpleReportJaxb() {
		return simpleReport;
	}

	/**
	 * This method returns the XML representation of the JAXB SimpleCertificateReport String
	 * 
	 * @return a String with the XML content of the JAXB {@code SimpleCertificateReport}
	 */
	@Override
	public String getXmlSimpleReport() {
		if (xmlSimpleReport == null) {
			xmlSimpleReport = getJAXBObjectAsString(simpleReport,
					eu.europa.esig.dss.jaxb.simplecertificatereport.SimpleCertificateReport.class.getPackage().getName(), "/xsd/SimpleCertificateReport.xsd");
		}
		return xmlSimpleReport;
	}

}
