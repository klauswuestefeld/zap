package zap.cellularautomata;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Screen extends JFrame {
	
	private final int scale;
	private final Matrix matrix;

	public Screen(Matrix matrix, int scale, Rule rule) {
		super();
		this.matrix = matrix;
		this.scale = scale;
		setTitle("ECA: " + rule.rule);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setVisible(true);
				Insets ins = getInsets();
				setSize((Screen.this.matrix.data[0].length + 1) * Screen.this.scale + ins.left + ins.right, 
						(Screen.this.matrix.data.length + 1) * Screen.this.scale + ins.top + ins.bottom);
			}
		});
	}

	private void draw(Graphics g) {
		Insets ins = getInsets();
		g.setColor(Color.BLACK);
		g.fillRect(ins.left, ins.top, matrix.data[0].length * scale, matrix.data.length * scale);
		g.setColor(Color.WHITE);
		for(int lin = 0; lin < matrix.data.length; lin++) {
			for(int col = 0; col < matrix.data[0].length; col++) {
				boolean val = matrix.data[lin][col];
				if (val)
					g.fillRect(ins.left + col * scale, ins.top + lin * scale, scale, scale);
			}
		}
	}
	

	@Override
	public void paint(Graphics g) {
		draw(g);
	}
	
}
