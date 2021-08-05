package com.checkmarx.ps.restservice;

import lombok.Data;

@Data
public class ValidateUnsafeObjectBindingRequest {

    private String userId;
    
    private String foo;
}
