package com.wissen.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class EmployeeProjectDTO {

    @NotNull(message = "Wissen id is null")
    private String employeeWissenId;

    @NotNull(message = "Project id is null")
    @Min(value = 1, message = "Please provide valid projectId")
    private int projectId;

    @NotNull(message = "Date of Onboarding is null")
    private LocalDate dojOnboarding;

    private LocalDate dorOnboarding;

    @NotNull(message = "Employee Project id is null")
    @Min(value = 0, message = "Please provide valid employee projectId")
    private int employeeProjectId;
}
