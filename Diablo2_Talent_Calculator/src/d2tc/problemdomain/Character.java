package d2tc.problemdomain;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2429966980573173771L;
	private final int MAX_NUMBER_OF_POINTS = 110;
	private final int NUMBER_OF_SKILLTREES = 3;
	private ArrayList<SkillTree> skilltrees;
	private String className;
	private int characterLevel;
	private int totalPointsSpent;
	
	public Character(String className, ArrayList<SkillTree> skillTrees) {
		this.skilltrees = skillTrees;
		this.className = className;
		this.characterLevel = 0;
		this.totalPointsSpent = 0;
	}

	public int getMAX_NUMBER_OF_POINTS() {
		return MAX_NUMBER_OF_POINTS;
	}

	public int getNUMBER_OF_SKILLTREES() {
		return NUMBER_OF_SKILLTREES;
	}

	public ArrayList<SkillTree> getSkilltrees() {
		return skilltrees;
	}

	public void setSkilltrees(ArrayList<SkillTree> skilltrees) {
		this.skilltrees = skilltrees;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getCharacterLevel() {
		return characterLevel;
	}

	public void setCharacterLevel(int characterLevel) {
		this.characterLevel = characterLevel;
	}
	
	public void characterLevelPlusOne() {
		this.characterLevel++;
	}

	public int getTotalPointsSpent() {
		return totalPointsSpent;
	}

	public void updateTotalPointsSpent() {
		this.totalPointsSpent = this.skilltrees.get(0).getNumberOfSkillPointsSpent() + this.skilltrees.get(1).getNumberOfSkillPointsSpent() + this.skilltrees.get(2).getNumberOfSkillPointsSpent();
	}
	
}