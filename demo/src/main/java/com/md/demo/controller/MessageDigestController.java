package com.md.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.demo.service.MessageDigestService;
import com.md.demo.vo.FlagData;
import com.md.demo.vo.Flags;
import com.md.demo.vo.GeneratedMD;

@RestController
@RequestMapping(path = "/api")
public class MessageDigestController {

	@Autowired
	MessageDigestService messageDigestService;

	@PostMapping(path = "/getMessageDigest", consumes = "application/json", produces = "application/json")
	public GeneratedMD getMessageDigestHash(@RequestBody FlagData fd) {
		return messageDigestService.getMessageDigest(fd);
	}
	
	@PostMapping(path = "/compareMessageDigests", consumes = "application/json")
	public Boolean compareMDHash(@RequestBody Flags flags) {
		return messageDigestService.comapreMessageDigest(flags);
	}

}
