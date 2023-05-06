package hometask.one;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Vocabulary {
	Map<String, String> vocabulary = new HashMap<>();

	@Override
	public String toString() {
		return "Vocabulary [vocabulary=" + vocabulary + "]";
	}

	public Map<String, String> getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Map<String, String> vocabulary) {
		this.vocabulary = vocabulary;
	}

	public Vocabulary(Map<String, String> vocabulary) {
		super();
		this.vocabulary = vocabulary;
	}

	public Vocabulary() {
		super();
	}

	public Map<String, String> vocabularyReader(File file) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String curLine = "";
			for (;;) {
				curLine = br.readLine();
				if (curLine != null) {
					String[] stringArr = curLine.split(",");
					vocabulary.put(stringArr[0], stringArr[1]);
				} else {
					return vocabulary;
				}
			}
		} catch (IOException e) {
			throw e;
		}
	}

	public void vocabularyWriter(File file) throws IOException {
		System.out.println("Введіть слово англійською:");
		try (BufferedReader brEng = new BufferedReader(new InputStreamReader(System.in))) {
			String engNewWord = brEng.readLine();
			if (vocabulary.get(engNewWord) == null) {
				System.out.println("Введіть переклад:");
				try (BufferedReader brUkr = new BufferedReader(new InputStreamReader(System.in))) {
					String ukrNewWord = brUkr.readLine();
					try (FileWriter fw = new FileWriter(file, true)) {
						fw.write(engNewWord + "," + ukrNewWord);
					}
				}
			} else {
				System.out.println("Слово " + engNewWord + " вже є в словнику.");
			}
		}
	}
}