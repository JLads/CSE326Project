package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;

import ASMR.Data.TestRetriever;
import ASMR.Data.ResultLogger;
import ASMR.Util.ClipPlayer;

/**
 * A class that implements the panel that handles the testing of sequences
 * @author nicholas
 *
 */
public class RunTestPanel extends AbstractPanel {

	private static final long serialVersionUID = -3562232664994471584L;

	private int numTests;		//the total number of tests
	private int finTests = 0;	//the number of tests that have been completed
	
	/**
	 * constructor
	 */
	public RunTestPanel() {
		this.numTests = TestRetriever.proxyGetListSize();
		buildPanel();
	}
	
	/**
	 * records the result of a test
	 * @param result boolean true for yes and false for no
	 */
	private void recordResult(Boolean result) {
		if(result) {
			ResultLogger.proxyLogYes(TestRetriever.proxyGetAnswer(this.finTests));
		}else {
			ResultLogger.proxyLogNo(TestRetriever.proxyGetAnswer(this.finTests));
		}
	}
	
	/**
	 * builds the contents of the panel
	 */
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//point system
		JLabel pointLabel = new JLabel("Points: " + ResultLogger.proxyGetPoints());
		
		//initialize buttons
		JButton playButton = new JButton("Play Audio");
		JButton yesButton = new JButton("Yes");
		JButton noButton = new JButton("No");
		
		Font font = new Font("Aerial", Font.PLAIN, 40);
		playButton.setFont(font);
		yesButton.setFont(font);
		noButton.setFont(font);
		
		yesButton.setEnabled(false);
		noButton.setEnabled(false);
		
		//set up play button functionality
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 1; i <= 2; i++) {
					for(String file : TestRetriever.proxyGetSequence(finTests, i)) {
						ClipPlayer.playSoundFile(TestRetriever.proxyGetDir(finTests)+"/"+file);
					}
					if(i!=2) {
						try {
							/*
							 * ATTENTION
							 * change line of code below to change the delay between sequences
							 * for time increments less than a second, change SECONDS to either MICROSECONDS, MILLISECONDS, NANOSECONDS
							 * */
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
				
				playButton.setEnabled(false);
				yesButton.setEnabled(true);
				noButton.setEnabled(true);
			}
		});
		
		//set up yes button functionality
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordResult(true);
				pointLabel.setText("Points: " + ResultLogger.proxyGetPoints());
				if((finTests+1)==numTests) {
					AbstractPanel.getFrame().changePanel(new EndTestPanel());
				}
				playButton.setEnabled(true);
				yesButton.setEnabled(false);
				noButton.setEnabled(false);
				finTests+=1;
			}
		});
		
		//set up no button
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordResult(false);
				pointLabel.setText("Points: " + ResultLogger.proxyGetPoints());
				if((finTests+1)==numTests) {
					AbstractPanel.getFrame().changePanel(new EndTestPanel());
				}
				playButton.setEnabled(true);
				yesButton.setEnabled(false);
				noButton.setEnabled(false);
				finTests+=1;
			}
		});
		
		// set up question to user
		JLabel label = new JLabel("Were the sequences the same?");
		font = new Font("Aerial", Font.PLAIN, 20);
		label.setFont(font);
		pointLabel.setFont(font);
		
		//set positions in panel
		gbc.gridx=1;
		gbc.gridy=0;
		this.add(pointLabel, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		this.add(playButton, gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		this.add(label, gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		this.add(yesButton, gbc);
		
		gbc.gridx=2;
		gbc.gridy=3;
		this.add(noButton, gbc);
	}
}
