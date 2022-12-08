package com.wissen.service.impl;
import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import com.wissen.repository.DesignationRepository;
import com.wissen.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public List<Designation> saveDesignations(final List<String> designations) {
        List<Designation> designationEntities = designations.stream()
                .map(designation -> getDesignations(designation))
                .collect(Collectors.toList());
        return this.designationRepository.saveAll(designationEntities);
    }

    @Override
    public List<Designation> searchDesignations(String searchString) {
        List<Designation> designations = new ArrayList<>();
        designations.addAll(this.designationRepository.getDesignationByPattern(searchString));
        return designations;
    }

    private Designation getDesignations(String designation){
        Designation designationEntity = new Designation();
        designationEntity.setDesgName(designation);
        return designationEntity;
    }

    @Override
    public List<Designation> getAllDesignation(){
        return designationRepository.findAll();
    }

    @Override
    public Designation getDesignationById(int id){
        return designationRepository.findById(id).get();
    }

    @Override
    public Designation getDesignationByName(String name) {
        return this.designationRepository.getDesignationByDesgName(name);
    }
}

