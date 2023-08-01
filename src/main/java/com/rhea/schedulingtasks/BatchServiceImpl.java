package com.rhea.schedulingtasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;



@Service
public class BatchServiceImpl implements BatchService{
	@Autowired 
	BatchDaoImpl BatchDao;
	
	@Override
	public void insertBatch(Batch cit) {
		BatchDao.insertBatch(cit);
		
	}
	
}
