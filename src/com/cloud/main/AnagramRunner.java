package com.cloud.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnagramRunner {

	static Logger logger = LogManager.getLogger(AnagramRunner.class);

	private AnagramRunner() {
	}

	public static void main(String[] args) {
		process();

	}

	public static void process() {
		List<String> wordList = new FileReader().fileReader();
		Anagram anagram  = new Anagram();
		List<String> anagramList = anagram.getAnagram(wordList);

		Path file = Paths.get("anagram.txt");
		try {
			Files.write(file, anagramList, Charset.forName("UTF-8"));
		} catch (IOException e) {
			logger.error("Error encountered", () -> e);
		}		
	}

}
