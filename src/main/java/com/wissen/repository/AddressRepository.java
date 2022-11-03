package com.wissen.repository;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> getAddressByEmployee(Employee employee);
}
