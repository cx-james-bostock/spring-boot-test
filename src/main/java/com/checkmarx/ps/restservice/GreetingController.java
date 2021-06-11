package com.checkmarx.ps.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

@RestController
public class GreetingController {
    private final static Log log = LogFactory.getLog(GreetingController.class);
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
	log.info(String.format("greeting: name: %s", name));
	List<Greeting> greetingList = jdbcTemplate.query("SELECT id, content from GREETING where name = ?",
		(rs, rowNum) -> new Greeting(rs.getLong("id"), rs.getString("content")),
		name);
	if (greetingList.size() == 1) {
	    return greetingList.get(0);
	} else if (greetingList.size() == 0) {
	    // Note that, by default, the message is not added to the response
	    // See https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#changes-to-the-default-error-pages-content
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
	} else {
	    // Note that, by default, the message is not added to the response
	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Multiple users found");
	}
    }
    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }
}