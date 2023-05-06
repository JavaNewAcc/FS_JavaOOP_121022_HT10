package hometask.one;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		Map<String, String> importVocab = new HashMap<>();

		Vocabulary vocab = new Vocabulary();
		try {
			importVocab = vocab.vocabularyReader(new File("Vocabulary.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Translator translator = new Translator("English.in.csv", "Ukrainian.out.csv", importVocab);
		try {
			translator.translator();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			vocab.vocabularyWriter(new File("Vocabulary.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}