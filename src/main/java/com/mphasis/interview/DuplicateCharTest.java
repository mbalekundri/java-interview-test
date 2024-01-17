package com.mphasis.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DuplicateCharTest {

	public static void main(String[] args) {
		String string = "Java Programming";
		char[] chars = string.toCharArray();
		
		Map<Character,Integer> duplicateMap = new HashMap<>();
		
		for (int i = 0; i < chars.length; i++) {
			if(duplicateMap.get(chars[i]) != null) {
				duplicateMap.put(chars[i], duplicateMap.get(chars[i])+1);
			} else {
				duplicateMap.put(chars[i], 1);
			}
		}
		
		Iterator<Character> itr = duplicateMap.keySet().iterator();
		while(itr.hasNext()) {
			Character myChar = itr.next();
			if(duplicateMap.get(myChar) > 1) {
				System.out.println(myChar+" count: "+duplicateMap.get(myChar));
			}
		}
	}

}
