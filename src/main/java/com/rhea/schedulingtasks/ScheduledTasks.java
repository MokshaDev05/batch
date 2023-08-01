package com.rhea.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	BatchService batchService;

	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		
		//connect to database aand do an insert.
		
		Batch city = new Batch();
		
		city.setBatchName("batchname::"  + new Date());
		city.setBatchDetail("batchDetail::" + new Date());
		
		batchService.insertBatch(city);
		
		
		
	}
}