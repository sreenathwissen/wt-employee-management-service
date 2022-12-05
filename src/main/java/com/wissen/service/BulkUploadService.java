package com.wissen.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BulkUploadService {

    public void bulkUploadToDb(MultipartFile dataFile);
}
