package d2tc.gui;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DruidPage {

	private final String CLASS_NAME = "Druid";                    
	private CharacterPage characterPage;
	private Scene scene;
		
	public DruidPage(Stage stage, Scene firstScene, String classIconUrl) {
		characterPage = new CharacterPage();
		
		//Load Default Settings for scene
		scene = characterPage.setDefaultScene(firstScene, stage, classIconUrl, CLASS_NAME);
	}
}