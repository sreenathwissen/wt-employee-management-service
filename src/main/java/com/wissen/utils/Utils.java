package com.wissen.utils;

import com.wissen.entity.Employee;
import com.wissen.model.VisitorPointOfContactDetail;
import com.wissen.response.EmployeeManagementResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class.
 *
 * @author Vishal Tomar
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    /**
     * Method to get visitorPointOfContact object by employee object.
     *
     * @param employee
     * @return visitorPointOfContact
     */
    public static VisitorPointOfContactDetail getVisitorPointOfContact(Employee employee) {
        return VisitorPointOfContactDetail.builder()
                .wissenId(employee.getEmployeeWissenId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

    /**
     * Method to get list visitorPointOfContact object by employee object.
     *
     * @param employees
     * @return visitorPointOfContacts
     */
    public static List<VisitorPointOfContactDetail> getVisitorPointOfContact(List<Employee> employees) {
        return employees.stream().map(employee -> getVisitorPointOfContact(employee)).collect(Collectors.toList());
    }

}
