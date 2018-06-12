package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	@Column(name="CREATOR_ID")
	private String creatorId;

	@Column(name="DISPLAY_NAME")
	private String displayName;

	private String format;

	@Column(name="MODCAT_ID")
	private int modcatId;

	@Column(name="MODIFY_TIME")
	private Timestamp modifyTime;

	private String name;

	@Lob
	@Column(name="SAMPLE_IMAGE")
	private byte[] sampleImage;

	private String type;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private Module module;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="module")
	private Set<Module> modules;

	//bi-directional many-to-one association to ModuleReportData
	@OneToMany(mappedBy="module")
	private Set<ModuleReportData> moduleReportData;

	public Module() {
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

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getModcatId() {
		return this.modcatId;
	}

	public void setModcatId(int modcatId) {
		this.modcatId = modcatId;
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

	public byte[] getSampleImage() {
		return this.sampleImage;
	}

	public void setSampleImage(byte[] sampleImage) {
		this.sampleImage = sampleImage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<Module> getModules() {
		return this.modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Module addModule(Module module) {
		getModules().add(module);
		module.setModule(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setModule(null);

		return module;
	}

	public Set<ModuleReportData> getModuleReportData() {
		return this.moduleReportData;
	}

	public void setModuleReportData(Set<ModuleReportData> moduleReportData) {
		this.moduleReportData = moduleReportData;
	}

	public ModuleReportData addModuleReportData(ModuleReportData moduleReportData) {
		getModuleReportData().add(moduleReportData);
		moduleReportData.setModule(this);

		return moduleReportData;
	}

	public ModuleReportData removeModuleReportData(ModuleReportData moduleReportData) {
		getModuleReportData().remove(moduleReportData);
		moduleReportData.setModule(null);

		return moduleReportData;
	}

}