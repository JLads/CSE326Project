package ASMR.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class plays back audio files, which may be played simultaneously, and has no volume control.
 *
 * @author Steven
 */
public class ClipPlayer {
	
	/**
	 * Obtain a file's extension as an uppercase string
	 * 
	 * @param filePath The file path of the file
	 * @return The string representation of a file extension
	 */
	private static String getFileExtension(String filePath) {
		String fileExtension = filePath.split(".")[1];
		return fileExtension.toUpperCase();
	}

	/**
	 * Obtains the URL of a sound file's file path.
	 * 
	 * @param soundFilePath The file path of the sound file.
	 * @return The java.net URL of the sound file.
	 * @throws IOException
	 * @throws InvalidPathException 
	 */
	private static URL getSoundFileURL(String soundFilePath)
	throws IOException, InvalidPathException {
		// Convert file path into a URL object
		return ClipPlayer.class.getResource(soundFilePath);
	}
	
	/**
	 * Generates an AudioClip object for a sound file.
	 * 
	 * @param soundFilePath The file path of the sound file.
	 * @return An AudioClip object for the sound file.
	 * @throws InvalidPathException 
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 */
	private static Clip loadSoundClip(String soundFilePath)
	throws LineUnavailableException {

		try {
			// Get audio input stream from file URL
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getSoundFileURL(soundFilePath));
			Clip soundClip = AudioSystem.getClip();

			// Open audio output line
			soundClip.open(audioIn);
			return soundClip;
		}
		catch (InvalidPathException | IOException | NullPointerException e) {
			throw new IllegalArgumentException("Sound file missing or corrupted: " + soundFilePath);
		}
		catch (UnsupportedAudioFileException e) {
			throw new IllegalArgumentException("Unsupported file type: " + getFileExtension(soundFilePath));
		}
	}

	/**
	 * Plays a sound file given its file path.
	 * 
	 * @param soundFilePath The file path of the sound file.
	 * @throws IllegalArgumentException
	 */
	public static void playSoundFile(String soundFilePath) throws IllegalArgumentException {

		try {
			Clip soundClip = loadSoundClip(soundFilePath);
			soundClip.start();
		}
		catch (LineUnavailableException lue) {
			System.err.println("Critical error: " + lue.getMessage());
		}
	}

	// Test audio playback
	public static void main(String[] args) {
		try {
			playSoundFile("/home/boogie/Documents/Spring2019/cse326/CSE326Project/killedkenny.wav");
			Thread.sleep(1000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
