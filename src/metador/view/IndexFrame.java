package metador.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import metador.model.IndexFrameModel;

public class IndexFrame extends JFrame {

	private static final long serialVersionUID = -5678514227741498506L;
	private JPanel contentPane = new JPanel();
	static IndexFrameModel ifm = new IndexFrameModel();
	public ActionListener frontMaskOptionSelector;
	
	public IndexFrame() {	
		super("Metador2");
		contentPane.setLayout(new GridLayout(3, 1));	
		contentPane.add(ifm.getShowFolderFrameRadioBtn());
		contentPane.add(ifm.getShowCopyFrameRadioBtn());
		contentPane.add(ifm.getFrontMaskNextBtn());
		
		ifm.getFrontMaskNextBtn().addActionListener(FirstFrameOption());
		setLocationRelativeTo(null); 
		
		setContentPane(contentPane);
		pack();
		setVisible(true);
	}	
	
	public ActionListener FirstFrameOption(){
		return frontMaskOptionSelector = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
								
				if(ifm.getShowFolderFrameRadioBtn().isSelected()) {
					new FolderFunctionFrame();
					setVisible(false);
				}
				else {
					new CopyFunctionFrame();
					setVisible(false);
				}
			}
		};
	}
}
