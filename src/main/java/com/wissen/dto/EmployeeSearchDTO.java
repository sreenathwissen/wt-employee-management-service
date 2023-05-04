package com.wissen.dto;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Data
@Builder
public class EmployeeSearchDTO {

    private String name;
    private String id;
    private String email;

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(Objects.isNull(obj) || getClass() != obj.getClass())
            return false;
        EmployeeSearchDTO that = (EmployeeSearchDTO) obj;
        return StringUtils.equalsIgnoreCase(this.name, that.name)
                && this.id == that.id
                && StringUtils.equalsIgnoreCase(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, email);
    }
}
