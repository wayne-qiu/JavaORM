package erf.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lookup_type database table.
 * 
 */
@Entity
@Table(name="lookup_type")
@NamedQuery(name="LookupType.findAll", query="SELECT l FROM LookupType l")
public class LookupType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int client;

	private String description;

	private String name;

	@Column(name="PUBLIC")
	private short public_;

	private String type;

	//bi-directional many-to-one association to ModuleParameter
	@OneToMany(mappedBy="lookupTypeBean")
	private List<ModuleParameter> moduleParameters;

	public LookupType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClient() {
		return this.client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getPublic_() {
		return this.public_;
	}

	public void setPublic_(short public_) {
		this.public_ = public_;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ModuleParameter> getModuleParameters() {
		return this.moduleParameters;
	}

	public void setModuleParameters(List<ModuleParameter> moduleParameters) {
		this.moduleParameters = moduleParameters;
	}

	public ModuleParameter addModuleParameter(ModuleParameter moduleParameter) {
		getModuleParameters().add(moduleParameter);
		moduleParameter.setLookupTypeBean(this);

		return moduleParameter;
	}

	public ModuleParameter removeModuleParameter(ModuleParameter moduleParameter) {
		getModuleParameters().remove(moduleParameter);
		moduleParameter.setLookupTypeBean(null);

		return moduleParameter;
	}

}