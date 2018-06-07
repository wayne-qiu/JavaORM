package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the package database table.
 * 
 */
@Entity
@NamedQuery(name="Package.findAll", query="SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="PACKAGE_NAME")
	private String packageName;

	//bi-directional many-to-one association to ReportDef
	@OneToMany(mappedBy="package")
	private List<ReportDef> reportDefs;

	public Package() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<ReportDef> getReportDefs() {
		return this.reportDefs;
	}

	public void setReportDefs(List<ReportDef> reportDefs) {
		this.reportDefs = reportDefs;
	}

	public ReportDef addReportDef(ReportDef reportDef) {
		getReportDefs().add(reportDef);
		reportDef.setPackage(this);

		return reportDef;
	}

	public ReportDef removeReportDef(ReportDef reportDef) {
		getReportDefs().remove(reportDef);
		reportDef.setPackage(null);

		return reportDef;
	}

}