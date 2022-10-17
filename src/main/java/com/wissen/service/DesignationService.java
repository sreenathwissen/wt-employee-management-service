package com.wissen.service;

import com.wissen.entity.Designation;

import java.util.List;

public interface DesignationService {
    public void saveDesignations(final List<String> designations);
    public List<Designation> getAllDesignation();
    public Designation getDesignationById(int id);
}
