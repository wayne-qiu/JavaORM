package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the report_category database table.
 * 
 */
@Entity
@Table(name="report_category")
@NamedQuery(name="ReportCategory.findAll", query="SELECT r FROM ReportCategory r")
public class ReportCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	private String name;

	//bi-directional many-to-one association to ErfClient
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private ErfClient erfClient;

	//bi-directional many-to-one association to ReportDef
	@OneToMany(mappedBy="reportCategory")
	private List<ReportDef> reportDefs;

	public ReportCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ErfClient getErfClient() {
		return this.erfClient;
	}

	public void setErfClient(ErfClient erfClient) {
		this.erfClient = erfClient;
	}

	public List<ReportDef> getReportDefs() {
		return this.reportDefs;
	}

	public void setReportDefs(List<ReportDef> reportDefs) {
		this.reportDefs = reportDefs;
	}

	public ReportDef addReportDef(ReportDef reportDef) {
		getReportDefs().add(reportDef);
		reportDef.setReportCategory(this);

		return reportDef;
	}

	public ReportDef removeReportDef(ReportDef reportDef) {
		getReportDefs().remove(reportDef);
		reportDef.setReportCategory(null);

		return reportDef;
	}

}