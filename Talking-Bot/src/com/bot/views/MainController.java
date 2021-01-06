package com.bot.views;

import java.net.URL;
import java.util.ResourceBundle;
import com.bot.util.Decision;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainController implements Initializable {
	
	public Decision decision;
	
	public MainController() {
		decision = new Decision();
	}

    @FXML
    private TextField text;

    @FXML
    private ListView<String> listView;

    @FXML
    void ask() {
    	    	
    	String question = text.getText();
    	text.clear();
    	
    	String answer = decision.getAppropriateAnswer(question);
    	
    	listView.getItems().add(question);
    	listView.getItems().add(answer);
    	listView.getItems().add("");    
    	
    	
//    	listView.getItems().add(text.getText());
//    	text.clear();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		text.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {				
				if(event.getCode() == KeyCode.ENTER)
					ask();				
			}
		});
				
	}

}
