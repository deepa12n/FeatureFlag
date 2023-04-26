package com.md.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PublishData {
 
	String tableName;
	String columnName;
	Object originalDataValue;
	Object updatedDataValue;
	String projectId;

}
