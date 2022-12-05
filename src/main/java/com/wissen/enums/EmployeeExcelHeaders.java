package com.wissen.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum EmployeeExcelHeaders {

    BLOOD_GROUP(0, "BLOOD_GROUP"),
    DOB(1, "DOB"),
    DOJ(2, "DOJ"),
    EMAIL(3, "EMAIL"),
    EXIT_DATE(4, "EXIT_DATE"),
    EXP_DOJ(5, "EXP_DOJ"),
    FIRST_NAME(6, "FIRST_NAME"),
    GENDER(7, "GENDER"),
    JOINING_LOCATION(8, "JOINING_LOCATION"),
    LAST_NAME(9, "LAST_NAME"),
    MANAGER(10, "MANAGER"),
    MARITAL_STATUS_DATE(11, "MARITAL_STATUS_DATE"),
    PRIMARY_EMERGENCY_CONTACT_NUMBER(12, "PRIMARY_EMERGENCY_CONTACT_NUMBER"),
    PRIMARY_PHONE_NUMBER(13, "PRIMARY_PHONE_NUMBER"),
    SECONDARY_EMERGENCY_CONTACT_NUMBER(14, "SECONDARY_EMERGENCY_CONTACT_NUMBER"),
    SECONDARY_PHONE_NUMBER(15, "SECONDARY_PHONE_NUMBER"),
    STATUS(16, "STATUS"),
    TYPE(17, "TYPE"),
    WORK_PHONE(18, "WORK_PHONE"),
    DEPARTMENT(19, "DEPARTMENT"),
    DESIGNATION(20, "DESIGNATION"),
    ROLE(21, "ROLE");

    private int index;
    private String value;

    EmployeeExcelHeaders(int index, String value) {
        this.value = value;
        this.index = index;
    }

    public static EmployeeExcelHeaders getHeaders(int i){
        EmployeeExcelHeaders headers[] = EmployeeExcelHeaders.values();
        return headers[i];
    }

    public static Set<String> getValuesSet() {
        return Arrays.asList(EmployeeExcelHeaders.values()).stream().map(employeeExcelHeaders -> employeeExcelHeaders.getValue())
                .collect(Collectors.toSet());
    }
}
