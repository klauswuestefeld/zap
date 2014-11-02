class BossHead extends BossPart {

	Thing leg      = new BossLeg();
	Thing rightArm = new BossRightArm();
	Thing leftArm  = new BossLeftArm();

	BossHead() {
		direction = right;
	}
	
	void act() {
		if (direction == left) {
			leftArm.direction = direction;
			leftArm.step();
			if (step()) {
				leg.direction = direction;
				leg.step();
				rightArm.direction = direction;
				rightArm.step();
			} else
				direction = right;
		} else {
			rightArm.direction = direction;
			rightArm.step();
			if (step()) {
				leg.direction = direction;
				leg.step();
				leftArm.direction = direction;
				leftArm.step();
			} else
				direction = left;
		}
	}
}
