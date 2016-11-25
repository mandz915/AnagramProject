package com.cloud.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AnagramRunner {

	public static void main(String[] args) {

		List<String> wordList = new FileReader().fileReader();
		List<String> anagramList = Anagram.getAnagram(wordList);
		
		Path file = Paths.get("anagram.txt");
		try {
			Files.write(file, anagramList, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String string : anagramList) {
			System.out.println(string);
		}
		
	}

}
