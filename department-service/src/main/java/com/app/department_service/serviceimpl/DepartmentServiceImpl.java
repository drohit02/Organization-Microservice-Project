package com.app.department_service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.department_service.dto.DepartmentDto;
import com.app.department_service.entity.Department;
import com.app.department_service.repository.DepartmentRepository;
import com.app.department_service.service.DepartmentService;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DepartmentRepository departmentRepository;

	// Convert DepartmentDto to Department
	private Department getDepartmentFromDto(DepartmentDto department) {
		return this.modelMapper.map(department, Department.class);
	}
	
	//Convert Department to DepartmentDto
	private DepartmentDto getDepartmentDtoFromEntity(Department department) {
		return this.modelMapper.map(department,DepartmentDto.class);
	}

	@Transactional
	@Override
	public DepartmentDto savedDepartementData(DepartmentDto departmentData) {
		Department department = this.getDepartmentFromDto(departmentData);
		Department saveDepartment = this.departmentRepository.save(department);
		return this.getDepartmentDtoFromEntity(saveDepartment);
	}

}
