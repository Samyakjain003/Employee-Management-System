package com.samyak.jain.crudapi.Service;

import com.samyak.jain.crudapi.DTO.EmployeeRequestDto;
import com.samyak.jain.crudapi.DTO.EmployeeResponseDto;
import com.samyak.jain.crudapi.Entity.Address;
import com.samyak.jain.crudapi.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeResponseDto> findAll();

    EmployeeResponseDto findById(int id);

    EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto);

    void deleteById(int id);

    Address findByEmployeeId(int id);

    EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto, int employeeId);
}
