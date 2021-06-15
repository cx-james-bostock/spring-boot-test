package com.checkmarx.ps.restservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetPasswordRequest {
    private String userId;
    private String newPassword;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
