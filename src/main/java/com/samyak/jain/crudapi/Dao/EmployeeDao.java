package com.samyak.jain.crudapi.Dao;

import com.samyak.jain.crudapi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
