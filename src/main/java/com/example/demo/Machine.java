package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Machine {
	
	@Id
	private int mid;
	private String mname;
	private String mlang;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMlang() {
		return mlang;
	}
	public void setMlang(String mlang) {
		this.mlang = mlang;
	}
}
