package zapman;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	public static void play(final String fileName) {
		try {
			AudioClip clip = Applet.newAudioClip(Sound.class
					.getResource(fileName + ".wav"));
			clip.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
