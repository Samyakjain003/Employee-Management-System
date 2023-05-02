package com.samyak.jain.crudapi.Service;

import com.samyak.jain.crudapi.DTO.EmployeeRequestDto;
import com.samyak.jain.crudapi.DTO.EmployeeResponseDto;
import com.samyak.jain.crudapi.Dao.AddressDao;
import com.samyak.jain.crudapi.Dao.EmployeeDao;
import com.samyak.jain.crudapi.Entity.Address;
import com.samyak.jain.crudapi.Entity.Employee;
import com.samyak.jain.crudapi.Mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;
    private AddressDao addressDao;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, AddressDao addressDao,EmployeeMapper employeeMapper){

        this.employeeDao=employeeDao;
        this.addressDao=addressDao;
        this.employeeMapper=employeeMapper;
    }
    @Override
    public List<EmployeeResponseDto> findAll() {
        List<Address> result= addressDao.findAll();
        List<EmployeeResponseDto> res=new ArrayList<>();
        for(Address a:result){
            res.add(employeeMapper.employeeToDto(a));
        }
        return res;
    }

    @Override
    public EmployeeResponseDto findById(int id) {

        Address address= addressDao.findByEmployeeId(id).orElseThrow(()-> new RuntimeException("Wrong id"+ id));
        return employeeMapper.employeeToDto(address);

    }


    @Override
    public EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto) {

        Employee manager = employeeDao.findById(employeeRequestDto.getManagerId()).orElseThrow(()-> new RuntimeException("Wrong id"));
        Address address=employeeMapper.employeeDTOToAddress(employeeRequestDto,manager);
        Address address1= addressDao.save(address);
        return employeeMapper.employeeToDto(address1);
    }


    @Override
    public void deleteById(int id) {
        addressDao.deleteById(id);
    }

    @Override
    public Address findByEmployeeId(int id) {
        return addressDao.findByEmployeeId(id).orElseThrow(()-> new RuntimeException("Wrong id"+ id));
    }

    @Override
    public EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto, int employeeId) {

        Address prevAddress=findByEmployeeId(employeeId);
        Employee manager = employeeDao.findById(employeeRequestDto.getManagerId()).orElseThrow(()-> new RuntimeException("Wrong id"));
        Address address=employeeMapper.employeeDTOToAddress(employeeRequestDto,manager);
        address.setId(prevAddress.getId());
        Address address1= addressDao.save(address);
        return employeeMapper.employeeToDto(address1);
    }

}
