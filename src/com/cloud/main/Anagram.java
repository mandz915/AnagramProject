package com.cloud.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Anagram {
	static Logger logger = LogManager.getLogger(Anagram.class);
	private List<String> finalList = new ArrayList<>();
	private int countwords = 0;

	public Anagram() {
		/*
		 * This is a constructor
		 * 
		 */
	}

	public List<String> getAnagram(List<String> wordList) {
		List<String> del = new ArrayList<>();

		String matchingString;
		String concatString = "";
		char[] string2Array;
		char[] string1Array;
		for (String firstWord : new ArrayList<String>(wordList)) {
			wordList.remove(firstWord);
			Iterator<String> iterator = wordList.iterator();
			string1Array = firstWord.toCharArray();
			Arrays.sort(string1Array);

			while (iterator.hasNext()) {
			
				matchingString = iterator.next();
				if (matchingString.length() == firstWord.length()) {

					string2Array = matchingString.toCharArray();
					Arrays.sort(string2Array);

					if (Arrays.equals(string1Array, string2Array)) {
						concatString = concatString.concat(" ").concat(matchingString);
						del.add(matchingString);
						countwords++;
					}
				} else {
					break;
				}
			}
			if (!del.isEmpty()) {
				this.finalList.add(firstWord.concat(concatString));
				countwords++;
				logger.info("Wordcount : " + countwords + " : " + firstWord.concat(concatString));
				concatString = "";
				wordList.removeAll(del);
				del.clear();
			}
		}
		return getFinalList();
	}

	public List<String> getFinalList() {
		return finalList;
	}

	public void setFinalList(List<String> finalList) {
		this.finalList = finalList;
	}

	public int getCountWords() {
		return this.countwords;
	}

}
