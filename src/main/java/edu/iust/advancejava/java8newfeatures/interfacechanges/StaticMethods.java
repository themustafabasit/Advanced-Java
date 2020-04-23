package edu.iust.advancejava.java8newfeatures.interfacechanges;

// This class implements a interface called "Calculator" which implements a static method
public class StaticMethods implements Calculator{

    // Java interface static method is similar to default method(virtual extension method) except that we
    // can’t override them in the implementation classes.

    //Java interface static method helps us in providing security by not allowing implementation classes to override them.

    @Override
    public int sum(int x, int y) {
        return x + y;
    }


    // Note that below method square(int x, int y) is a simple class method, it’s not overriding the interface method.
    // For example, if we will add @Override annotation to method, it will result in compiler error.
    public int square(int n){
        // i'm returning 99 just to prove that this is not actual square function
        return 99;

    }

    // To call "static interface method" from outside the interface the standard approach for static method call should be used:
    // call to actual square() function
    public int callToInterfaceSquare(int n){
        int res =  Calculator.square(n);
        return res;
    }




}
