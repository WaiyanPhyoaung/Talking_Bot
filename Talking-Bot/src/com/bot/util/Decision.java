package com.bot.util;

public class Decision {
	
	private String dQuestion;
	private String answer;
	
	public String getAppropriateAnswer(String question) {	
			
			if(dQuestion != null) {
				Dictionary.saveToDb(dQuestion,question);
				dQuestion = null;
				
				return "Thank You";
				
			}else {
				answer = Dictionary.search(question);

				if(null == answer || answer.isEmpty()) {
					dQuestion = question;
					answer = "I don't know, tell me what should reply!";			
					
				}
				return answer;
			}
			
		
	}

}
