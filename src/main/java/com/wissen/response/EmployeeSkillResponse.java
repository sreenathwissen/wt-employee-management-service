package com.wissen.response;

import com.wissen.entity.Skill;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee skill response class.
 *
 * @author Vishal Tomar
 */
@Data
@NoArgsConstructor
public class EmployeeSkillResponse {

    String wissenId;
    Skill skill;
    int levels;
}
