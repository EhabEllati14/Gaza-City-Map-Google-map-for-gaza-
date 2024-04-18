package application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartPage {
	
	Stage stage2 ;
  private Label sourcelabel,targetlabel,pathlabel,distancelabel;
  private  ComboBox<String> combo1 , combo2; 
  private ImageView mg;
  public Button getMainbutton() {
	return mainbutton;
}


public void setMainbutton(Button mainbutton) {
	this.mainbutton = mainbutton;
}



public ImageView getMg() {
	return mg;
}


public void setMg(ImageView mg) {
	this.mg = mg;
}



private TextArea textarea;
  private TextField textfield;
  private Button Run , mainbutton,clear,clearall;
  private Group group = new Group();
  private HBox hbox1 = new HBox(20);
  private HBox hbox2 = new HBox(20);
  private HBox hbox3 = new HBox(20);
  private HBox hbox4 = new HBox(20);
 
  
  StartPage(){
	    sourcelabel = new Label(" Source :  ") ; 
		sourcelabel.setTextFill(Color.WHITE);
		sourcelabel.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC,25));
		sourcelabel.setMinWidth(100);
		
		targetlabel = new Label(" Target :  ");
		targetlabel.setTextFill(Color.WHITE);
		targetlabel.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC,25));
		targetlabel.setMinWidth(100);
		
		combo1 = new ComboBox<>();
		combo1.setMinSize(200, 40);
		
		
		combo2 = new ComboBox<>();
		combo2.setMinSize(200, 40);
		combo2.setEditable(true);
		combo1.setEditable(true);
		combo1.setStyle(
	                "-fx-background-color: white;" +
	                "-fx-border-color: black;" +
	                "-fx-border-width: 4px;" +
	                "-fx-border-radius: 5px;"+"-fx-font-weight: bold;"+" -fx-text-fill: black;"+" -fx-font-family: 'BankGothic LT BT';"
	        );
		    
		combo2.setStyle(
	                "-fx-background-color: white;" +
	                "-fx-border-color: black;" +
	                "-fx-border-width: 4px;" +
	                "-fx-border-radius: 5px;"+"-fx-font-weight: bold;"+" -fx-text-fill: black;"+" -fx-font-family: 'BankGothic LT BT';"
	        );
		
		Run = new Button(" Run ");
		Run.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		Run.setMinSize(150, 50);
		Run.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 100px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 100px; " +
			                "-fx-max-height: 100px; " +"-fx-background-color: black;" 
	    );
		Run.setTextFill(Color.WHITE);
		Run.setLayoutX(10);
		Run.setLayoutY(180);
		Run.setLayoutX(1120);
		Run.setLayoutY(180);
		
		clear= new Button(" Clear ");
		clear.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		clear.setMinSize(150, 50);
		clear.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 100px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 100px; " +
			                "-fx-max-height: 100px; " +"-fx-background-color: black;" 
	    );
		clear.setTextFill(Color.WHITE);
		//hbox3.getChildren().addAll(Run);
		hbox3.setLayoutX(950);
		hbox3.setLayoutY(180);
		
		
		
		mainbutton = new Button("   Main Page   ");
		mainbutton.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		mainbutton.setMinSize(150, 50);
		mainbutton.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 150px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 150px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: black;" 
	    );
		mainbutton.setTextFill(Color.WHITE);
		
		clearall = new Button("   Clear All  ");
		clearall.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		clearall.setMinSize(150, 50);
		clearall.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 150px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 150px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: black;" 
	    );
		clearall.setTextFill(Color.WHITE);
		hbox4.getChildren().addAll(mainbutton,clearall);
		hbox4.setLayoutX(900);
		hbox4.setLayoutY(580);
		
		pathlabel = new Label(" Path :  ") ; 
		pathlabel.setTextFill(Color.WHITE);
		pathlabel.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC,25));
		pathlabel.setMinWidth(100);
		
		pathlabel.setLayoutX(880);
		pathlabel.setLayoutY(250);
		
		distancelabel = new Label(" Distance :  ");
		distancelabel.setTextFill(Color.WHITE);
		distancelabel.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC,25));
		distancelabel.setMinWidth(100);
		
		distancelabel.setLayoutX(880);
		distancelabel.setLayoutY(470);
		
		
		
		textarea= new TextArea();
		textarea.setMaxHeight(150);
		textarea.setMaxWidth(350);
		textarea.setLayoutX(880);
		textarea.setLayoutY(300);
		textarea.setEditable(false);
		
		
		textfield= new TextField(null);
		textfield.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC, 20));
		textfield.setMinWidth(350);
		textfield.setMinHeight(40);
		textfield.setEditable(false);
		
		textfield.setLayoutX(880);
		textfield.setLayoutY(515);
	
		hbox1.getChildren().addAll(sourcelabel,combo1);
		hbox1.setLayoutX(880);
		hbox1.setLayoutY(30);
		
		hbox2.setLayoutX(880);
		hbox2.setLayoutY(100);
		hbox2.getChildren().addAll(targetlabel,combo2);
		
		Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/Screenshot%202024-01-09%20233501.png");
		 mg = new ImageView(m);
		mg.setFitHeight(650);
		mg.setFitWidth(850);
		Image m2 = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/application/backkgazamap.jpg");
		ImageView mg2 = new ImageView(m2);
		
		mg2.setFitHeight(650);
		mg2.setFitWidth(405);
		mg2.setLayoutX(860);
		
		 BorderPane borderPane = new BorderPane(mg2);
	        borderPane.setStyle("-fx-border-color: black; -fx-border-width: 5;");
	        borderPane.setLayoutX(850);
	        
		group.getChildren().addAll(mg,borderPane,hbox1,hbox2,Run,pathlabel,textarea,distancelabel,textfield,hbox4);
	
  }


public Button getClear() {
	return clear;
}


public Button getClearall() {
	return clearall;
}


public HBox getHbox3() {
	return hbox3;
}


public HBox getHbox4() {
	return hbox4;
}


public void setClear(Button clear) {
	this.clear = clear;
}


public void setClearall(Button clearall) {
	this.clearall = clearall;
}


public void setHbox3(HBox hbox3) {
	this.hbox3 = hbox3;
}


public void setHbox4(HBox hbox4) {
	this.hbox4 = hbox4;
}


public Stage getStage2() {
	return stage2;
}


public Label getSourcelabel() {
	return sourcelabel;
}


public Label getTargetlabel() {
	return targetlabel;
}


public Label getPathlabel() {
	return pathlabel;
}


public Label getDistancelabel() {
	return distancelabel;
}


public ComboBox<String> getCombo1() {
	return combo1;
}


public ComboBox<String> getCombo2() {
	return combo2;
}


public TextArea getTextarea() {
	return textarea;
}


public TextField getTextfield() {
	return textfield;
}


public Button getRun() {
	return Run;
}


public Group getGroup() {
	return group;
}


public HBox getHbox1() {
	return hbox1;
}


public HBox getHbox2() {
	return hbox2;
}


public void setStage2(Stage stage2) {
	this.stage2 = stage2;
}


public void setSourcelabel(Label sourcelabel) {
	this.sourcelabel = sourcelabel;
}


public void setTargetlabel(Label targetlabel) {
	this.targetlabel = targetlabel;
}


public void setPathlabel(Label pathlabel) {
	this.pathlabel = pathlabel;
}


public void setDistancelabel(Label distancelabel) {
	this.distancelabel = distancelabel;
}


public void setCombo1(ComboBox<String> combo1) {
	this.combo1 = combo1;
}


public void setCombo2(ComboBox<String> combo2) {
	this.combo2 = combo2;
}


public void setTextarea(TextArea textarea) {
	this.textarea = textarea;
}


public void setTextfield(TextField textfield) {
	this.textfield = textfield;
}


public void setRun(Button run) {
	Run = run;
}


public void setGroup(Group group) {
	this.group = group;
}


public void setHbox1(HBox hbox1) {
	this.hbox1 = hbox1;
}


public void setHbox2(HBox hbox2) {
	this.hbox2 = hbox2;
}

}
