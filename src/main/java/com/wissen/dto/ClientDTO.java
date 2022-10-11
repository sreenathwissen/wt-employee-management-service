package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ClientDTO {

    @NotNull(message = "Client name is null")
    @NotEmpty(message = "Client name cannot be empty.")
    private String clientName;

    @NotNull(message = "Client location is null")
    @NotEmpty(message = "Movie location cannot be empty.")
    private String clientLocation;
}
