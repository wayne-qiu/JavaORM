package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the erf_clients database table.
 * 
 */
@Entity
@Table(name="erf_clients")
@NamedQuery(name="ErfClient.findAll", query="SELECT e FROM ErfClient e")
public class ErfClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLIENT_ID")
	private int clientId;

	@Column(name="CLIENT_CATEGORY")
	private String clientCategory;

	@Column(name="CLIENT_EXTERNAL_ID")
	private String clientExternalId;

	@Column(name="CLIENT_NAME")
	private String clientName;

	private String creator;

	@Column(name="LAST_MODIFIER")
	private String lastModifier;

	@Column(name="TS_LAST_MODIFIED")
	private Timestamp tsLastModified;

	//bi-directional many-to-one association to ModuleCategory
	@OneToMany(mappedBy="erfClient")
	private List<ModuleCategory> moduleCategories;

	//bi-directional many-to-one association to PackageDef
	@OneToMany(mappedBy="erfClient")
	private List<PackageDef> packageDefs;

	//bi-directional many-to-one association to ReportCategory
	@OneToMany(mappedBy="erfClient")
	private List<ReportCategory> reportCategories;

	//bi-directional many-to-one association to ReportParameter
	@OneToMany(mappedBy="erfClient")
	private List<ReportParameter> reportParameters;

	public ErfClient() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientCategory() {
		return this.clientCategory;
	}

	public void setClientCategory(String clientCategory) {
		this.clientCategory = clientCategory;
	}

	public String getClientExternalId() {
		return this.clientExternalId;
	}

	public void setClientExternalId(String clientExternalId) {
		this.clientExternalId = clientExternalId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getLastModifier() {
		return this.lastModifier;
	}

	public void setLastModifier(String lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Timestamp getTsLastModified() {
		return this.tsLastModified;
	}

	public void setTsLastModified(Timestamp tsLastModified) {
		this.tsLastModified = tsLastModified;
	}

	public List<ModuleCategory> getModuleCategories() {
		return this.moduleCategories;
	}

	public void setModuleCategories(List<ModuleCategory> moduleCategories) {
		this.moduleCategories = moduleCategories;
	}

	public ModuleCategory addModuleCategory(ModuleCategory moduleCategory) {
		getModuleCategories().add(moduleCategory);
		moduleCategory.setErfClient(this);

		return moduleCategory;
	}

	public ModuleCategory removeModuleCategory(ModuleCategory moduleCategory) {
		getModuleCategories().remove(moduleCategory);
		moduleCategory.setErfClient(null);

		return moduleCategory;
	}

	public List<PackageDef> getPackageDefs() {
		return this.packageDefs;
	}

	public void setPackageDefs(List<PackageDef> packageDefs) {
		this.packageDefs = packageDefs;
	}

	public PackageDef addPackageDef(PackageDef packageDef) {
		getPackageDefs().add(packageDef);
		packageDef.setErfClient(this);

		return packageDef;
	}

	public PackageDef removePackageDef(PackageDef packageDef) {
		getPackageDefs().remove(packageDef);
		packageDef.setErfClient(null);

		return packageDef;
	}

	public List<ReportCategory> getReportCategories() {
		return this.reportCategories;
	}

	public void setReportCategories(List<ReportCategory> reportCategories) {
		this.reportCategories = reportCategories;
	}

	public ReportCategory addReportCategory(ReportCategory reportCategory) {
		getReportCategories().add(reportCategory);
		reportCategory.setErfClient(this);

		return reportCategory;
	}

	public ReportCategory removeReportCategory(ReportCategory reportCategory) {
		getReportCategories().remove(reportCategory);
		reportCategory.setErfClient(null);

		return reportCategory;
	}

	public List<ReportParameter> getReportParameters() {
		return this.reportParameters;
	}

	public void setReportParameters(List<ReportParameter> reportParameters) {
		this.reportParameters = reportParameters;
	}

	public ReportParameter addReportParameter(ReportParameter reportParameter) {
		getReportParameters().add(reportParameter);
		reportParameter.setErfClient(this);

		return reportParameter;
	}

	public ReportParameter removeReportParameter(ReportParameter reportParameter) {
		getReportParameters().remove(reportParameter);
		reportParameter.setErfClient(null);

		return reportParameter;
	}

}