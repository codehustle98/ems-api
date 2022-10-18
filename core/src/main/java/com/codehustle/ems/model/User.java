package com.codehustle.ems.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class User implements Serializable {

    @NotNull
    private String empEmailId;
    @NotNull
    private String loginPassword;
}
