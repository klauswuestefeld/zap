package textgame;

public interface TextGame {

	void up();
	void down();
	void left();
	void right();
	void space();
	
	void pass();
	
	String title();
	String[] screen();

}
