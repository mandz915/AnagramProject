package com.cloud.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Anagram {
	
	public static List<String> getAnagram(List<String> wordList){
		List<String> del = new ArrayList<>();
		List<String> finalList = new ArrayList<>();
		String matchingString;
		boolean wordflag = false;
		String concatString = "";
		
		for (String firstWord : new ArrayList<String>(wordList)) {
			wordList.remove(firstWord);
			Iterator<String> iterator = wordList.iterator();
			char[] string1Array = firstWord.toLowerCase().toCharArray();
			Arrays.sort(string1Array);
			
			while (iterator.hasNext()) {
				matchingString = iterator.next();
					if (matchingString.length() == firstWord.length()) {
						
						char[] string2Array = matchingString.toLowerCase().toCharArray();
						
						Arrays.sort(string2Array);
						if (Arrays.equals(string1Array, string2Array)) {
							if(wordflag){
								concatString = concatString.concat(" ").concat(matchingString);
								
							} else {
								concatString = concatString.concat(firstWord).concat(" ").concat(matchingString);
								wordflag = true;
							}
							del.add(matchingString);
						}
					} else {						
						break;
					}
			}
			if(!del.isEmpty()){
				finalList.add(concatString);
				System.out.println(concatString);
				concatString = "";
				wordflag = false;
				wordList.removeAll(del);
				del.clear();
			}
		}	
//		for(String x : finalList){
//			System.out.println(x);
//		}
		return finalList;
	}

}
