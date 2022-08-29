package d2tc.managers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import d2tc.problemdomain.*;
import d2tc.problemdomain.Character;

public class OutputCharacterManager extends ObjectOutputStream {
	final int NUM_OF_SKILL_TREES = 3;
	final int NUM_OF_SKILLS = 10;
	Scanner stringInput;
	Scanner intScanner;

	private OutputCharacterManager() throws IOException, SecurityException {
		super();

		stringInput = new Scanner(System.in);
		intScanner = new Scanner(System.in);
		
		System.out.print("Character Name: ");
		String characterName = stringInput.next();

		FileOutputStream fos = new FileOutputStream("res\\character_object_files\\" + characterName + ".bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Character character = createCharacter(characterName);

		oos.writeObject(character);

		oos.close();

	}

	private Character createCharacter(String characterName) {

		ArrayList<SkillTree> skillTrees = createSkillTrees();

		Character character = new Character(characterName, skillTrees);

		return character;

	}

	private ArrayList<SkillTree> createSkillTrees() {
		ArrayList<SkillTree> skillTrees = new ArrayList<>();

		for (int i = 0; i < NUM_OF_SKILL_TREES; i++) {
			SkillTree skillTree = createSkillTree();

			skillTrees.add(skillTree);
		}

		return skillTrees;
	}

	private SkillTree createSkillTree() {
		System.out.print("Name of Skill Tree: ");
		String skillTreeName = stringInput.next();

		ArrayList<Skill> skills = createSkills();
		SkillTree skillTree = new SkillTree(skillTreeName, skills);

		return skillTree;
	}

	private ArrayList<Skill> createSkills() {
		ArrayList<Skill> skills = new ArrayList<>();

		System.out.print("How many Buff Skills in this Tree: ");
		int numberOfBuffSkills = intScanner.nextInt();

		for (int i = 0; i < numberOfBuffSkills; i++) {
			BuffSkill buffSkill = createBuffSkill();
			skills.add(buffSkill);
		}

		System.out.print("How many Debuff Skills in this Tree?");
		int numberOfDebuffSkills = intScanner.nextInt();

		for (int i = 0; i < numberOfDebuffSkills; i++) {
			DebuffSkill debuffSkill = createDebuffSkill();
			skills.add(debuffSkill);
		}

		System.out.print("How many Damage Skills in this Tree?");
		int numberOfDamageSkills = intScanner.nextInt();

		for (int i = 0; i < numberOfDamageSkills; i++) {
			DamageSkill damageSkill = createDamageSkill();
			skills.add(damageSkill);
		}
		return skills;
	}

	private DamageSkill createDamageSkill() {
		// TODO Auto-generated method stub
		return null;
	}

	private DebuffSkill createDebuffSkill() {
		// TODO Auto-generated method stub
		return null;
	}

	private BuffSkill createBuffSkill() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws SecurityException, IOException {
		OutputCharacterManager outputCharacterManger = new OutputCharacterManager();
	}
}
