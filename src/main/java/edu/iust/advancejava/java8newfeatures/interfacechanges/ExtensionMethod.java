package edu.iust.advancejava.java8newfeatures.interfacechanges;

// This class Implements a Interface called Vehicle with a non-abstract method(Extension Method)
public class ExtensionMethod implements Vehicle {

    // Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the default keyword.
    // Java interface default methods are also referred to as Defender Methods or Virtual extension methods.

    @Override
    public String changeGear() {
        return "Gear Changed";
    }

    @Override
    public String speedUp() {
        return "Speed Increased";
    }

    // can we Override Extension Method?
    // yes, Extension methods can be Overridden, Conditions Apply - see Diamond Problem with Extension Methods

    // If any class in the hierarchy has a method with same signature,
    // then default methods become irrelevant.
    // A default method cannot override a method from java.lang.Object

    /*
    @Override
    public String applyBreaks(){
        return "Do or Die";
    }
    */

}



