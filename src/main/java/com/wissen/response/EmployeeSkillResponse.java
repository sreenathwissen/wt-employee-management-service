package com.wissen.response;

import com.wissen.entity.Skill;
import com.wissen.enums.Levels;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeSkillResponse {

    int empId;
    Skill skill;
    Levels levels;
}
