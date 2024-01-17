package com.mphasis.interview;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.mphasis.interview.common.CommonUtils;

public class TryWithResourceFileTest {

    public static void main(String[] args) throws URISyntaxException {
	// solution using try-with-resources:
	try (Scanner scanner = new Scanner(CommonUtils.getFileFromResource("WordCount.txt"))) {
	    while (scanner.hasNext()) {
	        System.out.println(scanner.nextLine());
	    }
	} catch (FileNotFoundException fnfe) {
	    fnfe.printStackTrace();
	}
    }
}
