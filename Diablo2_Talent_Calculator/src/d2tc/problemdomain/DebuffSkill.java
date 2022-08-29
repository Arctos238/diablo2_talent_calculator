package d2tc.problemdomain;

import java.util.ArrayList;

public class DebuffSkill extends Skill {
	ArrayList<Debuff> debuffs;

	public DebuffSkill(String talentName, String talentDescription, int numberOfPointsInTalent, int requiredLevel,
			ArrayList<Debuff> debuffs) {
		super(talentName, talentDescription, numberOfPointsInTalent, requiredLevel);
		this.debuffs = debuffs;
	}
}
