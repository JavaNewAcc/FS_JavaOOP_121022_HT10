package hometask.one;

import java.util.Map;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Translator {
	private String fileInName;
	private String fileOutName;
	private Map<String, String> vocabulary;

	public Translator(String fileInName, String fileOutName, Map<String, String> vocabulary) {
		super();
		this.fileInName = fileInName;
		this.fileOutName = fileOutName;
		this.vocabulary = vocabulary;
	}

	public Translator() {
		super();
	}

	public String getFileInName() {
		return fileInName;
	}

	public void setFileInName(String fileInName) {
		this.fileInName = fileInName;
	}

	public String getFileOutName() {
		return fileOutName;
	}

	public void setFileOutName(String fileOutName) {
		this.fileOutName = fileOutName;
	}

	public Map<String, String> getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Map<String, String> vocabulary) {
		this.vocabulary = vocabulary;
	}

	public void translator() throws IOException {
		File fileIn = new File(fileInName);
		File fileOut = new File(fileOutName);
		try (BufferedReader br = new BufferedReader(new FileReader(fileIn));
				FileWriter fw = new FileWriter(fileOut, true)) {
			for (;;) {
				String currentWord = br.readLine();
				if (currentWord != null) {
					fw.write(vocabulary.get(currentWord) + System.lineSeparator());
				} else {
					return;
				}
			}
		} catch (IOException e) {
			throw e;
		}
	}
}