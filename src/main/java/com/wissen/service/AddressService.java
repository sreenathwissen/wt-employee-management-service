package com.wissen.service;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;

import java.util.List;

public interface AddressService {

    public List<Address> saveAddresses(List<Address> address);

    public List<Address> getAddressByEmployeeId(int empId);
}
