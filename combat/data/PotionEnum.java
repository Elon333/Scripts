package scripts.combat.data;

import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;

public enum PotionEnum {

	COMBAT {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.STRENGTH;
		}
	},

	RANGING {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.RANGED;
		}
	},

	STRENGTH {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.STRENGTH;
		}
	},

	ATTACK {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.ATTACK;
		}
	},

	DEFENCE {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.DEFENCE;
		}
	},

	MAGIC {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.MAGIC;
		}
	},

	BASTION {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.RANGED;
		}
	},

	BATTLEMAGE {
		@Override
		public SKILLS getCorrespondingSkill() {
			return Skills.SKILLS.MAGIC;
		}
	};

	public abstract Skills.SKILLS getCorrespondingSkill();

}
