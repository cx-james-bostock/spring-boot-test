package com.checkmarx.ps.restservice;

import org.springframework.stereotype.Component;

@Component
public class RequestBuilder {
    public ValidateUnsafeObjectBindingRequest buildValidateUnsafeObjectBindingRequest(
	    ValidateIUnsafeObjectBindingRequest validateIUnsafeObjectBindingRequest) {
	ValidateUnsafeObjectBindingRequest validateUserCredentialRequest =
		new ValidateUnsafeObjectBindingRequest();
	validateUserCredentialRequest.setUserId(validateIUnsafeObjectBindingRequest.getUserId());
	return validateUserCredentialRequest;
    }
}
