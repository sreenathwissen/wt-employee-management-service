package com.wissen.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model class contains details of point of contact of visitors.
 *
 * @author Vishal Tomar
 */
@Data
@Builder
public class VisitorPointOfContactDetail {

    private String wissenId;
    private String firstName;
    private String lastName;
    private String email;
}
