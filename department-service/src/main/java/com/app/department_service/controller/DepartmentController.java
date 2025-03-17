package com.app.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.department_service.dto.DepartmentDto;
import com.app.department_service.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Operation(summary = "CREATE-NEW-DEPARTMENT", description = "API-FOR-SAVING-DEPARTMENT-DATA")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "DEPARTMENT-SUCCESSFULLY-SAVED", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDto.class))),
			@ApiResponse(responseCode = "400", description = "INVALID-DEPARTMENT-DATA", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
			@ApiResponse(responseCode = "500", description = "INTERNAL-SERVER-ERROR", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) 
	})
	@PostMapping
	public ResponseEntity<DepartmentDto> savedDepartmentData(@RequestBody DepartmentDto department) {
		DepartmentDto savedDepartment = this.departmentService.savedDepartementData(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
	}

}
