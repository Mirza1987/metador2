package metador.controller;

import java.io.File;

import entagged.audioformats.AudioFile;
import entagged.audioformats.AudioFileIO;
import entagged.audioformats.exceptions.CannotReadException;
import entagged.audioformats.exceptions.CannotWriteException;
import metador.model.FolderFunctionModel;

public class Executor {

	public static void Execute(FolderFunctionModel fm) {

		File folder = new File(fm.getChooseFolderFrame().getSelectedFile().getAbsolutePath());
		File[] listOfFiles = folder.listFiles();
		String destination = folder.getAbsolutePath();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].getName().endsWith(".mp3")) {

				try {
					String titleName = adjustTitleName(listOfFiles[i].getName().toString().toLowerCase());
					AudioFile audioFile = AudioFileIO.read(listOfFiles[i]);

					audioFile.getTag().setTitle(titleName);

					if (!fm.getTfAlbum().getText().equals("")) {
						audioFile.getTag().setAlbum(fm.getTfAlbum().getText().toString());
					}
					if (!fm.getTfYear().getText().equals("")) {
						audioFile.getTag().addYear(fm.getTfYear().getText());
					}
					if (!fm.getTfArtist().getText().equals("")) {
						audioFile.getTag().setArtist(fm.getTfArtist().getText().toString());
					}

					try {
						audioFile.commit();
						renameFileInFolder(listOfFiles[i], titleName, destination);
					} catch (CannotWriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (CannotReadException e) {

					e.printStackTrace();
				}
			}
		}

		// try {
		// MP3 mp3 = new MP3(listOfFiles[i].toString());
		// String titleName =
		// adjustTitleName(listOfFiles[i].getName().toString().toLowerCase());
		// mp3.setTitle(titleName);
		//
		// if (!fm.getTfAlbum().getText().equals("")) {
		// mp3.setAlbum(fm.getTfAlbum().getText());
		// }
		// if (!fm.getTfYear().getText().equals("")) {
		// int year = Integer.parseInt(fm.getTfYear().getText());
		// mp3.setYear(year);
		// }
		// mp3.save();
		// if (!fm.getTfArtist().getText().equals("")) {

		// System.out.println(mp3.getID3v1Tag());
		// mp3.getID3v1Tag().setArtist(fm.getTfArtist().getText().toString());
		// mp3.setMusicBy(fm.getTfArtist().getText().toString());
		// mp3.setPublisher(fm.getTfArtist().getText().toString());
		// mp3.setBand(fm.getTfArtist().getText().toString());
		// mp3.set
		// mp3.getID3v1Tag().setArtist(fm.getTfArtist().getText().toString());
		// mp3.setBand(fm.getTfArtist().getText().toString());
		// }
		//
		// mp3.save();
		// renameFileInFolder(listOfFiles[i], titleName, destination);
		//
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }
		// }
		// }
	}

	private static String adjustTitleName(String filename) {

		String strArray[] = filename.split(" ");
		String rearrangedFileName = "";

		for (int i = 1; i < strArray.length; i++) {
			String word = strArray[i];
			String newWord = "";

			String filenamePart[] = word.split("");
			filenamePart[0] = filenamePart[0].toUpperCase();

			for (int j = 0; j < filenamePart.length; j++) {
				newWord += filenamePart[j];
			}
			rearrangedFileName += newWord;

			if (i != strArray.length) {
				rearrangedFileName += " ";
			}
		}

		rearrangedFileName = rearrangedFileName.substring(0, rearrangedFileName.lastIndexOf("."));
		return rearrangedFileName;
	}

	private static void renameFileInFolder(File file, String titleName, String destination) {

		String newName = file.getName().toString().toLowerCase().substring(0, 3);
		newName = destination + "\\" + newName + titleName + ".mp3";

		File tempFile = new File(newName);
		file.renameTo(tempFile);

		if (file.exists()) {
			file.renameTo(tempFile);
		}
	}
}