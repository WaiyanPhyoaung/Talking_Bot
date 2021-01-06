package com.bot.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dictionary {
	
	private static final String INSERT = "INSERT INTO bot (question,answer) values (?,?)";
	private static final String QUERY = "SELECT answer FROM bot WHERE ";
	
	public static String search(String question) {
		
		String answer = "";
		
		StringBuilder query = new StringBuilder(QUERY);
		
		if(null!=question) 
			query.append("question like '"+ question +"'");// question like 'hello --'
		
		try {
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement prep = conn.prepareStatement(query.toString());
				
				System.out.println(query.toString());
				
				ResultSet result = prep.executeQuery();				
				
				while (result.next()) {		
					
					answer = result.getString("answer");					
					
				}				
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return answer ;
	}

	public static void saveToDb(String dQuestion, String question) {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prep = conn.prepareStatement(INSERT);
			
			prep.setString(1, dQuestion);
			prep.setString(2, question);
			
			prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
