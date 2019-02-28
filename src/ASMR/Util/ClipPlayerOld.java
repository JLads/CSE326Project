package ASMR.Util;



import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
//import javax.sound.sampled.LineListener;

/**
 * This class plays back audio files
 * It can be called in succession with different files and will dynamically sleep
 * the running thread for the duration of the play back, after which the completed state flag
 * is reset.
 * @author Joseph, Steven
 *
 */
public class ClipPlayerOld {
	static boolean complete = false;
	
	
	public static void playfile(String filePath) {
		try {
			File testfile = new File(filePath); //using passed in file path for file
			AudioInputStream st; 
			AudioFormat fmt;
			DataLine.Info info;
			Clip clip;
		
			//gets audio input stream from specified file
			st = AudioSystem.getAudioInputStream(testfile);
			
			//gets the audio file format
			fmt = st.getFormat();
			
			//sets data line format and buffer size
			info = new DataLine.Info(Clip.class, fmt);
			
			//pre-loads the audio data line for play back
			clip = (Clip) AudioSystem.getLine(info);
			
			//data line listener to check for end of play back
			clip.addLineListener((LineEvent event) -> {
				if(event.getType() == LineEvent.Type.STOP) { //clip has ended
					//System.out.println("Play Stop"); //debugging print
					complete = true;
					clip.close();
				} else if (event.getType() == LineEvent.Type.START) { //clip has started
					//System.out.println("Play Start"); //debugging print
				}
			});
			
			//allocate system resources to clip for play back
			clip.open(st); 
			
			//start play back
			clip.start();
			while (complete == false) { //sleep thread until audio clip has ended
				Thread.sleep(100);
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			//reset play back completion flag
			complete = false;
		}
		//test print
		//System.out.println("complete = " + complete);
	}
}
