package d2tc.gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class SorceressColdSkillTreePane {
	private final String COLD_SKILL_TREE_ICONS_URL = "file:///E:/Programming/Code/Git/D2R_Calculator/Diablo2_Talent_Calculator/res/skill_icons/D2_sorc_cold_tree_skills/cold_skill_";
	private final String FONT_URL = "file:///E:/Programming/Code/Git/D2R_Calculator/Diablo2_Talent_Calculator/res/fonts/exocet_regular.ttf";
	private final int LEFT_SKILL_POS_X = 2;
	private final int CENTER_SKILL_POS_X = 7;
	private final int RIGHT_SKILL_POS_X = 11;
	private final int FIRST_ROW_POS_Y = 1;
	private final int SECOND_ROW_POS_Y = 5;
	private final int THIRD_ROW_POS_Y = 8;
	private final int FOURTH_ROW_POS_Y = 11;
	private final int FIFTH_ROW_POS_Y = 14;
	private final int SIXTH_ROW_POS_Y = 17;
	private ArrayList<Pane> coldSkillPaneArrayList;

	public SorceressColdSkillTreePane(Pane coldTreePane) {
		createSorcessorColdTreePane(coldTreePane);
	}

	public void createSorcessorColdTreePane(Pane coldTreePane) {
		GridPane coldTreeButtonGridPane = new GridPane();
		coldTreeButtonGridPane.setHgap(10);
		coldTreeButtonGridPane.setVgap(10);

		ArrayList<Button> coldTreeButtons = createSkillListOf10Buttons(); // Creates A List of 10 Buttons

		coldSkillPaneArrayList = createSkillPaneArrayList(coldTreeButtons);

		coldTreeButtonGridPane.add(coldTreeButtons.get(0), CENTER_SKILL_POS_X, FIRST_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(1), RIGHT_SKILL_POS_X, FIRST_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(2), LEFT_SKILL_POS_X, SECOND_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(3), CENTER_SKILL_POS_X, SECOND_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(4), RIGHT_SKILL_POS_X, THIRD_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(5), CENTER_SKILL_POS_X, FOURTH_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(6), LEFT_SKILL_POS_X, FIFTH_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(7), RIGHT_SKILL_POS_X, FIFTH_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(8), LEFT_SKILL_POS_X, SIXTH_ROW_POS_Y);
		coldTreeButtonGridPane.add(coldTreeButtons.get(9), CENTER_SKILL_POS_X, SIXTH_ROW_POS_Y);

		coldTreePane.getChildren().add(coldTreeButtonGridPane);
	}

	private ArrayList<Pane> createSkillPaneArrayList(ArrayList<Button> buttonArrayList) {
		ArrayList<Pane> paneArrayList = new ArrayList<>();

		for (int i = 0; i < buttonArrayList.size(); i++) {
			Pane pane = new Pane();
			pane.getChildren().add(buttonArrayList.get(i));

			paneArrayList.add(pane);
		}

		return paneArrayList;
	}

	public Pane createSkillPane(Button skillButton) {
		Pane skillPane = new Pane();

		skillPane.resize(70, 40);
		skillButton.setLayoutX(10);
		skillButton.setLayoutY(10);

		skillPane.getChildren().addAll(skillButton);

		return skillPane;

	}

	public ArrayList<Button> createSkillListOf10Buttons() {
		ArrayList<Button> buttonList = new ArrayList<Button>();

		for (int i = 0; i < 10; i++) {
			Button button = new Button();
			button.setGraphic(new ImageView(COLD_SKILL_TREE_ICONS_URL + (i + 1) + ".jpg"));
			button.setTextFill(Color.BLACK);
			button.setOnMousePressed(SkillButtonHandler);
			button.setMaxHeight(60);
			button.setMinHeight(60);
			button.setText("0");
			button.setFont(Font.loadFont(FONT_URL, 10));

			Tooltip tooltip = createToolTip(button);
			button.setTooltip(tooltip);

			// Shows tool tip next to button;
			button.onMouseMovedProperty().set(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					Button button = (Button) e.getSource();
					Bounds bounds = button.localToScreen(button.getBoundsInLocal());

					button.getTooltip().show(button, bounds.getMaxX(), bounds.getMinY());
				}

			});

			// Disables tool tip;

			button.onMouseExitedProperty().set(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					Button button = (Button) e.getSource();
					button.getTooltip().hide();
				}

			});

			buttonList.add(button);
		}

		return buttonList;
	}

	public Tooltip createToolTip(Button button) {
		Tooltip tooltip = new Tooltip();
		tooltip.setWrapText(true);
		Font font = Font.loadFont(FONT_URL, 14);

		tooltip.setText(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus varius sapien a euismod luctus. Praesent nisi tellus, volutpat id luctus vitae, interdum a magna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vestibulum elit nunc. Mauris non sagittis lorem. Integer lobortis tortor mi, vel sollicitudin ante tempor non. Aliquam aliquet dui condimentum gravida vehicula. Morbi fringilla, sapien in tristique finibus, elit tortor elementum leo, quis lacinia ipsum nisi quis nibh. Ut tincidunt nisi nisl, ut tempor justo sagittis ultrices. Curabitur luctus, arcu quis molestie viverra, turpis nibh vestibulum sem, ac ullamcorper diam eros rhoncus ipsum. ");
		tooltip.setFont(font);
		tooltip.setPrefWidth(250);
		tooltip.requestFocus();
		tooltip.hide();
		// tooltip.setText(button.toString());

		return tooltip;
	}

	EventHandler<MouseEvent> SkillButtonHandler = new EventHandler<MouseEvent>() {

		public void handle(MouseEvent e) {
			Button one = (Button) e.getSource();
			int numOfPointsInSkill = Integer.parseInt(one.getText());
			Alert invalidClickAlert = new Alert(AlertType.INFORMATION);

			if (e.isSecondaryButtonDown()) {
				if (numOfPointsInSkill > 0) {
					numOfPointsInSkill--;
				} else {
					invalidClickAlert.setContentText("Skill can't go below 0");
					invalidClickAlert.show();
				}
			} else if (e.isPrimaryButtonDown()) {
				if (numOfPointsInSkill < 20) {
					numOfPointsInSkill++;
				} else {
					invalidClickAlert.setContentText("Skill can't go above 20");
					invalidClickAlert.show();
				}
			}

			one.setText(numOfPointsInSkill + "");
		}

	};
}
