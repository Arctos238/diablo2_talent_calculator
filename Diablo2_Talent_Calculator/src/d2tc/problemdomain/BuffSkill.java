package d2tc.problemdomain;

import java.util.ArrayList;

public class BuffSkill extends Skill {
	ArrayList<Buff> buffs;

	public BuffSkill(String talentName, String talentDescription, int numberOfPointsInTalent, int requiredLevel,
			ArrayList<Buff> buffs) {
		super(talentName, talentDescription, numberOfPointsInTalent, requiredLevel);
		this.buffs = buffs;
	}
}
