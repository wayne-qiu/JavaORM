package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the package_def database table.
 * 
 */
@Entity
@Table(name="package_def")
@NamedQuery(name="PackageDef.findAll", query="SELECT p FROM PackageDef p")
public class PackageDef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PACKAGE_ID")
	private String packageId;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	private String destination;

	@Column(name="MODIFY_TIME")
	private Timestamp modifyTime;

	@Column(name="PACKAGE_NAME")
	private String packageName;

	private String type;

	//bi-directional many-to-one association to ErfClient
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private ErfClient erfClient;

	//bi-directional many-to-one association to PackageDetail
	@OneToMany(mappedBy="packageDef")
	private List<PackageDetail> packageDetails;

	//bi-directional many-to-one association to SchdSchedule
	@OneToMany(mappedBy="packageDef")
	private List<SchdSchedule> schdSchedules;

	public PackageDef() {
	}

	public String getPackageId() {
		return this.packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ErfClient getErfClient() {
		return this.erfClient;
	}

	public void setErfClient(ErfClient erfClient) {
		this.erfClient = erfClient;
	}

	public List<PackageDetail> getPackageDetails() {
		return this.packageDetails;
	}

	public void setPackageDetails(List<PackageDetail> packageDetails) {
		this.packageDetails = packageDetails;
	}

	public PackageDetail addPackageDetail(PackageDetail packageDetail) {
		getPackageDetails().add(packageDetail);
		packageDetail.setPackageDef(this);

		return packageDetail;
	}

	public PackageDetail removePackageDetail(PackageDetail packageDetail) {
		getPackageDetails().remove(packageDetail);
		packageDetail.setPackageDef(null);

		return packageDetail;
	}

	public List<SchdSchedule> getSchdSchedules() {
		return this.schdSchedules;
	}

	public void setSchdSchedules(List<SchdSchedule> schdSchedules) {
		this.schdSchedules = schdSchedules;
	}

	public SchdSchedule addSchdSchedule(SchdSchedule schdSchedule) {
		getSchdSchedules().add(schdSchedule);
		schdSchedule.setPackageDef(this);

		return schdSchedule;
	}

	public SchdSchedule removeSchdSchedule(SchdSchedule schdSchedule) {
		getSchdSchedules().remove(schdSchedule);
		schdSchedule.setPackageDef(null);

		return schdSchedule;
	}

}