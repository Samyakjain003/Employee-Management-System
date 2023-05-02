package com.samyak.jain.crudapi.Rest;

import com.samyak.jain.crudapi.DTO.EmployeeRequestDto;
import com.samyak.jain.crudapi.DTO.EmployeeResponseDto;
import com.samyak.jain.crudapi.Entity.Address;
import com.samyak.jain.crudapi.Entity.Employee;
import com.samyak.jain.crudapi.Mapper.EmployeeMapper;
import com.samyak.jain.crudapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeMapper employeeMapper;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
        employeeMapper=new EmployeeMapper();
    }
    @GetMapping("/employees")
    public List<EmployeeResponseDto> getEmployees(){
      //  List<Employee> emp=employeeService.findAll();
        List<EmployeeResponseDto> result=employeeService.findAll();
//        for(Employee e:emp){
//            result.add(employeeMapper.employeeToDto(e,employeeService.findById(e.getManagerId())));
//        }
        return result;
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeResponseDto getEmployee(@PathVariable int employeeId){
        EmployeeResponseDto e= employeeService.findById(employeeId);

        if(e==null){
            throw new RuntimeException("Employee does not exist: "+employeeId);
        }
        return e;
    }

    @PostMapping("/employees")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){


        return employeeService.saveEmployee(employeeRequestDto);
    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeResponseDto updateEmployee(@RequestBody EmployeeRequestDto employeeRequestDto, @PathVariable int employeeId){
        Address address=employeeService.findByEmployeeId(employeeId);
        if(address==null){
            throw new RuntimeException("Employee does not exist");
        }
        return employeeService.updateEmployee(employeeRequestDto,employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Address address =employeeService.findByEmployeeId(employeeId);


        employeeService.deleteById(address.getId());

        return "Employee Deleted: "+ employeeId;
    }


}
