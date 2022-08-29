package d2tc.problemdomain;

import java.util.ArrayList;

public class SkillTree {
	private final int MAX_NUMBER_OF_SKILLS_IN_TREE = 10;
	private ArrayList<Skill> skills;
	private String skillTreeName;
	private int numberOfSkillPointsSpent;
	
	public SkillTree(String skillTreeName, ArrayList<Skill> skills) {
		this.skills = skills;
		this.skillTreeName = skillTreeName;
		this.numberOfSkillPointsSpent = 0;
	}
	
	public int getMAX_NUMBER_OF_SKILLS_IN_TREE() {
		return MAX_NUMBER_OF_SKILLS_IN_TREE;
	}

	public ArrayList<Skill> getTalents() {
		return skills;
	}

	public void setTalents(ArrayList<Skill> talents) {
		this.skills = talents;
	}

	public String getSkillTreeName() {
		return skillTreeName;
	}

	public void setSkillTreeName(String skillTreeName) {
		this.skillTreeName = skillTreeName;
	}

	public int getNumberOfSkillPointsSpent() {
		return numberOfSkillPointsSpent;
	}

	public void UpdateNumberOfSkillPointsSpent() {
		int updatedNumberOfSkillPointsSpent = 0;
		
		for (int i = 0; i < skills.size(); i++) {
			updatedNumberOfSkillPointsSpent += skills.get(i).getNumberOfPointsInSkill();
		}
		
		this.numberOfSkillPointsSpent = updatedNumberOfSkillPointsSpent;
	}
}