package com.cloud.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cloud.main.Anagram;
import com.cloud.main.FileReader;

public class JunitTest {

	@Test
	public void testNotNull() {

		assertNotNull(new FileReader().fileReader());
	}

	@Test
	public void testAnagram() {
		List<String> testList = new ArrayList<>();
		testList.add("sort");
		testList.add("rots");
		testList.add("knits");
		testList.add("skins");
		testList.add("sinks");
		testList.add("stink");
		testList.add("enlist");
		testList.add("inlets");
		testList.add("listen");
		testList.add("silent");
		testList.add("boaters");
		testList.add("refresh");
		testList.add("boaster");
		testList.add("borates");
		testList.add("fresher");
		testList.add("kinship");
		testList.add("pinkish");
		Anagram anagram = new Anagram();
		assertNotNull(anagram.getAnagram(testList));

		
	}
	
	@Test
	public void filetest(){
		Anagram anagram = new Anagram();
		assertEquals(20683, anagram.getAnagram(new FileReader().fileReader()).size());
		assertEquals(48162, anagram.getCountWords());
	}
	
}
