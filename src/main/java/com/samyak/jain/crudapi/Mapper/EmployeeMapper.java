package com.samyak.jain.crudapi.Mapper;

import com.samyak.jain.crudapi.DTO.EmployeeRequestDto;
import com.samyak.jain.crudapi.DTO.EmployeeResponseDto;
import com.samyak.jain.crudapi.Entity.Address;
import com.samyak.jain.crudapi.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeResponseDto employeeToDto(Address address){

        Employee employee=address.getEmployee();
        Employee manager=employee.getManager();
        EmployeeResponseDto employeeDto=new EmployeeResponseDto();
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setId(employee.getId());
        employeeDto.setLocation(employee.getLocation());
        employeeDto.setManager(manager.getFirstName()+" "+manager.getLastName());
        employeeDto.setRole(employee.getRole());
        employeeDto.setAddress(address.getHouseNo()+", "+address.getCity()+", "+address.getPincode());
        return employeeDto;
    }
    public Address employeeDTOToAddress(EmployeeRequestDto employeeRequestDto, Employee manager){

        //Address address=employee.getAddress();
        Employee employee=new Employee();
        Address address=new Address();

        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setRole(employeeRequestDto.getRole());
        employee.setLocation(employeeRequestDto.getLocation());
        employee.setManager(manager);

        address.setHouseNo(employeeRequestDto.getHouseNo());
        address.setCity(employeeRequestDto.getCity());
        address.setPincode(employeeRequestDto.getPincode());
        address.setMobileNo(employeeRequestDto.getMobileNo());

        address.setEmployee(employee);
        return address;
    }
}
