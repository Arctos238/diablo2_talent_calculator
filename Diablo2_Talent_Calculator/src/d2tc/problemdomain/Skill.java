package d2tc.problemdomain;

import javafx.scene.control.Button;

public abstract class Skill extends Button {
	private final int MAX_SKILL_POINTS = 20;
	private final int STARTING_SKILL_LEVEL = 0;
	private String skillName;
	private String skillDescription;
	private int numberOfPointsInSkill;
	private int requiredLevel;
	private int currentSkillLevel;

	public int getMAX_SKILL_POINTS() {
		return MAX_SKILL_POINTS;
	}

	public Skill(String skillName, String skillDescription, int requiredLevel) {
		this.skillName = skillName;
		this.skillDescription = skillDescription;
		this.numberOfPointsInSkill = STARTING_SKILL_LEVEL;
		this.requiredLevel = requiredLevel;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDescription() {
		return skillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}

	public int getNumberOfPointsInSkill() {
		return numberOfPointsInSkill;
	}

	public void numberOfPointsInSkillPlusOne() {
		this.numberOfPointsInSkill++;
	}

	public void numberOfPointsInSkillMinusOne() {
		this.numberOfPointsInSkill--;
	}

	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requireLevel) {
		this.requiredLevel = requireLevel;
	}
	
	public int getCurrentSkillLevel() {
		return this.currentSkillLevel;
	}
	
	public void increaseCurrentSkillLevelByOne() {
		if (this.currentSkillLevel < 20) {
			this.currentSkillLevel++;
		}
	}
	
	public void decreaseCurrentSkilllevelByOne() {
		if (this.currentSkillLevel > 0) {
			this.currentSkillLevel--;
		}
	}
}
