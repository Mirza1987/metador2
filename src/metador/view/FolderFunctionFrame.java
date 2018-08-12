package metador.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import metador.controller.Executor;
import metador.model.FolderFunctionModel;

public class FolderFunctionFrame extends JFrame {

	private static final long serialVersionUID = 5165716999949967852L;
	private JPanel contentPane = new JPanel();
	public static ActionListener al;
	public static ActionListener executeListener;

	FolderFunctionModel ffm = new FolderFunctionModel();

	public FolderFunctionFrame() {
		super("Metador2");
		setLocationRelativeTo(null); 
		contentPane.setLayout(new GridLayout(5, 1));

		contentPane.add(ffm.getTpArtist());
		contentPane.add(ffm.getTfArtist());
		contentPane.add(ffm.getTpAlbum());
		contentPane.add(ffm.getTfAlbum());
		contentPane.add(ffm.getTpYear());
		contentPane.add(ffm.getTfYear());

		contentPane.add(ffm.getPathOutput());
		contentPane.add(ffm.getChooseFolderButton());
		contentPane.add(ffm.getExecutor());
		contentPane.add(ffm.getStatusField());

		ffm.getChooseFolderButton().addActionListener(msgForFileChooser());
		ffm.getExecutor().addActionListener(converter());

		setContentPane(contentPane);
		pack();
		setVisible(true);
	}

	private ActionListener msgForFileChooser() {
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ffm.getChooseFolderFrame().showOpenDialog(contentPane)) {
				case JFileChooser.APPROVE_OPTION:
					JOptionPane.showMessageDialog(contentPane, "Cancelled", "FCDemo", JOptionPane.OK_OPTION);
					break;
				case JFileChooser.CANCEL_OPTION:
					break;
				}
			}
		};

		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ffm.getChooseFolderFrame().showSaveDialog(contentPane)) {
				case JFileChooser.APPROVE_OPTION:
					String locationPath = ffm.getChooseFolderFrame().getSelectedFile().getAbsolutePath();
					locationPath = locationPath.substring(locationPath.length() - 20, locationPath.length());
					ffm.getPathOutput().setText(locationPath);
					break;
				case JFileChooser.CANCEL_OPTION:
					break;
				}
			}
		};

		return al;
	}

	private ActionListener converter() {
		executeListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Executor.Execute(ffm);
				ffm.getStatusField().setText("DONE!");	
			}
		};
		return executeListener;
	}
}