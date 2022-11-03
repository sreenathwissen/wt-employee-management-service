package com.wissen.service;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;

import java.util.List;

public interface AddressService {

    public Address saveAddress(Address address, Employee employee);

    public List<Address> getAddressByEmployeeId(int empId);
}
