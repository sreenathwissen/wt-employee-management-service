package com.wissen.service.impl;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import com.wissen.repository.AddressRepository;
import com.wissen.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> saveAddresses(List<Address> addresses) {
        return this.addressRepository.saveAll(addresses);
    }

    @Override
    public List<Address> getAddressByEmployeeId(int empId) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        return this.addressRepository.getAddressByEmployee(emp);
    }
}
