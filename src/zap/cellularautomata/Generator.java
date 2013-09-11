package zap.cellularautomata;


public class Generator {

	public static Matrix generate(int len, int wid, Rule rule) {
		Matrix matrix = new Matrix(len, wid);
		
		for(int lin = 1; lin < matrix.data.length; lin++) {
			for(int col = 0; col < matrix.data[0].length; col++) {
				matrix.data[lin][col] = valueFor(lin, col, matrix, rule);
			}
		}

		return matrix;
	}

	private static boolean valueFor(int lin, int col, Matrix matrix, Rule rule) {
		boolean a = col == 0 ? matrix.data[lin -1][matrix.data[lin -1].length - 1] : matrix.data[lin -1][col - 1];
		boolean b = matrix.data[lin -1][col];
		boolean c = col == matrix.data[lin -1].length - 1 ? matrix.data[lin -1][0] : matrix.data[lin - 1][col + 1];
		return rule.valueFor(a, b, c);
	}
	
	
}
