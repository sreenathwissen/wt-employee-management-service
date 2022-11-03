package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    String flatNo;
    String street;
    String pincode;
    String addressType;
    String city;
    String country;
    String state;
}
