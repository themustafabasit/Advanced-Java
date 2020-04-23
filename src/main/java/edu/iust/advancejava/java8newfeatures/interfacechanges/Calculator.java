package edu.iust.advancejava.java8newfeatures.interfacechanges;

public interface Calculator {

    // abstract method
    int sum (int x, int y);

        // default method, can be Overridden
    default int cube(int n){
        // call to static method square
        return square(n) * n;
    }

    static int square(int n){
        return n * n;
    }
}
