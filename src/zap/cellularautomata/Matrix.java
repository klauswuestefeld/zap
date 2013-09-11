package zap.cellularautomata;


public class Matrix {

	public Matrix(int len, int wid) {
		data = new boolean[len][wid];
		data[0][wid / 2] = true;
	}

	public boolean[][] data;
	
}
