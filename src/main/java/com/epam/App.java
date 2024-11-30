package com.epam;

import java.util.ArrayList;

/**
 * Main class App
 */
public class App {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SortingApp sorting = new SortingApp();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String arg : args) {
            numbers.add(Integer.parseInt(arg));
        }
        sorting.sort(numbers);
    }
}
