package d2tc.problemdomain;

import java.util.HashMap;

public class DamageSkill extends Skill {
	private String damageType;
	private String damageValue;
	private int manaCost;
	private HashMap<Integer, String> damageValues = new HashMap<Integer, String>();
	private boolean areaOfEffect;

	public DamageSkill(String skillName, String skillDescription, int requiredLevel,			
		String damageType, int manaCost, boolean areaOfEffect, HashMap<Integer, Integer> minDmgValues, HashMap<Integer, Integer> maxDmgValues) {
		super(skillName, skillDescription, requiredLevel);
		setDamageValues();
		this.damageValue = getDamageValue();
		this.damageType = damageType;
		this.manaCost = manaCost;
		this.areaOfEffect = areaOfEffect;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public String getDamageValue() {
		return damageValue;
	}

	public void setDamageValues() {
		if(this.getCurrentSkillLevel() == 0) {
			this.damageValue = damageValues.get(1);
		} else {
			this.damageValue = damageValues.get(this.getCurrentSkillLevel());
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
