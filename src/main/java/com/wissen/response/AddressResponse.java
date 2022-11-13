package com.wissen.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressResponse {

    int addrId;
    String flatNo;
    String street;
    String pincode;
    String addressType;
    String city;
    String country;
    String state;
    int empId;
}
