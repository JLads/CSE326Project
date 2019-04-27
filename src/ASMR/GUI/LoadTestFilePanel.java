package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import ASMR.Data.TestRetriever;

/**
 * A panel for retrieving the filepath to a test file to load  
 * @author nicholas
 *
 */
public class LoadTestFilePanel extends AbstractFileIOPanel{
	
	private static final long serialVersionUID = -7660337987383230213L;
	
	/**
	 * default constructor
	 */
	public LoadTestFilePanel() {
		this.panelLabel = "Enter the file path for a Test file to load.";
		this.buildPanel();

		this.chooser.setFileFilter(new FileNameExtensionFilter("CSV FILE", "csv"));
		
		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("Aerial", Font.PLAIN, 20));
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					AbstractPanel.getFrame().changePanel(new MainPanel());
			}
		});
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy=3;
		this.add(returnButton, gbc);
	}

	@Override
	public void processFilepath(String fp) {
		TestRetriever.proxyBuildList(fp);
		AbstractPanel.getFrame().changePanel(new StartTestPanel());
	}
}
