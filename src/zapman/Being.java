package zapman;

class Being {
	
	boolean isDead = false;
	
	void hit(Being other) {
		
	}

	void die() {
		isDead = true;
		Sound.play("fantasma morte c");
	}

}
