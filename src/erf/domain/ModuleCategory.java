package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the module_category database table.
 * 
 */
@Entity
@Table(name="module_category")
@NamedQuery(name="ModuleCategory.findAll", query="SELECT m FROM ModuleCategory m")
public class ModuleCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	private String name;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="moduleCategory")
	private List<Module> modules;

	//bi-directional many-to-one association to ErfClient
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private ErfClient erfClient;

	public ModuleCategory() {
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

	public List<Module> getModules() {
		return this.modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Module addModule(Module module) {
		getModules().add(module);
		module.setModuleCategory(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setModuleCategory(null);

		return module;
	}

	public ErfClient getErfClient() {
		return this.erfClient;
	}

	public void setErfClient(ErfClient erfClient) {
		this.erfClient = erfClient;
	}

}