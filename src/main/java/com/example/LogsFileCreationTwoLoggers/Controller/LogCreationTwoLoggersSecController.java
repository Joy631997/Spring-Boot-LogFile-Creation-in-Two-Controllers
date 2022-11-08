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
@RequestMapping("/log2/")
public class LogCreationTwoLoggersSecController {

	@RequestMapping(value = "checklog2", method = RequestMethod.GET)
	public ResponseEntity<?> operationMethod1(@RequestParam Map<String, String> requestParam) throws Exception {
		Logger log1 = LogManager.getLogger("LogCheck2");
		try {

			log1.debug("testAPI started: " + requestParam);
			log1.info("testAPI started: " + requestParam);
			log1.debug("testing" + requestParam);
			log1.error("This is the error message of logger2");
		} catch (Exception e) {
			log1.error("Error message for logger2");
			log1.error(e);
			System.out.println((e.getMessage()));
		}

		return new ResponseEntity<>(requestParam, HttpStatus.OK);
	}
}
