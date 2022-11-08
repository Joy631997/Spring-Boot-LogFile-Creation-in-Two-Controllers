package com.example.LogsFileCreationTwoLoggers.Controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log/")
public class LogCreationTwoLoggersController {

	@RequestMapping(value = "checklog", method = RequestMethod.GET)
	public ResponseEntity<?> operationMethod(@RequestParam Map<String, String> requestParam) throws Exception {
		Logger log = LogManager.getLogger("LogCheck1");
		try {

			log.debug("testAPI started: " + "Hello");
			log.info("testAPI started: " + requestParam);
		} catch (Exception e) {
			log.error("Error message");
			log.error(e);
			System.out.println((e.getMessage()));
		}

		return new ResponseEntity<>(requestParam, HttpStatus.OK);
	}
}
