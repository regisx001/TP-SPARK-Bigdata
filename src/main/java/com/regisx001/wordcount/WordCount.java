package com.regisx001.wordcount;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {

    public static void main(String[] args) {

        if (args.length < 2) {

            System.err.println("Usage: WordCountTask <input> <output>");
            System.exit(1);
        }

        SparkConf conf = new SparkConf()
                // .setMaster("local[*]")
                .setAppName("WordCount");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> textFile = sc.textFile(args[0]);

        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);

        counts.saveAsTextFile(args[1]);

        sc.close();
    }
}