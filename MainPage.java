package application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainPage {
	Stage stage1;
	private Label title;
	private Button infobutton,startbutton,close;
	private Group maingroup = new Group();
	 private HBox hboxmain = new HBox(80);
	MainPage(){
		title = new Label("   Gaza Strip City   ");
		title.setStyle(
				"-fx-background-color: derive(#61a2b1,1.7);"+"-fx-background-color:black;" +
		        "-fx-background-insets: 0.5;" +
		        "-fx-padding: 5;" +
		        "-fx-background-radius: 100em; " +
		        "-fx-min-width: 600px; " +
		        "-fx-min-height: 40px; " +
		        "-fx-max-width: 200px; " +
		        "-fx-border-width: 1;" +
		        "-fx-border-radius: 5;" +
		        "-fx-fill: white;" 
		);
		title.setTextFill(Color.WHITE.brighter().brighter());
		title.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 60));
		title.setLayoutX(300);
		title.setLayoutY(100);
		
		infobutton = new Button(" Information ");
		infobutton.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		infobutton.setMinSize(150, 50);
		infobutton.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: black;" 
	    );
		close = new Button(" Close ");
		close.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		close.setMinSize(150, 50);
		close.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: black;" 
	    );
		
		startbutton = new Button(" Lets Start ");
		startbutton.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		startbutton.setMinSize(150, 50);
		startbutton.setStyle(
		        "-fx-background-radius: 10em; " +
		                "-fx-min-width: 200px; " +
		                "-fx-min-height: 50px; " +
		                "-fx-max-width: 250px; " +
		                "-fx-max-height: 150px; " +"-fx-background-color: black;"
		        );
		
		hboxmain.getChildren().addAll(infobutton,startbutton  ,close);
		hboxmain.setAlignment(Pos.CENTER);
		hboxmain.setLayoutX(250);
		hboxmain.setLayoutY(580);
		 Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/application/p3maniopage.jpg");
		 ImageView mg = new ImageView(m);
		 mg.setFitHeight(650);
		 mg.setFitWidth(1250);
		 maingroup.getChildren().addAll(mg,hboxmain);
		
	}
	public Label getTitle() {
		return title;
	}
	public Button getInfobutton() {
		return infobutton;
	}
	public Button getStartbutton() {
		return startbutton;
	}
	public Button getClose() {
		return close;
	}
	public Group getMaingroup() {
		return maingroup;
	}
	public HBox getHboxmain() {
		return hboxmain;
	}
	public void setTitle(Label title) {
		this.title = title;
	}
	public void setInfobutton(Button infobutton) {
		this.infobutton = infobutton;
	}
	public void setStartbutton(Button startbutton) {
		this.startbutton = startbutton;
	}
	public void setClose(Button close) {
		this.close = close;
	}
	public void setMaingroup(Group maingroup) {
		this.maingroup = maingroup;
	}
	public void setHboxmain(HBox hboxmain) {
		this.hboxmain = hboxmain;
	}
	
	
	}


