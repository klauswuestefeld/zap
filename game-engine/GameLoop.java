import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_UP;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

class GameLoop extends Utils {
	
	Game game;
	GraphicCanvas canvas;
	
	JFrame frame;
	
	
	GameLoop(Game game) {
		this.game = game; 
		initFrame();
	}


	public void start()  {
		while (true) {
			act();
			refreshGraphics();
			refreshTitle();
			waitALittle();
		}
	}
	
	
	private void act() {
		List<Thing> things = new ArrayList<Thing>();
		for (Square[] line : game.scene)
			for (Square square : line)
				if (square.thing != null) {
					things.add(square.thing);
				}
		for (Thing t : things){
			t.act();
			if (t.square != null && t.square.thing != t) oops("Wrong thing!");
		}
		game.act();
	}


	private void refreshTitle() {
		frame.setTitle(game.title());
	}


	private void handleKey(int key) {
		if (key == VK_SPACE) game.space();
		if (key == VK_UP) game.up();
		if (key == VK_DOWN) game.down();
		if (key == VK_LEFT) game.left();
		if (key == VK_RIGHT) game.right();
		if (key == KeyEvent.VK_SHIFT) game.shift();
		refreshGraphics();
	}


	private void refreshGraphics() {
		adaptSizeTo(game.scene);
		canvas.repaint();
	}


	private void adaptSizeTo(Square[][] screen) {
		if (screen == null) Utils.oops("you must call setScene().");

		Insets insets = frame.getInsets();
		int width = screen[0].length * GraphicCanvas.SPRITE_SIZE * GraphicCanvas.PIXEL_SIZE + insets.left + insets.right;
		int height = screen.length * GraphicCanvas.SPRITE_SIZE * GraphicCanvas.PIXEL_SIZE + insets.top + insets.bottom;
		frame.setSize(width, height);
	}

	
	private void initFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GraphicCanvas(game);
		canvas.setFocusable(true);
		
		frame.add(canvas);
		frame.setVisible(true);
		
		canvas.addKeyListener(new KeyAdapter() { @Override public void keyPressed(KeyEvent e) {
			handleKey(e.getKeyCode());
		}});
	}
	
	
	private void waitALittle() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
