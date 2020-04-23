package edu.iust.advancejava.java8newfeatures.interfacechanges;

public interface Interface1 {
    String method1();

    default String log(String str){
        return "Interface1 logging:: " + str;
    }
}
