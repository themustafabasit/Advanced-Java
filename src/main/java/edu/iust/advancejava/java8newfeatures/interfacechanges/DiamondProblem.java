package edu.iust.advancejava.java8newfeatures.interfacechanges;

public class DiamondProblem implements Interface1, Interface2 {
    // We know that Java does't allow us to extend multiple classes because it will result in the “Diamond Problem”
    // where compiler can’t decide which superclass method to use.
    // With the default methods, the diamond problem would arise for interfaces too.
    // Because if a class is implementing both Interface1 and Interface2 and doesn't implement
    // the common default method compiler can’t decide which one to chose

    @Override
    public String method1() {
        return "method1()";
    }

    @Override
    public String method2() {
        return "method2()";
    }

    /*
    Error message, because of Ambiguous "Extension Method - log()"
    edu.iust.advancejava.java8newfeatures.interfacechanges.DiamondProblem inherits unrelated defaults for log(String) from types
    edu.iust.advancejava.java8newfeatures.interfacechanges.Interface1 and
    edu.iust.advancejava.java8newfeatures.interfacechanges.Interface2
    Implement Method log()
     */

    @Override
    public String log(String str) {
        return "Overridden Extension Method log() logging:: " + str;
    }
}
