package com.epam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Sorting app.
 */
public class SortingApp {

    /**
     * sorting method
     *
     * @param args the arguments from the command line
     */
    public void sort(ArrayList<Integer> args) {
        if (args.size() < 1)
            throw new RuntimeException("No arguments");
        if (args.size() > 10)
            throw new RuntimeException("Too many of arguments");

        Collections.sort(args);
        for (Integer arg : args) {
            System.out.print(arg + " ");
        }
    }
}

