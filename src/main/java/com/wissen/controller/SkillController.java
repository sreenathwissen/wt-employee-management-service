package com.wissen.controller;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import com.wissen.entity.Skill;
import com.wissen.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@Validated
@Slf4j
@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    public ResponseEntity<List<Skill>> saveSkill(@RequestBody @NotEmpty(message = "Skill list is empty") final List<String> skills){
        log.info("Starting to save Skills");
        List<Skill> savedSkills = this.skillService.saveSkills(skills);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedSkills);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Skill>> searchSkills(@RequestParam final String skill) {
        log.info("START: Getting skills");
        List<Skill> skills = this.skillService.searchSkills(skill);
        log.info("START: Getting skills");
        return ResponseEntity.status(HttpStatus.OK)
                .body(skills);
    }

    @GetMapping
    public List<Skill> getAllSkills(){
        log.info("Starting to fetch the skills");
        return skillService.getAllSkills();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Skill> getSkillById(@PathVariable int id){
        return new ResponseEntity<>(skillService.getSkillById(id),HttpStatus.OK);
    }
}
