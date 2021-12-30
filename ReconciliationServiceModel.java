package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class ReconciliationServiceModel {

	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long s_id;
    
    @Column(name = "RuleName")
	String ruleName;
	
	@Column(name = "RuleVersion")
	String ruleVersion;
	
	@Column(name = "RulePriority")
	Integer rulePriority;
	
	@Column(name = "IsActive")
	Boolean isActive;
	
	 @OneToMany( targetEntity=RuleServiceCondition.class)
	private List service_issued;

	public long getS_id() {
		return s_id;
	}

	public void setS_id(long s_id) {
		this.s_id = s_id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleVersion() {
		return ruleVersion;
	}

	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}

	public Integer getRulePriority() {
		return rulePriority;
	}

	public void setRulePriority(Integer rulePriority) {
		this.rulePriority = rulePriority;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List getService_issued() {
		return service_issued;
	}

	public void setService_issued(List service_issued) {
		this.service_issued = service_issued;
	}  
    
   
   
	
	

	

	
}
