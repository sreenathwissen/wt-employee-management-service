package com.wissen.controller;

import com.wissen.entity.Address;
import com.wissen.service.AddressService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@Slf4j
@Validated
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    @ApiOperation("Get addresses of employee")
    public ResponseEntity<List<Address>> getAddressesByEmployeeId(
            @RequestParam @NotNull(message = "Employee id is null") int employeeId) {
        log.info("START : Getting address by emp id");
        List<Address> addresses = this.addressService.getAddressByEmployeeId(employeeId);
        log.info("START : Getting address by emp id");
        return ResponseEntity.status(HttpStatus.OK)
                .body(addresses);
    }
}
