package ASMR.Util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * This class plays back audio files
 * It can be called in succession with different files and will dynamically sleep
 * the running thread for the duration of the play back, after which the completed state flag
 * is reset.
 * @author Steven
 *
 */
public class ClipPlayer {
	
	private static URL getSoundFileUrl(String soundFilePath)
	throws MalformedURLException, InvalidPathException {
		// Convert file path into a URL object
		return Paths.get(soundFilePath).toUri().toURL();
	}
	
	private static AudioClip loadSoundClip(String soundFilePath)
	throws MalformedURLException, InvalidPathException {
		// Obtain audio clip from file path
		return Applet.newAudioClip(getSoundFileUrl(soundFilePath));
	}

	public static void playSoundFile(String soundFilePath) {
		AudioClip soundClip;

		try {
			soundClip = loadSoundClip(soundFilePath);
			soundClip.play();
		}
		catch (MalformedURLException | InvalidPathException e) {
			throw new IllegalArgumentException("Unable to play" + soundFilePath);
		}
	}

	// Test audio playback
	/*
	public static void main(String[] args) {
		try {
			playSoundFile("killedkenny.wav");
			Thread.sleep(4000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	*/
}
