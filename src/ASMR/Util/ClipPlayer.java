package ASMR.Util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * This class plays back audio files. They may be played simultaneously. There is no volume control.
 *
 * @author Steven
 */
public class ClipPlayer {
	
	/**
	 * Obtains the URL of a sound file's filepath.
	 * @param soundFilePath The filepath of the sound file.
	 * @return The java.net URL of the sound file.
	 * @throws MalformedURLException
	 * @throws InvalidPathException 
	 */
	private static URL getSoundFileUrl(String soundFilePath)
	throws MalformedURLException, InvalidPathException {
		// Convert file path into a URL object
		return Paths.get(soundFilePath).toUri().toURL();
	}
	
	/**
	 * Generates an AudioClip object for a sound file.
	 * @param soundFilePath The filepath of the sound file.
	 * @return An AudioClip object for the sound file.
	 * @throws MalformedURLException
	 * @throws InvalidPathException 
	 */
	private static AudioClip loadSoundClip(String soundFilePath)
	throws MalformedURLException, InvalidPathException {
		// Obtain audio clip from file path
		return Applet.newAudioClip(getSoundFileUrl(soundFilePath));
	}

	/**
	 * Plays a sound file given its filepath.
	 * @param soundFilePath The filepath of the sound file.
	 * @throws IllegalArgumentException
	 */
	public static void playSoundFile(String soundFilePath) throws IllegalArgumentException {
		AudioClip soundClip;

		try {
			soundClip = loadSoundClip(soundFilePath);
			soundClip.play();
		}
		catch (MalformedURLException | InvalidPathException e) {
			throw new IllegalArgumentException("Sound file missing or corrupted:" + soundFilePath);
		}
	}

	// Test audio playback
	/*
	public static void main(String[] args) {
		try {
			playSoundFile("killedkenny.wav");
			Thread.sleep(1000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	*/
}
