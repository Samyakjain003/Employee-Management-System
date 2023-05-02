package com.samyak.jain.crudapi.Dao;

import com.samyak.jain.crudapi.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressDao extends JpaRepository<Address, Integer> {
    Optional<Address> findByEmployeeId(int id);

    // void deleteByEmployeeId(int id);

}
