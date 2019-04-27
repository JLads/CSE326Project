package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * a panel for loading a results file
 * @author nicholas
 *
 */
public class LoadResultsFilePanel extends AbstractFileIOPanel{

	private static final long serialVersionUID = 2822555162484286453L;
	
	/**
	 * default constructor
	 */
	public LoadResultsFilePanel() {
		this.panelLabel="Enter the file path for a Results file to load.";
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
		AbstractPanel.getFrame().changePanel(new AnalysisOutputFilePanel(fp));
	}
	
}
