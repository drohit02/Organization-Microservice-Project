package com.app.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
	
	private Long departmentId;
	
	private String departmentName;
	
	private String departmentDescription;
	
	private String departmentCode;
 
}
