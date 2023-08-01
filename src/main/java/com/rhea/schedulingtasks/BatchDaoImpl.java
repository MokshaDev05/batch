package com.rhea.schedulingtasks;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;




@Repository
public class BatchDaoImpl implements BatchDao{
	
	public BatchDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template; 
	
	@Override
	public void insertBatch(Batch cit) {
		 final String sql = "insert into batch(batchName , batchDetail) values(:batchName,:batchDetail)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					//.addValue("batchId", cit.getBatchId())
					.addValue("batchName", cit.getBatchName())
					
					.addValue("batchDetail", cit.getBatchDetail());
	        template.update(sql,param, holder);
	 
	}
	

	
	
	
	
	
}
