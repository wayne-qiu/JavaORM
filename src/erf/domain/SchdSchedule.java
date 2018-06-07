package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the schd_schedules database table.
 * 
 */
@Entity
@Table(name="schd_schedules")
@NamedQuery(name="SchdSchedule.findAll", query="SELECT s FROM SchdSchedule s")
public class SchdSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCHEDULE_ID")
	private String scheduleId;

	@Column(name="CLIENT_ID")
	private int clientId;

	@Column(name="CREATE_TS")
	private Timestamp createTs;

	private short frequency;

	@Column(name="JOB_NAME")
	private String jobName;

	@Column(name="MODIFIED_TS")
	private Timestamp modifiedTs;

	private String modifier;

	@Column(name="SCHEDULE_NAME")
	private String scheduleName;

	private int state;

	//bi-directional many-to-one association to PackageDef
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private PackageDef packageDef;

	//bi-directional many-to-one association to ReportDef
	@ManyToOne
	@JoinColumn(name="REPDEF_ID")
	private ReportDef reportDef;

	public SchdSchedule() {
	}

	public String getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Timestamp getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	public short getFrequency() {
		return this.frequency;
	}

	public void setFrequency(short frequency) {
		this.frequency = frequency;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Timestamp getModifiedTs() {
		return this.modifiedTs;
	}

	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getScheduleName() {
		return this.scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
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