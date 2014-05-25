package textgame;

public class DemoGame implements TextGame {

	@Override public void up() {}
	@Override public void down() {}
	@Override public void left() {}
	@Override public void right() {}
	@Override public void space() {}
	@Override public void pass() {}

	
	@Override
	public String[] screen() {
		return new String[] { 
			randomLine(),
			randomLine(),
			randomLine(),
			randomLine(),
			randomLine(),
			randomLine(),
			randomLine(),
		};
	}

	
	private String randomLine() {
		String result = "";
		for (int i = 0; i < 7; i++)
			result += randomNumber();
		return result;
	}

	private long randomNumber() {
		return ((System.nanoTime() % 3) + 1);
	}
	
	@Override
	public String title() {
		return "Demo Game";
	}

}
