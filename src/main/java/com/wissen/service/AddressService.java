package com.wissen.service;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;

public interface AddressService {
    public Address saveAddress(Address address, Employee employee);
}
