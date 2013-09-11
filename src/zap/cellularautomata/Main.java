package zap.cellularautomata;


public class Main {

	public static void main(String[] args) {

//		Rule rule = new Rule(161);
//		Matrix matrix = Generator.generate(901, 901, rule);
//		new Screen(matrix, 1, rule);

		
		for (int i = 160; i <= 169; i++) {
			Rule rule = new Rule(i);
			Matrix matrix = Generator.generate(901, 211, rule);
			new Screen(matrix, 1, rule);
		}
		
	}

}
