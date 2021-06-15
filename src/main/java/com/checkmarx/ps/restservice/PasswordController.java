package com.checkmarx.ps.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

@RestController
public class PasswordController {
    private final static Log log = LogFactory.getLog(PasswordController.class);
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/password")
    public void setPassword(@RequestBody SetPasswordRequest req) {
	log.info(String.format("setPassword: setting password for usrId: %s", req.getUserId()));

	jdbcTemplate.update("UPDATE password SET password = ? WHERE userId = ?", req.getNewPassword(), req.getUserId());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }
}