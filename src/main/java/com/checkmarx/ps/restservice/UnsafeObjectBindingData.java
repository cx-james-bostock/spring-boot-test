package com.checkmarx.ps.restservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UnsafeObjectBindingData {

    @Id
    private Long id;
    private String foo;
}
