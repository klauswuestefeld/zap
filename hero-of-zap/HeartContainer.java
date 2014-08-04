class HeartContainer extends Thing {

	@Override
	void collideWith(Thing other) {
		if (other instanceof Hero) disappear();
	}

}
