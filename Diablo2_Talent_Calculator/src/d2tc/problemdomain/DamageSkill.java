package d2tc.problemdomain;

import java.util.HashMap;

public class DamageSkill extends Skill {
	String damageType;
	int minDamage;
	int maxDamage;
	int manaCost;
	HashMap<Integer, Integer> minDmgValues = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> maxDmgValues = new HashMap<Integer, Integer>();
	private boolean areaOfEffect;

	public DamageSkill(String talentName, String talentDescription, int numberOfPointsInTalent, int requiredLevel,			
		int minDamage, int maxDamage, String damageType, int manaCost, boolean areaOfEffect, HashMap<Integer, Integer> minDmgValues, HashMap<Integer, Integer> maxDmgValues) {
		super(talentName, talentDescription, numberOfPointsInTalent, requiredLevel);
		this.minDmgValues = minDmgValues;
		this.maxDmgValues = maxDmgValues;
		setMinDamage();
		setMaxDamage();
		this.damageType = damageType;
		this.minDamage = getMinDamage();
		this.maxDamage = getMaxDamage();
		this.manaCost = manaCost;
		this.areaOfEffect = areaOfEffect;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage() {
		if(this.getCurrentSkillLevel() == 0) {
			this.minDamage = minDmgValues.get(1);
		} else {
			this.minDamage = minDmgValues.get(this.getCurrentSkillLevel());
		}
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage() {
		if(this.getCurrentSkillLevel() == 0) {
			this.maxDamage = minDmgValues.get(1);
		} else {
			this.maxDamage = maxDmgValues.get(this.getCurrentSkillLevel());
		}
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public boolean isAreaOfEffect() {
		return areaOfEffect;
	}

	public void setAreaOfEffect(boolean areaOfEffect) {
		this.areaOfEffect = areaOfEffect;
	}
	
	
}
