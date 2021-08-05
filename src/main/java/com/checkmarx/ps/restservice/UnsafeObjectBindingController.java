package com.checkmarx.ps.restservice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UnsafeObjectBindingController {

    @Autowired
    private RequestBuilder requestBuilder;

    @Autowired
    private UnsafeObjectBindingRepository userAuditLoginRepository;

    @PostMapping(value = "/validate",
	    consumes = "application/json")
    public void validateUserCredentials(@RequestBody ValidateIUnsafeObjectBindingRequest validateIUnsafeObjectBindingRequest) {
	ValidateUnsafeObjectBindingRequest validateUnsafeObjectBindingRequest = requestBuilder
		.buildValidateUnsafeObjectBindingRequest(validateIUnsafeObjectBindingRequest);
	logUserActivity(validateUnsafeObjectBindingRequest.getFoo());
    }
    
    public void logUserActivity(String foo) {
	UnsafeObjectBindingData userAuditLogin = new UnsafeObjectBindingData();
	userAuditLogin.setFoo(foo);
	userAuditLoginRepository.save(userAuditLogin);
    }
}
