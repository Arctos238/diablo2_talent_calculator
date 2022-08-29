package d2tc.problemdomain;

import java.util.ArrayList;

public class BuffSkill extends Skill {
	private ArrayList<Buff> buffs;

	public BuffSkill(String skillName, String skillDescription, int requiredLevel,
			ArrayList<Buff> buffs) {
		super(skillName, skillDescription, requiredLevel);
		this.buffs = buffs;
	}
}
