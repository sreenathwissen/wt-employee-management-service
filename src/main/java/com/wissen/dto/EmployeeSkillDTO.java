package com.wissen.dto;

import com.wissen.enums.Levels;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeSkillDTO {
    int skillId;
    String skillName;
    Levels levels;
}
