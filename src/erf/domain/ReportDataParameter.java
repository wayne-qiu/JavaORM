package erf.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report_data_parameter database table.
 * 
 */
@Entity
@Table(name="report_data_parameter")
@NamedQuery(name="ReportDataParameter.findAll", query="SELECT r FROM ReportDataParameter r")
public class ReportDataParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	//bi-directional many-to-one association to ReportDataDef
	@ManyToOne
	@JoinColumn(name="REPORTDATA_ID")
	private ReportDataDef reportDataDef;

	//bi-directional many-to-one association to ReportParameter
	@ManyToOne
	@JoinColumn(name="PARAMETER_ID")
	private ReportParameter reportParameter;

	public ReportDataParameter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReportDataDef getReportDataDef() {
		return this.reportDataDef;
	}

	public void setReportDataDef(ReportDataDef reportDataDef) {
		this.reportDataDef = reportDataDef;
	}

	public ReportParameter getReportParameter() {
		return this.reportParameter;
	}

	public void setReportParameter(ReportParameter reportParameter) {
		this.reportParameter = reportParameter;
	}

}