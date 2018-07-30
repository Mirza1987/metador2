package metador.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import entagged.audioformats.AudioFile;
import entagged.audioformats.AudioFileIO;
import entagged.audioformats.exceptions.CannotReadException;
import metador.controller.Executor;
import metador.model.FolderFunctionModel;

public class CopyFunctionFrame extends JFrame {

	private static final long serialVersionUID = 5165716999949967852L;
	private JPanel contentPane = new JPanel();
	public static ActionListener al;
	public static ActionListener executeListener;

	FolderFunctionModel ffm = new FolderFunctionModel();

	public CopyFunctionFrame() {
		super("Metador2");
		setLocationRelativeTo(null); 
		contentPane.setLayout(new GridLayout(5, 1));

		contentPane.add(ffm.getTpArtist());
		contentPane.add(ffm.getTpArtistCopyFunction());
		contentPane.add(ffm.getTpAlbum());
		contentPane.add(ffm.getTpAlbumCopyFunction());
		contentPane.add(ffm.getTpYear());
		contentPane.add(ffm.getTpYearCopyFunction());

		contentPane.add(ffm.getPathOutput());
		contentPane.add(ffm.getChooseFileButton());
		contentPane.add(ffm.getExecutor());
		contentPane.add(ffm.getStatusField());
		
		ffm.getChooseFileButton().addActionListener(msgForFileChooser());
		ffm.getExecutor().addActionListener(converter());

		setContentPane(contentPane);
		pack();
		setVisible(true);
	}

	private ActionListener msgForFileChooser() {
		
		ffm.getChooseFileFrame().setFileFilter(new FileNameExtensionFilter("MP3 Files", "mp3"));
		
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ffm.getChooseFileFrame().showOpenDialog(contentPane)) {
				case JFileChooser.APPROVE_OPTION:

					JOptionPane.showMessageDialog(contentPane, "Cancelled", "FCDemo", JOptionPane.OK_OPTION);

					break;

				case JFileChooser.CANCEL_OPTION:
					JOptionPane.showMessageDialog(contentPane, "Cancelled", "FCDemo", JOptionPane.OK_OPTION);
					break;

				case JFileChooser.ERROR_OPTION:
					JOptionPane.showMessageDialog(contentPane, "Error", "FCDemo", JOptionPane.OK_OPTION);
				}
			}
		};

		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ffm.getChooseFileFrame().showSaveDialog(contentPane)) {
				case JFileChooser.APPROVE_OPTION:

					String locationPath = ffm.getChooseFileFrame().getSelectedFile().getAbsolutePath();
					File selectedFile = ffm.getChooseFileFrame().getSelectedFile();
										
					if(selectedFile.getName().endsWith(".mp3")){
						AudioFile audioFile;
						try {
							audioFile = AudioFileIO.read(selectedFile);			
							ffm.getTpArtistCopyFunction().setText(audioFile.getTag().getArtist().toString().substring(1, audioFile.getTag().getArtist().toString().length()-1));
							ffm.getTpAlbumCopyFunction().setText(audioFile.getTag().getAlbum().toString().substring(1, audioFile.getTag().getAlbum().toString().length()-1));
							ffm.getTpYearCopyFunction().setText(audioFile.getTag().getYear().toString().substring(1, audioFile.getTag().getYear().toString().length()-1));
							ffm.getPathOutput().setText(locationPath);
						} catch (CannotReadException e) {
							e.printStackTrace();
						}						
					}
					break;
				case JFileChooser.CANCEL_OPTION:
					JOptionPane.showMessageDialog(contentPane, "Cancelled", "FCDemo", JOptionPane.OK_OPTION);
					break;

				case JFileChooser.ERROR_OPTION:
					JOptionPane.showMessageDialog(contentPane, "Error", "FCDemo", JOptionPane.OK_OPTION);
				}
			}
		};

		return al;
	}

	private ActionListener converter() {
		executeListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//				String year = ffm.getTfYear().getText();
//				try {
//					
//					if(year!=null){
//						Integer.parseInt(year);
//					}
					Executor.Execute(ffm);
					ffm.getStatusField().setText("DONE!");
					
//				} catch (Exception e1) {
//					System.out.println(e1);
//					ffm.getStatusField().setText("Year must be number");
//				}
			}
		};
		return executeListener;
	}

}
