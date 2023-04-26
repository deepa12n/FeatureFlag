package com.md.demo.vo;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class GeneratedMD {

	private byte[] shaValue;
	
	private String hexValue;

	public String getHexValue() {
		return hexValue;
	}

	public void setHexValue(String hexValue) {
		this.hexValue = hexValue;
	}

	public byte[] getShaValue() {
		return shaValue;
	}

	public void setShaValue(byte[] shaValue) {
		this.shaValue=shaValue;
		
	}
}
