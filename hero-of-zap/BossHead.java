class BossHead extends BossPart {
	int lives = 10;
	int bobsCounter = 5;

	BossPart leg      = new BossLeg();
	BossPart rightArm = new BossRightArm();
	BossPart leftArm  = new BossLeftArm();
	Hero hero;

	BossHead(Hero hero) {
		direction = right;
		leg.head      = this;
		rightArm.head = this;
		leftArm.head  = this;
		this.hero = hero;
	}
	
	void act() {
		if (direction == none) return;
		
		if (bobsCounter != 0) {
			bobsCounter = bobsCounter - 1;
		} else {		
			leg.square.neighbor(left).accept(new Bob(hero));
			leg.square.neighbor(right).accept(new Bob(hero));
			   bobsCounter = 5;
		}
		
		if (direction == left && leg.square.neighbor(direction).thing == null) {
			leftArm.direction = direction;
			leftArm.step();
			if (step()) {
				leg.direction = direction;
				leg.step();
				rightArm.direction = direction;
				rightArm.step();
			} else
				direction = right;
		} if (direction == right && leg.square.neighbor(direction).thing == null) {
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
