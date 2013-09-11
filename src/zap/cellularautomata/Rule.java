package zap.cellularautomata;


public class Rule {

	int rule = 0;

	public Rule(int rule) {
		super();
		this.rule = rule;
	}

	public boolean outside() {
		return false;
	}
	
	public boolean valueFor(boolean a, boolean b, boolean c) {
		if (matches(a, b, c, 0, 0, 0)) return ((rule >> 0) & 0x01) > 0;
		if (matches(a, b, c, 0, 0, 1)) return ((rule >> 1) & 0x01) > 0;
		if (matches(a, b, c, 0, 1, 0)) return ((rule >> 2) & 0x01) > 0;
		if (matches(a, b, c, 0, 1, 1)) return ((rule >> 3) & 0x01) > 0;
		if (matches(a, b, c, 1, 0, 0)) return ((rule >> 4) & 0x01) > 0;
		if (matches(a, b, c, 1, 0, 1)) return ((rule >> 5) & 0x01) > 0;
		if (matches(a, b, c, 1, 1, 0)) return ((rule >> 6) & 0x01) > 0;
		if (matches(a, b, c, 1, 1, 1)) return ((rule >> 7) & 0x01) > 0;
		throw new IllegalStateException();
	}

	public boolean matches(boolean a, boolean b, boolean c, int aMatch, int bMatch, int cMatch) {
		return a == (aMatch == 1) && b == (bMatch == 1) && c == (cMatch == 1);
	}

}
