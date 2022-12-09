package com.wissen.validate;

import com.wissen.exception.EmployeeExcelValidationException;
import org.springframework.web.multipart.MultipartFile;

public interface BulkUploadValidation {

    public void validate(MultipartFile dataFile) throws EmployeeExcelValidationException;

}
