package zapman;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Sound {

	private static Map<String, Deque<AudioClip>> clipPoolByName = new HashMap<>();
	
	public static void play(final String fileName) {
		new Thread() { @Override public void run() {
			AudioClip clip = borrowClip(fileName);
			clip.play();
			try { Thread.sleep(3000); } catch (InterruptedException e) {}
			clip.stop();
			returnClip(fileName, clip);
		}}.start();
	}

	synchronized
	private static AudioClip borrowClip(final String fileName) {
		Deque<AudioClip> clipPool = clipPoolByName.get(fileName);
		if (clipPool == null) {
			clipPool = new ArrayDeque<>(); //Basically a stack
			clipPoolByName.put(fileName, clipPool);
		}
		AudioClip clip = clipPool.pollFirst();
		if (clip == null) {
			clip = Applet.newAudioClip(Sound.class.getResource(fileName + ".wav"));
			clipPool.addFirst(clip);
		}
		return clip;
	}

	synchronized
	static private void returnClip(final String fileName, AudioClip clip) {
		clipPoolByName.get(fileName).addFirst(clip);
	}
}
