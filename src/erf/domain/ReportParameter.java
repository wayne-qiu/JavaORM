package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the report_parameter database table.
 * 
 */
@Entity
@Table(name="report_parameter")
@NamedQuery(name="ReportParameter.findAll", query="SELECT r FROM ReportParameter r")
public class ReportParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="CLIENT_ID")
	private int clientId;

	@Column(name="DATA_TYPE")
	private String dataType;

	private short editable;

	private String name;

	private int ORDERs;

	private short required;

	@Column(name="SERVICE_URL")
	private String serviceUrl;

	private String type;

	private String value;

	@Column(name="WIDGET_TYPE")
	private String widgetType;

	//bi-directional many-to-one association to ReportDataParameter
	@OneToMany(mappedBy="reportParameter")
	private Set<ReportDataParameter> reportDataParameters;

	public ReportParameter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public short getEditable() {
		return this.editable;
	}

	public void setEditable(short editable) {
		this.editable = editable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getORDERs() {
		return this.ORDERs;
	}

	public void setORDERs(int ORDERs) {
		this.ORDERs = ORDERs;
	}

	public short getRequired() {
		return this.required;
	}

	public void setRequired(short required) {
		this.required = required;
	}

	public String getServiceUrl() {
		return this.serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getWidgetType() {
		return this.widgetType;
	}

	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}

	public Set<ReportDataParameter> getReportDataParameters() {
		return this.reportDataParameters;
	}

	public void setReportDataParameters(Set<ReportDataParameter> reportDataParameters) {
		this.reportDataParameters = reportDataParameters;
	}

	public ReportDataParameter addReportDataParameter(ReportDataParameter reportDataParameter) {
		getReportDataParameters().add(reportDataParameter);
		reportDataParameter.setReportParameter(this);

		return reportDataParameter;
	}

	public ReportDataParameter removeReportDataParameter(ReportDataParameter reportDataParameter) {
		getReportDataParameters().remove(reportDataParameter);
		reportDataParameter.setReportParameter(null);

		return reportDataParameter;
	}

}