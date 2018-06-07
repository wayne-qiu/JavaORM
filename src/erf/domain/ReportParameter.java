package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to ModuleParameter
	@OneToMany(mappedBy="reportParameter")
	private List<ModuleParameter> moduleParameters;

	//bi-directional many-to-one association to ReportInstanceParameter
	@OneToMany(mappedBy="reportParameter")
	private List<ReportInstanceParameter> reportInstanceParameters;

	//bi-directional many-to-one association to ErfClient
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private ErfClient erfClient;

	public ReportParameter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<ModuleParameter> getModuleParameters() {
		return this.moduleParameters;
	}

	public void setModuleParameters(List<ModuleParameter> moduleParameters) {
		this.moduleParameters = moduleParameters;
	}

	public ModuleParameter addModuleParameter(ModuleParameter moduleParameter) {
		getModuleParameters().add(moduleParameter);
		moduleParameter.setReportParameter(this);

		return moduleParameter;
	}

	public ModuleParameter removeModuleParameter(ModuleParameter moduleParameter) {
		getModuleParameters().remove(moduleParameter);
		moduleParameter.setReportParameter(null);

		return moduleParameter;
	}

	public List<ReportInstanceParameter> getReportInstanceParameters() {
		return this.reportInstanceParameters;
	}

	public void setReportInstanceParameters(List<ReportInstanceParameter> reportInstanceParameters) {
		this.reportInstanceParameters = reportInstanceParameters;
	}

	public ReportInstanceParameter addReportInstanceParameter(ReportInstanceParameter reportInstanceParameter) {
		getReportInstanceParameters().add(reportInstanceParameter);
		reportInstanceParameter.setReportParameter(this);

		return reportInstanceParameter;
	}

	public ReportInstanceParameter removeReportInstanceParameter(ReportInstanceParameter reportInstanceParameter) {
		getReportInstanceParameters().remove(reportInstanceParameter);
		reportInstanceParameter.setReportParameter(null);

		return reportInstanceParameter;
	}

	public ErfClient getErfClient() {
		return this.erfClient;
	}

	public void setErfClient(ErfClient erfClient) {
		this.erfClient = erfClient;
	}

}