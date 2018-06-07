package erf.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the package_detail database table.
 * 
 */
@Entity
@Table(name="package_detail")
@NamedQuery(name="PackageDetail.findAll", query="SELECT p FROM PackageDetail p")
public class PackageDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	//bi-directional many-to-one association to PackageDef
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private PackageDef packageDef;

	//bi-directional many-to-one association to ReportDef
	@ManyToOne
	@JoinColumn(name="REPDEF_ID")
	private ReportDef reportDef;

	public PackageDetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PackageDef getPackageDef() {
		return this.packageDef;
	}

	public void setPackageDef(PackageDef packageDef) {
		this.packageDef = packageDef;
	}

	public ReportDef getReportDef() {
		return this.reportDef;
	}

	public void setReportDef(ReportDef reportDef) {
		this.reportDef = reportDef;
	}

}