package com.wissen.service;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;

import java.util.List;

public interface DesignationService {

    public List<Designation> saveDesignations(final List<String> designations);

    public List<Designation> searchDesignations(final String searchString);

    public List<Designation> getAllDesignation();

    public Designation getDesignationById(int id);

    public Designation getDesignationByName(String name);
}
