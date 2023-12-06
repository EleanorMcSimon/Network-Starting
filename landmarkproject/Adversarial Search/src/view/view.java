package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import object.tictactoespace;



public class view extends Application {
	 ArrayList<ToggleButton> number = new ArrayList();
	 ArrayList<int[]> crosscast = new ArrayList();
	 controller con = new controller();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Scanner input = new Scanner(System.in);
	
		 launch(args);
	/*	Scanner input = new Scanner(System.in);
		
		con.setboard();
		while(!con.isgameover())
		{
			int[] numbers = new int[2];
			System.out.println("guess:");
			 for (int i = 0; i < 2; i++)
			    {
			numbers[i] = input.nextInt();
			    }
			 con.Playerturn(numbers[0], numbers[1]);
			 
		}*/
		 
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		con.setboard();
		arg0.setTitle("Hello");
		int button = 0;
		GridPane bord = new GridPane();
		 
		     for(int u =0; u < 3; u++)
		     {
		    	 for(int f = 0; f < 3; f++) {
		    		 
		    	 
		    	 String s=String.valueOf(u);
		    	// System.out.print(s);
		    	 int[] hero = {f,u};
		    	 ToggleButton bio = new ToggleButton();
		    	 bio.setStyle("-fx-padding: 40px;");
		    	 number.add(bio);
		    	 crosscast.add(hero);
		 		bord.add(number.get(button), f, u);
		 		//crosscast.add(hero);
		 		number.get(button).setOnMouseClicked(new EventHandler<MouseEvent>() {
			            @Override
			            public void handle(MouseEvent event) {
			                MouseButton button = event.getButton();
			              
			                if(button==MouseButton.PRIMARY){
			                	ToggleButton findme =  (ToggleButton) event.getTarget();
			                	
			                	System.out.print("in");
			                int hero =	number.indexOf(findme);
			                number.get(hero).setText("X");
			       	Font font = Font.font("Times New Roman", 15);
			       	number.get(hero).setFont(font);
			       	number.get(hero).setStyle("-fx-padding: 35px;");
			       	number.get(hero).setDisable(true);
			       	con.Playerturn(crosscast.get(hero)[0], crosscast.get(hero)[1]);
			       	int[] f = con.simulateturn();
			        int there = 0;
			       	for(int n = 0; n <crosscast.size(); n++)
			       	{
			       		int[] w = crosscast.get(n);
			       		if(w[0] == f[0] && w[1] == f[1])
			       		{
			       		    there = n;
			       		}
			       	} 
			       	con.isgameover();
			   
			     	//System.out.print("in");
	               
	                number.get(there).setText("O");
	       	number.get(there).setFont(font);
	       	number.get(there).setStyle("-fx-padding: 35px;");
	       	number.get(there).setDisable(true);
			                }
			             
		     }
		 		 });
		 		   button++;
		     }
		 	
		     }
		     
			
					
		arg0.setScene(new Scene(bord));
		arg0.show();
	}

}


	
	

/*
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.setTitle("Tick tic toe");
		
	}}*/
