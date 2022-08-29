package d2tc.problemdomain;

import java.util.ArrayList;

public class DebuffSkill extends Skill {
	private ArrayList<Debuff> debuffs;

	public DebuffSkill(String skillName, String skillDescription, int requiredLevel,
			ArrayList<Debuff> debuffs) {
		super(skillName, skillDescription, requiredLevel);
		this.debuffs = debuffs;
	}
}
