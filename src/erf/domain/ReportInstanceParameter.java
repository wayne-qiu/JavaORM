package erf.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report_instance_parameter database table.
 * 
 */
@Entity
@Table(name="report_instance_parameter")
@NamedQuery(name="ReportInstanceParameter.findAll", query="SELECT r FROM ReportInstanceParameter r")
public class ReportInstanceParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String value;

	//bi-directional many-to-one association to ReportParameter
	@ManyToOne
	@JoinColumn(name="PARAMETER_ID")
	private ReportParameter reportParameter;

	//bi-directional many-to-one association to ReportInstance
	@ManyToOne
	@JoinColumn(name="REPINSTANCE_ID")
	private ReportInstance reportInstance;

	public ReportInstanceParameter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ReportParameter getReportParameter() {
		return this.reportParameter;
	}

	public void setReportParameter(ReportParameter reportParameter) {
		this.reportParameter = reportParameter;
	}

	public ReportInstance getReportInstance() {
		return this.reportInstance;
	}

	public void setReportInstance(ReportInstance reportInstance) {
		this.reportInstance = reportInstance;
	}

}