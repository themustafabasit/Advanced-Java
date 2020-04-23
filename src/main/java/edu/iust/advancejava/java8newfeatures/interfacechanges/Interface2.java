package edu.iust.advancejava.java8newfeatures.interfacechanges;

public interface Interface2 {
    String method2();

    default String log(String str){
        return "Interface2 logging:: " + str;

    }
}
