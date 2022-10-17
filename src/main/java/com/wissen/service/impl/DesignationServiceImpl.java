package com.wissen.service.impl;
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
    public void saveDesignations(final List<String> designations) {
        List<Designation> designationEntities = designations.stream()
                .map(designation -> getDesignations(designation))
                .collect(Collectors.toList());
        this.designationRepository.saveAll(designationEntities);
    }

    private Designation getDesignations(String designation){
        Designation designationEntity = new Designation();
        designationEntity.setDesgName(designation);
        return designationEntity;
    }

    @Override
    public List<Designation> getAllDesignation(){
        List<Designation> designations = new ArrayList<Designation>();
        designationRepository.findAll().forEach(designation -> designations.add(designation));
        return designations;
    }

    @Override
    public Designation getDesignationById(int id){
        return designationRepository.findById(id).get();
    }
}

