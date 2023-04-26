package com.md.demo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
public class FlagData implements Serializable{

	private static final long serialVersionUID = 1L;
	private int flagId;
	private String flagName;
	private Boolean flagStatus;
	
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public Boolean getFlagStatus() {
		return flagStatus;
	}
	public void setFlagStatus(Boolean flagStatus) {
		this.flagStatus = flagStatus;
	}
	
}
