package com.bitesnake.method_reference;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * Method Reference Practice Part 1
 * Suppose you want to filter all the hidden files in a dictionary
 */
public class Demo1 {

    public void filterFiles() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
    }

    public static void main(String[] args) {

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list){
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
