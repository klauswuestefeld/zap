
class BossPart extends Thing {

	BossHead head;

	void hit() {
		head.lives = head.lives - 1;
		if (head.lives == 0) head.direction = none;
	}

}
