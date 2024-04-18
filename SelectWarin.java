package application;



import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class SelectWarin {
 private BorderPane warborder = new BorderPane();
private Button okbutton;
private Label msgtxt;
Stage stage3;

SelectWarin(){
	Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/Error%20Photo.png");
	ImageView mg = new ImageView(m);
	 mg.setFitHeight(400);
	 mg.setFitWidth(600);
	
	 okbutton = new Button(" OK ");
	 okbutton.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
	 okbutton.setMinSize(150, 50);
	 okbutton.setStyle(
		        "-fx-background-radius: 10em; " +
		                "-fx-min-width: 200px; " +
		                "-fx-min-height: 50px; " +
		                "-fx-max-width: 250px; " +
		                "-fx-max-height: 150px; " +"-fx-background-color: black;"
		        );
	 okbutton.setTextFill(Color.WHITE);
	msgtxt = new Label(" You must chooseeeee");
	msgtxt.setFont(Font.font("BankGothic LT BT",FontWeight.BOLD, FontPosture.ITALIC,16));
	 msgtxt.setTextFill(Color.WHITE);
	 
	 warborder.getChildren().add(mg);
	 
	 warborder.setBottom(okbutton);
	 warborder.setAlignment(okbutton,Pos.CENTER);
	 
	 warborder.setCenter(msgtxt);
	 warborder.setAlignment(msgtxt, Pos.CENTER);
	 
}

public BorderPane getWarborder() {
	return warborder;
}

public Button getOkbutton() {
	return okbutton;
}

public Label getMsgtxt() {
	return msgtxt;
}

public void setWarborder(BorderPane warborder) {
	this.warborder = warborder;
}

public void setOkbutton(Button okbutton) {
	this.okbutton = okbutton;
}

public void setMsgtxt(Label msgtxt) {
	this.msgtxt = msgtxt;
}

}
