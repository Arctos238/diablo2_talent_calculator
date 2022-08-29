package d2tc.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class ButtonGraphis extends Button {
	String buttonName;
	
   public ButtonGraphis(String buttonName, String imageLocation) {
	   // this.buttonName = buttonName;
	   
      //Creating a graphic (image)
      Image img = new Image(imageLocation);
      ImageView view = new ImageView(img);
      view.setFitHeight(80);
      view.setPreserveRatio(true);
      //Creating a Button
      Button button = new Button();
      //Setting the location of the button
      button.setTranslateX(200);
      button.setTranslateY(25);
      //Setting the size of the button
      button.setPrefSize(80, 80);
      //Setting a graphic to the button
      button.setGraphic(view);
   }
   
}