package com.mycompany.spktest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YoutubeTitleWordCount {
    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws IOException {
        Logger.getLogger ("org").setLevel (Level.ERROR);
        // CREATE SPARK CONTEXT
        SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile ("/home/draz/Downloads/java/Day6/OneDrive_1_7-8-2021/SPKTest/src/main/java/USvideos.csv");
        /*
        // TRANSFORMATIONS
        JavaRDD<String> titles = videos
                .map (YoutubeTitleWordCount::extractTitle)
                .filter (StringUtils::isNotBlank);
  
        // JavaRDD<String>
        JavaRDD<String> words_1 = titles.flatMap (title -> Arrays.asList (title
                .toLowerCase ()
                .trim ()
                .replaceAll ("\\p{Punct}", " ")
               .split (" ")).iterator ());
        System.out.println(words_1.toString ());
        // COUNTING
        Map<String, Long> wordCounts_1 = words_1.countByValue ();
        List<Map.Entry> sorted_1 = wordCounts_1.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
        // DISPLAY
        for (Map.Entry<String, Long> entry_1 : sorted_1) {
            System.out.println (entry_1.getKey () + " : " + entry_1.getValue ());
        }
        */
        JavaRDD<String> tags = videos
                .map (YoutubeTitleWordCount::extractTag)
                .filter (StringUtils::isNotBlank);
        /*
        String stopwordsRegex = stopwords.stream()
        	      .collect(Collectors.joining("|", "\\b(", ")\\b\\s?"));
        */
        
        // JavaRDD<String>
        JavaRDD<String> words_2 = tags.flatMap (title -> Arrays.asList (title
                .toLowerCase ()
                .trim ()
                .replaceAll ("\\p{Punct}", " ")
               .split (" ")).iterator ());
        System.out.println(words_2.toString ());
        // COUNTING
        Map<String, Long> wordCounts_2 = words_2.countByValue ();
        
        List<Map.Entry> sorted_2 = wordCounts_2.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
        
        // DISPLAY
        for (Map.Entry<String, Long> entry_2 : sorted_2) {
                System.out.println (entry_2.getKey () + " : " + entry_2.getValue ());
        }
    }
    public static String extractTitle(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }
    
    public static String extractTag(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }
}
