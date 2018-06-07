package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the report_def database table.
 * 
 */
@Entity
@Table(name="report_def")
@NamedQuery(name="ReportDef.findAll", query="SELECT r FROM ReportDef r")
public class ReportDef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="ACCOUNTGROUP_ID")
	private String accountgroupId;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	@Column(name="CREATOR_ID")
	private String creatorId;

	private String description;

	@Column(name="MODIFY_TIME")
	private Timestamp modifyTime;

	private String name;

	//bi-directional many-to-one association to PackageDetail
	@OneToMany(mappedBy="reportDef")
	private List<PackageDetail> packageDetails;

	//bi-directional many-to-one association to ReportCategory
	@ManyToOne
	@JoinColumn(name="REPCAT_ID")
	private ReportCategory reportCategory;

	//bi-directional many-to-one association to Package
	@ManyToOne
	private Package package;

	//bi-directional many-to-one association to ReportInstance
	@OneToMany(mappedBy="reportDef")
	private List<ReportInstance> reportInstances;

	//bi-directional many-to-one association to SchdSchedule
	@OneToMany(mappedBy="reportDef")
	private List<SchdSchedule> schdSchedules;

	public ReportDef() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountgroupId() {
		return this.accountgroupId;
	}

	public void setAccountgroupId(String accountgroupId) {
		this.accountgroupId = accountgroupId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PackageDetail> getPackageDetails() {
		return this.packageDetails;
	}

	public void setPackageDetails(List<PackageDetail> packageDetails) {
		this.packageDetails = packageDetails;
	}

	public PackageDetail addPackageDetail(PackageDetail packageDetail) {
		getPackageDetails().add(packageDetail);
		packageDetail.setReportDef(this);

		return packageDetail;
	}

	public PackageDetail removePackageDetail(PackageDetail packageDetail) {
		getPackageDetails().remove(packageDetail);
		packageDetail.setReportDef(null);

		return packageDetail;
	}

	public ReportCategory getReportCategory() {
		return this.reportCategory;
	}

	public void setReportCategory(ReportCategory reportCategory) {
		this.reportCategory = reportCategory;
	}

	public Package getPackage() {
		return this.package;
	}

	public void setPackage(Package package) {
		this.package = package;
	}

	public List<ReportInstance> getReportInstances() {
		return this.reportInstances;
	}

	public void setReportInstances(List<ReportInstance> reportInstances) {
		this.reportInstances = reportInstances;
	}

	public ReportInstance addReportInstance(ReportInstance reportInstance) {
		getReportInstances().add(reportInstance);
		reportInstance.setReportDef(this);

		return reportInstance;
	}

	public ReportInstance removeReportInstance(ReportInstance reportInstance) {
		getReportInstances().remove(reportInstance);
		reportInstance.setReportDef(null);

		return reportInstance;
	}

	public List<SchdSchedule> getSchdSchedules() {
		return this.schdSchedules;
	}

	public void setSchdSchedules(List<SchdSchedule> schdSchedules) {
		this.schdSchedules = schdSchedules;
	}

	public SchdSchedule addSchdSchedule(SchdSchedule schdSchedule) {
		getSchdSchedules().add(schdSchedule);
		schdSchedule.setReportDef(this);

		return schdSchedule;
	}

	public SchdSchedule removeSchdSchedule(SchdSchedule schdSchedule) {
		getSchdSchedules().remove(schdSchedule);
		schdSchedule.setReportDef(null);

		return schdSchedule;
	}

}