package erf.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the module_report_data database table.
 * 
 */
@Entity
@Table(name="module_report_data")
@NamedQuery(name="ModuleReportData.findAll", query="SELECT m FROM ModuleReportData m")
public class ModuleReportData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String datasource;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	//bi-directional many-to-one association to ReportDataDef
	@ManyToOne
	@JoinColumn(name="REPORTDATA_ID")
	private ReportDataDef reportDataDef;

	public ModuleReportData() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatasource() {
		return this.datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public ReportDataDef getReportDataDef() {
		return this.reportDataDef;
	}

	public void setReportDataDef(ReportDataDef reportDataDef) {
		this.reportDataDef = reportDataDef;
	}

}