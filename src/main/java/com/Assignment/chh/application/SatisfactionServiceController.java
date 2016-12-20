package com.Assignment.chh.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.chh.constant.Constants;
import com.Assignment.chh.service.SatisfactionService;



/**
 * 
 * @author naveenkumar300@gmail.com
 *
 */

/**
 * This class is a controller for getting maximum satisfaction 
 * 
 *
 */
@Service

public class SatisfactionServiceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SatisfactionServiceController.class);
	
	 @Autowired
	private  SatisfactionService satisfactionService;

	
	public  void findMaxSatisfaction() {

		
		String fileName=Constants.FILE_NAME;
		try {
			LOGGER.info("SatisfactionServiceController: starts");
		satisfactionService.getMaxSatisfaction(fileName);

			
			LOGGER.info("SatisfactionServiceController: END");
		}  catch (Exception e) {
			LOGGER.error("SatisfactionServiceController: Exception: " + e + ": " + e.toString());
			e.getCause();
			
		
		}
		
		
	}
	
}
