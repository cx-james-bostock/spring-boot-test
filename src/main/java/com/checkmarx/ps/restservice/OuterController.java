package com.checkmarx.ps.restservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RequestMapping("/outer")
@RestController
public class OuterController {
    private final static Log log = LogFactory.getLog(OuterController.class);

    @RequestMapping(value="/outer", method=RequestMethod.POST)
    public void createOuter(@RequestBody Outer outer) {
	log.info(String.format("createOuter: outer.inner.value is %s", outer.getInner().getValue()));
    }
}
