package d2tc.managers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import d2tc.problemdomain.*;
import d2tc.problemdomain.Character;

public class OutputCharacterManager extends ObjectOutputStream {
	final int NUM_OF_SKILL_TREES = 3;
	final int NUM_OF_SKILLS = 10;
	final int NUM_OF_SKILL_LEVELS = 20;
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
		System.out.print("Enter Damage Type of Skill: ");
		String damageType = stringInput.next();
		
		System.out.print("Enter Mana Cost:");
		int manaCost = intScanner.nextInt();
		
		System.out.println("Is the spell an Area of Effect Spell (true or false)");
		boolean areaOfEffect = intScanner.nextBoolean();
		
		HashMap<Integer, String> damageValues = createDamageValues();
		
		DamageSkill damageSkill = new DamageSkill(getSkillName(), getSkillDescription(), getRequiredLevel(), damageType, manaCost, areaOfEffect, damageValues);

		return damageSkill;
	}

	private HashMap<Integer, String> createDamageValues() {
		HashMap<Integer, String> damageValues = new HashMap<>(); 
		
		for(int i = 0; i < NUM_OF_SKILL_LEVELS; i++) {
			System.out.print("Enter Skill Level " + (i + 1) + "'s damage values (example 1-3, 5-8): ");
			damageValues.put((i + 1), getSkillDescription());
		}
		
		return damageValues;
	}

	private DebuffSkill createDebuffSkill() {
		
		DebuffSkill debuffSkill = new DebuffSkill(getSkillName(), getSkillDescription(), getRequiredLevel());
		
		return null;
	}

	private BuffSkill createBuffSkill() {
		
		BuffSkill buffSkill = new BuffSkill(getSkillName(), getSkillDescription(), getRequiredLevel());
		
		return null;
	}

	private String getSkillName() {
		System.out.print("Enter Skill Name: ");
		String skillName = stringInput.next();
		return skillName;
	}
	
	private int getRequiredLevel() {
		System.out.print("Enter required character level: ");
		int requiredLevel = intScanner.nextInt();
		return requiredLevel;
	}

	private String getSkillDescription() {
		System.out.print("Enter Skill Description: ");
		String skillDescription = stringInput.nextLine();
		return skillDescription;
	}

	public static void main(String[] args) throws SecurityException, IOException {
		OutputCharacterManager outputCharacterManger = new OutputCharacterManager();
	}
}
