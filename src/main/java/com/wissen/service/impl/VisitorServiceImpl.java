package com.wissen.service.impl;

import com.wissen.entity.Employee;
import com.wissen.enums.ResponseStatus;
import com.wissen.model.VisitorPointOfContactDetail;
import com.wissen.response.EmployeeManagementResponse;
import com.wissen.response.ResponseData;
import com.wissen.response.ResponseHeader;
import com.wissen.service.EmployeeService;
import com.wissen.service.VisitorService;
import com.wissen.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation class for visitor service.
 *
 * @author Vishal Tomar
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @{inheritDoc}
     */
    @Override
    public void getPointOfContactById(String wissenId, EmployeeManagementResponse<VisitorPointOfContactDetail> employeeManagementResponse) {
        try {
            Employee employee = this.employeeService.getEmployee(wissenId);
            VisitorPointOfContactDetail visitorPointOfContactDetail = Utils.getVisitorPointOfContact(employee);

            employeeManagementResponse.getResponseData().addData(visitorPointOfContactDetail);
            employeeManagementResponse.getResponseHeaders().setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoSuchElementException noSuchElementException) { // when no data found
            employeeManagementResponse.getResponseHeaders().setResponseStatus(ResponseStatus.SUCCESS);
        }
    }

    @Override
    public void searchPointOfContactById(String search, EmployeeManagementResponse<VisitorPointOfContactDetail> employeeManagementResponse) {
        try {
            List<Employee> employees = this.employeeService.getEmployeesBySearchString(search);
            List<VisitorPointOfContactDetail> visitorPointOfContactDetails = Utils.getVisitorPointOfContact(employees);

            employeeManagementResponse.getResponseData().addData(visitorPointOfContactDetails);
            employeeManagementResponse.getResponseHeaders().setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoSuchElementException noSuchElementException) { // when no data found
            employeeManagementResponse.getResponseHeaders().setResponseStatus(ResponseStatus.SUCCESS);
        }
    }

}
