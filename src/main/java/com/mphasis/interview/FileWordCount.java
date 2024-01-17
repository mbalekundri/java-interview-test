package com.mphasis.interview;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import com.mphasis.interview.common.CommonUtils;

public class FileWordCount {

    public static void main(String args[]) throws URISyntaxException {
	long wordCount = 0;
	File file = CommonUtils.getFileFromResource("WordCount.txt");

	try (Stream<String> fileLines = Files.lines(Paths.get(file.getAbsolutePath()), Charset.defaultCharset())) {
	    wordCount = fileLines.flatMap(line -> Arrays.stream(line.split(" "))).count();
	} catch (IOException ioException) {
	    ioException.printStackTrace();
	}
	System.out.println("Number of words in WordCount.txt: " + wordCount);
    }

}
