package metador.model;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileSystemView;

public class FolderFunctionModel {

	// textfields
	private JTextField tfArtist = new JTextField();
	private JFormattedTextField tfYear = new JFormattedTextField();
	private JTextField tfAlbum = new JTextField();

	// textlabels
	private JTextPane tpArtist = new JTextPane();
	private JTextPane tpAlbum = new JTextPane();
	private JTextPane tpYear = new JTextPane();
	private JTextPane pathOutput = new JTextPane();
	private JTextPane statusField = new JTextPane();

	// buttons
	private JFileChooser chooseFolderFrame = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private JButton chooseFolderButton = new JButton("Choose folder...");
	private JButton executor = new JButton("Execute");

	public static ActionListener al;
	public static ActionListener executeListener;

	public JButton getExecutor() {
		return executor;
	}

	public void setExecutor(JButton executor) {
		this.executor = executor;
	}

	public JFileChooser getChooseFolderFrame() {
		chooseFolderFrame.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		return chooseFolderFrame;
	}

	public void setChooseFolderFrame(JFileChooser chooseFolderFrame) {
		this.chooseFolderFrame = chooseFolderFrame;
	}

	public JTextPane getTpYear() {
		tpYear.setText("Year");
		tpYear.setEditable(false);
		return tpYear;
	}

	public void setTpYear(JTextPane tpYear) {
		this.tpYear = tpYear;
		this.tpYear.setPreferredSize(new Dimension(200, 24));
	}

	public JTextPane getTpArtist() {
		tpArtist.setText("Artist");
		tpArtist.setEditable(false);
		return tpArtist;
	}

	public void setTpArtist(JTextPane tpArtist) {
		this.tpArtist = tpArtist;
		this.tpArtist.setPreferredSize(new Dimension(200, 24));
	}

	public JTextPane getTpAlbum() {
		tpAlbum.setText("Album");
		tpAlbum.setEditable(false);
		return tpAlbum;
	}

	public void setTpAlbum(JTextPane tpAlbum) {
		this.tpAlbum = tpAlbum;
		this.tpAlbum.setPreferredSize(new Dimension(200, 24));
	}

	public JTextField getTfArtist() {
		return tfArtist;
	}

	public void setTfArtist(JTextField tfArtist) {
		this.tfArtist = tfArtist;
		this.tfArtist.setVisible(true);
		this.tfArtist.setPreferredSize(new Dimension(200, 24));
	}

	public JFormattedTextField getTfYear() {
		return tfYear;
	}

	public void setTfYear(JFormattedTextField tfYear) {
		this.tfYear = tfYear;
		this.tfYear.setVisible(true);
		this.tfYear.setPreferredSize(new Dimension(200, 24));
	}

	public JTextField getTfAlbum() {
		return tfAlbum;
	}

	public void setTfAlbum(JTextField tfAlbum) {
		this.tfAlbum = tfAlbum;
		this.tfAlbum.setVisible(true);
		this.tfAlbum.setPreferredSize(new Dimension(200, 24));
	}

	public JTextPane getPathOutput() {
		return pathOutput;
	}

	public void setPathOutput(JTextPane pathOutput) {
		this.pathOutput = pathOutput;
		// this.pathOutput.setPreferredSize(new Dimension(400, 48));
	}

	public void setChooseFolderButton(JButton chooseFolderButton) {
		this.chooseFolderButton = chooseFolderButton;
	}

	public JButton getChooseFolderButton() {
		return chooseFolderButton;
	}

	public JTextPane getStatusField() {
		return statusField;
	}

	public void setStatusField(JTextPane statusField) {
		this.statusField = statusField;
	}
}
