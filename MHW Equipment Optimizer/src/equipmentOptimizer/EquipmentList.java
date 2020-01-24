package equipmentOptimizer;

import java.util.ArrayList;
import java.util.List;

// TODO
// This part need a code clean up
class EquipmentList {
	final Charm charm;
	final List<Armor> armors;
	private final Weapon weapon;
	int defense;
	int decor3;
	int decor2;
	int decor1;
	int combinedDecor3;
	int combinedDecor2;
	int combinedDecor1;
	int totalCombinedDecor;
	int[] elementalResistance;
	SetBonusList setBonusList; // 這項會在建構式出現
	EquipmentSkillList equipmentSkillList;

	EquipmentList(Weapon weapon, Armor armorSet, Charm charm) {
		this.weapon = weapon;

		armors = new ArrayList<>();
		armors.add(armorSet);

		this.charm = charm;

		setBonusList = new SetBonusList();
		for (Armor currentArmor : armors) {
			setBonusList.plus1(currentArmor.setBonus);
		}
	}

	EquipmentList(Weapon weapon, Armor head, Armor body, Armor hands, Armor belt, Armor feet, Charm charm) {
		this.weapon = weapon;

		armors = new ArrayList<>();
		armors.add(head);
		armors.add(body);
		armors.add(hands);
		armors.add(belt);
		armors.add(feet);

		this.charm = charm;

		setBonusList = new SetBonusList();
		for (Armor currentArmor : armors) {
			setBonusList.plus1(currentArmor.setBonus);
		}
	}

	void setDecorationSlot() {
		decor3 = this.weapon.decor3;
		decor2 = this.weapon.decor2;
		decor1 = this.weapon.decor1;
		for (Armor currentArmor : armors) {
			decor3 += currentArmor.decor3;
			decor2 += currentArmor.decor2;
			decor1 += currentArmor.decor1;
		}
		decor3 += charm.decor3;
		decor2 += charm.decor2;
		decor1 += charm.decor1;
	}

	void setAdditionalInformation() {
		setBonusList = new SetBonusList();
		equipmentSkillList = new EquipmentSkillList();

//		equipmentSkillList.plus(weapon.skillList);
//		for (Armor currentArmor : armors)
//			equipmentSkillList.plus(currentArmor.skillList);
//		equipmentSkillList.plus(charm.skillList);
		updateDefenseAndElementalResistance();
	}

	void setEquipmentSkillList(EquipmentSkillList equipmentSkillList) {
		this.equipmentSkillList = equipmentSkillList;
		updateDefenseAndElementalResistance();
	}

	private void updateDefenseAndElementalResistance() {
		defense = this.weapon.defense + 1;
		elementalResistance = new int[5];

		for (int i = 0; i <= elementalResistance.length - 1; i++)
			elementalResistance[i] = 0;

		for (Armor currentArmor : armors) {
			defense += currentArmor.defense;

			for (int i = 0; i <= elementalResistance.length - 1; i++)
				elementalResistance[i] += currentArmor.elementalResistance[i];
		}
		defense += charm.defense;
		for (int i = 0; i <= elementalResistance.length - 1; i++)
			elementalResistance[i] += charm.elementalResistance[i];

		String skillName = "防禦";
		if (equipmentSkillList.contains(skillName)) {
			int defBonus = equipmentSkillList.getSkillLevel(skillName);
			defense += defBonus * 5;
			if (defBonus >= 4) {
				for (int i = 0; i <= elementalResistance.length - 1; i++)
					elementalResistance[i] += 3;
			}
		}

		String[] elementalDefPrefix = {"火", "水", "雷", "冰", "龍"};
		for (int i = 0; i <= elementalDefPrefix.length - 1; i++) {
			skillName = elementalDefPrefix[i] + "耐性";
			if (equipmentSkillList.contains(skillName)) {
				int elementalDefBonus = equipmentSkillList.getSkillLevel(skillName);
				elementalResistance[i] += elementalDefBonus * 6;
				if (elementalDefBonus == 3) {
					elementalResistance[i] += 2;
					defense += 10;
				}
			}
		}
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
//		output.append(weapon.equipmentName);
//		output.append(",");
//		for (int currentArmorIndex = 0; currentArmorIndex <= armors.size() - 1; currentArmorIndex++) {
//			output.append(armors.get(currentArmorIndex).equipmentName);
//			output.append(",");
//		}
//		output.append(charm.equipmentName);
		return output.toString();
	}

}
