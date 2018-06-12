package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the report_data_def database table.
 * 
 */
@Entity
@Table(name="report_data_def")
@NamedQuery(name="ReportDataDef.findAll", query="SELECT r FROM ReportDataDef r")
public class ReportDataDef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="CLIETNT_ID")
	private int clietntId;

	@Column(name="CREATOR_ID")
	private String creatorId;

	private String name;

	//bi-directional many-to-one association to ModuleReportData
	@OneToMany(mappedBy="reportDataDef")
	private Set<ModuleReportData> moduleReportData;

	//bi-directional many-to-one association to ReportDataParameter
	@OneToMany(mappedBy="reportDataDef")
	private Set<ReportDataParameter> reportDataParameters;

	public ReportDataDef() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getClietntId() {
		return this.clietntId;
	}

	public void setClietntId(int clietntId) {
		this.clietntId = clietntId;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ModuleReportData> getModuleReportData() {
		return this.moduleReportData;
	}

	public void setModuleReportData(Set<ModuleReportData> moduleReportData) {
		this.moduleReportData = moduleReportData;
	}

	public ModuleReportData addModuleReportData(ModuleReportData moduleReportData) {
		getModuleReportData().add(moduleReportData);
		moduleReportData.setReportDataDef(this);

		return moduleReportData;
	}

	public ModuleReportData removeModuleReportData(ModuleReportData moduleReportData) {
		getModuleReportData().remove(moduleReportData);
		moduleReportData.setReportDataDef(null);

		return moduleReportData;
	}

	public Set<ReportDataParameter> getReportDataParameters() {
		return this.reportDataParameters;
	}

	public void setReportDataParameters(Set<ReportDataParameter> reportDataParameters) {
		this.reportDataParameters = reportDataParameters;
	}

	public ReportDataParameter addReportDataParameter(ReportDataParameter reportDataParameter) {
		getReportDataParameters().add(reportDataParameter);
		reportDataParameter.setReportDataDef(this);

		return reportDataParameter;
	}

	public ReportDataParameter removeReportDataParameter(ReportDataParameter reportDataParameter) {
		getReportDataParameters().remove(reportDataParameter);
		reportDataParameter.setReportDataDef(null);

		return reportDataParameter;
	}

}