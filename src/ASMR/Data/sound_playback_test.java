package ASMR.Data;

import java.io.File;

import javax.sound.sampled.*;

public class sound_playback_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File testfile = new File("killedkenny.wav");
			AudioInputStream st;
			AudioFormat fmt;
			DataLine.Info info;
			Clip clip;
		
			st = AudioSystem.getAudioInputStream(testfile);
			fmt = st.getFormat();
			info = new DataLine.Info(Clip.class, fmt);
			clip = (Clip) AudioSystem.getLine(info);
			
			clip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					if(event.getType() == LineEvent.Type.STOP) {
						clip.close();
					}
				}
			});
			
			clip.open(st);
			clip.start();
			Thread.sleep(4500);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
