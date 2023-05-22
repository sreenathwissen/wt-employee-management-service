package com.wissen.service;

import com.wissen.model.VisitorPointOfContactDetail;
import com.wissen.response.EmployeeManagementResponse;

/**
 * Interface class handle operation for visitor management tool.
 *
 * @author Vishal Tomar
 */
public interface VisitorService {

    /**
     * Method to get point of contact info by wissen id.
     *
     * @param wissenId
     * @return visitorPointOfContactDetail
     */
    public void getPointOfContactById(String wissenId, EmployeeManagementResponse<VisitorPointOfContactDetail> employeeManagementResponse);

    /**
     * Method to search point of contact info by wissen id.
     *
     * @param search
     * @return visitorPointOfContactDetail
     */
    public void searchPointOfContactById(String search, EmployeeManagementResponse<VisitorPointOfContactDetail> employeeManagementResponse);
}
