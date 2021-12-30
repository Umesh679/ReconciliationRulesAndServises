package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class RuleServiceCondition {
	
	@Id
    private long b_id;
	
	@Column(name = "fielddata")
	String fielddata;
	
	@Column(name = "Conditiondata")
	String conditiondata;
	
	@Column(name = "Valuedata")
	String valuedata;

	public long getB_id() {
		return b_id;
	}

	public void setB_id(long b_id) {
		this.b_id = b_id;
	}

	public String getFielddata() {
		return fielddata;
	}

	public void setFielddata(String fielddata) {
		this.fielddata = fielddata;
	}

	public String getConditiondata() {
		return conditiondata;
	}

	public void setConditiondata(String conditiondata) {
		this.conditiondata = conditiondata;
	}

	public String getValuedata() {
		return valuedata;
	}

	public void setValuedata(String valuedata) {
		this.valuedata = valuedata;
	}

	@Override
	public String toString() {
		return "RuleServiceCondition [b_id=" + b_id + ", fielddata=" + fielddata + ", conditiondata=" + conditiondata
				+ ", valuedata=" + valuedata + ", getB_id()=" + getB_id() + ", getFielddata()=" + getFielddata()
				+ ", getConditiondata()=" + getConditiondata() + ", getValuedata()=" + getValuedata() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public RuleServiceCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

}
