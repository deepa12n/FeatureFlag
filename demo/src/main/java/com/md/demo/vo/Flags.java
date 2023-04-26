package com.md.demo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
public class Flags implements Serializable {

	private static final long serialVersionUID = 1L;
	private FlagData FlagDataSource;
	private FlagData FlagDataDestination;
	
	public FlagData getFlagDataSource() {
		return FlagDataSource;
	}
	public void setFlagDataSource(FlagData flagDataSource) {
		FlagDataSource = flagDataSource;
	}
	public FlagData getFlagDataDestination() {
		return FlagDataDestination;
	}
	public void setFlagDataDestination(FlagData flagDataDestination) {
		FlagDataDestination = flagDataDestination;
	}
	
	

}
