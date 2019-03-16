package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private int numSeq;		//the number of sequences to test
	private int finSeq = 0;	//the number of sequences that have been tested
	
	/**
	 * constructor
	 */
	public RunTestPanel() {
		this.numSeq = TestRetriever.proxyGetListSize();
		buildPanel();
	}
	
	/**
	 * records the result of a test
	 * @param result boolean true for yes and false for no
	 */
	private void recordResult(Boolean result) {
		if(result) {
			ResultLogger.proxyLogYes(TestRetriever.proxyGetAnswer(this.finSeq));
		}else {
			ResultLogger.proxyLogNo(TestRetriever.proxyGetAnswer(this.finSeq));
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
		
		JButton playButton = new JButton("Play Audio");
		JButton yesButton = new JButton("Yes");
		JButton noButton = new JButton("No");
		
		Font font = new Font("Aerial", Font.PLAIN, 40);
		playButton.setFont(font);
		yesButton.setFont(font);
		noButton.setFont(font);
		
		yesButton.setEnabled(false);
		noButton.setEnabled(false);
		
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 1; i <= 2; i++) {
					for(String file : TestRetriever.proxyGetSequence(finSeq, i)) {
						ClipPlayer.playSoundFile(file);
					}
				}
				
				playButton.setEnabled(false);
				yesButton.setEnabled(true);
				noButton.setEnabled(true);
			}
		});
		
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordResult(true);
				if((finSeq+1)==numSeq) {
					AbstractPanel.getFrame().changePanel(new EndTestPanel());
				}
				playButton.setEnabled(true);
				yesButton.setEnabled(false);
				noButton.setEnabled(false);
				finSeq+=1;
			}
		});
		
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordResult(false);
				if((finSeq+1)==numSeq) {
					AbstractPanel.getFrame().changePanel(new EndTestPanel());
				}
				playButton.setEnabled(true);
				yesButton.setEnabled(false);
				noButton.setEnabled(false);
				finSeq+=1;
			}
		});
		
		JLabel label = new JLabel("Were the sequences similar?");
		font = new Font("Aerial", Font.PLAIN, 20);
		label.setFont(font);
		
		gbc.gridx=1;
		gbc.gridy=0;
		this.add(playButton, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		this.add(label, gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(yesButton, gbc);
		
		gbc.gridx=2;
		gbc.gridy=2;
		this.add(noButton, gbc);
	}
}
