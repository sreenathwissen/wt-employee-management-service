package com.wissen.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Global response
 *
 * @author Vishal Tomar
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeManagementResponse<T> {

    ResponseData<T> responseData = new ResponseData<>();
    ResponseHeader responseHeaders = new ResponseHeader();
}
