package com.cloud.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
	
	
	
	public List<String> fileReader(){
		String fileName = "./wordlist.txt";
		List<String> listWords = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName), Charset.forName("ISO-8859-1"))) {

			stream.sorted((anaString1, anaString2) -> Integer.compare(anaString1.length(),anaString2.length()))
            .forEach(listWords::add);


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listWords;
	}

}
