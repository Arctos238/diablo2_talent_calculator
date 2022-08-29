package d2tc.gui;

import java.util.ArrayList;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SorceressPage {
	private final String CLASS_NAME = "Sorceress";
	private final String FONT_URL = "file:///E:/Programming/Code/Git/D2R_Calculator/Diablo2_Talent_Calculator/res/fonts/exocet_regular.ttf";
	private CharacterPage characterPage;
	private Scene scene;
	private Pane coldTreePane;
	private Pane lightningTreePane;
	private Pane fireTreePane;
	private final int TREE_NAME_Y_POS = 200;

	public SorceressPage(Stage stage, Scene firstScene, String classIconUrl) {
		characterPage = new CharacterPage();

		scene = characterPage.setDefaultScene(firstScene, stage, classIconUrl, CLASS_NAME); // Load Default Settings for scene

		Pane root = (Pane) scene.getRoot(); // Obtains the Panel from the Scene;

		coldTreePane = (Pane) root.getChildren().get(0); // Obtains the leftCenterPane from the root Panel
		lightningTreePane = (Pane) root.getChildren().get(1); // Obtains the centerPane from the root Panel
		fireTreePane = (Pane) root.getChildren().get(2); // Obtains the rightCenterPane from the root Panel

		SorceressColdSkillTreePane sorceressColdSkillTreePane = new SorceressColdSkillTreePane(coldTreePane);
		
		displayTreeName("Cold Spells", 205, TREE_NAME_Y_POS, root);
		displayTreeName("Lightning Spells", 525, TREE_NAME_Y_POS, root);
		displayTreeName("Fire Spells", 910, TREE_NAME_Y_POS, root);
		
		stage.setScene(scene);
	}

	private void displayTreeName(String treeName, int xpos, int ypos, Pane root) {
		Text treeNameText = new Text(treeName);
		Font font = Font.loadFont(FONT_URL, 20);
		
		treeNameText.setFill(Color.WHITE);
		treeNameText.setFont(font);
		treeNameText.setTranslateX(xpos);
		treeNameText.setTranslateY(ypos);
		root.getChildren().add(treeNameText);
	}

}