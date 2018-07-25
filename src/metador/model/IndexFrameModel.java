package metador.model;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class IndexFrameModel {
	
	private ButtonGroup frontMaskRadioBtnGroup = new ButtonGroup();
	private JRadioButton showFolderFrameRadioBtn = new JRadioButton("Edit folder my adding manually the tag values");
	private JRadioButton showCopyFrameRadioBtn = new JRadioButton("Edit folder by using tags from a selected file");
	private JButton frontMaskNextBtn = new JButton("Next");

	public IndexFrameModel(){
//		frontMaskNextBtn.addActionListener(FirstFrameOption());
		groupButton();
	}
	

	
	public void groupButton() {
		frontMaskRadioBtnGroup.add(showFolderFrameRadioBtn);
	    frontMaskRadioBtnGroup.add(showCopyFrameRadioBtn);	
	}
	
	public JRadioButton getShowCopyFrameRadioBtn() {
		return showCopyFrameRadioBtn;
	}
	
	public JRadioButton getShowFolderFrameRadioBtn() {
		return showFolderFrameRadioBtn;
	}
	
	public ButtonGroup getFrontMaskRadioBtnGroup() {
		return frontMaskRadioBtnGroup;
	}
	
	public JButton getFrontMaskNextBtn() {
		return frontMaskNextBtn;
	}
}
