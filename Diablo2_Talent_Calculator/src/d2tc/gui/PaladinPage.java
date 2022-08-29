package d2tc.gui;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PaladinPage {
	private final String CLASS_NAME = "Paladin";
	private CharacterPage characterPage;
	private Scene scene;
	
		
	public PaladinPage(Stage stage, Scene firstScene, String classIconUrl) {
		characterPage = new CharacterPage();
		
		//Load Default Settings for scene
		scene = characterPage.setDefaultScene(firstScene, stage, classIconUrl, CLASS_NAME);
		
		
		stage.setScene(scene);
	}
}
