package erf.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the module_parameter database table.
 * 
 */
@Entity
@Table(name="module_parameter")
@NamedQuery(name="ModuleParameter.findAll", query="SELECT m FROM ModuleParameter m")
public class ModuleParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private short editable;

	private int level;

	private String name;

	private short required;

	private String type;

	private String value;

	//bi-directional many-to-one association to ReportParameter
	@ManyToOne
	@JoinColumn(name="PARAMETER_ID")
	private ReportParameter reportParameter;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	//bi-directional many-to-one association to LookupType
	@ManyToOne
	@JoinColumn(name="LOOKUP_TYPE")
	private LookupType lookupTypeBean;

	public ModuleParameter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public short getEditable() {
		return this.editable;
	}

	public void setEditable(short editable) {
		this.editable = editable;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getRequired() {
		return this.required;
	}

	public void setRequired(short required) {
		this.required = required;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ReportParameter getReportParameter() {
		return this.reportParameter;
	}

	public void setReportParameter(ReportParameter reportParameter) {
		this.reportParameter = reportParameter;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public LookupType getLookupTypeBean() {
		return this.lookupTypeBean;
	}

	public void setLookupTypeBean(LookupType lookupTypeBean) {
		this.lookupTypeBean = lookupTypeBean;
	}

}