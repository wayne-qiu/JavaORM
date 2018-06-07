package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the report_instance database table.
 * 
 */
@Entity
@Table(name="report_instance")
@NamedQuery(name="ReportInstance.findAll", query="SELECT r FROM ReportInstance r")
public class ReportInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	private String location;

	//bi-directional many-to-one association to ReportDef
	@ManyToOne
	@JoinColumn(name="REPDEF_ID")
	private ReportDef reportDef;

	//bi-directional many-to-one association to ReportInstanceParameter
	@OneToMany(mappedBy="reportInstance")
	private List<ReportInstanceParameter> reportInstanceParameters;

	public ReportInstance() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ReportDef getReportDef() {
		return this.reportDef;
	}

	public void setReportDef(ReportDef reportDef) {
		this.reportDef = reportDef;
	}

	public List<ReportInstanceParameter> getReportInstanceParameters() {
		return this.reportInstanceParameters;
	}

	public void setReportInstanceParameters(List<ReportInstanceParameter> reportInstanceParameters) {
		this.reportInstanceParameters = reportInstanceParameters;
	}

	public ReportInstanceParameter addReportInstanceParameter(ReportInstanceParameter reportInstanceParameter) {
		getReportInstanceParameters().add(reportInstanceParameter);
		reportInstanceParameter.setReportInstance(this);

		return reportInstanceParameter;
	}

	public ReportInstanceParameter removeReportInstanceParameter(ReportInstanceParameter reportInstanceParameter) {
		getReportInstanceParameters().remove(reportInstanceParameter);
		reportInstanceParameter.setReportInstance(null);

		return reportInstanceParameter;
	}

}