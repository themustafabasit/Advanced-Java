package edu.iust.advancejava.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Multiples {
    public static Stream<Integer> multiplesOf5(Stream<Integer> values){
        return values.filter(x -> x % 5 == 0);
    }

    public static Stream<Integer> multiplesOfN(Stream<Integer> values, int n){
        return values.filter(x-> x % n == 0);
    }
    public static int sumOfMultiplesOfN(Stream<Integer> values, int n){
        return values.filter(x-> x % n == 0).reduce(0, (result, x)-> result + x );
    }

    public static IntStream factorsViaInefficientWay(int n){
        return IntStream.range(1, n + 1)
                .filter(x-> n % x == 0 );
    }

    // smallest factor of n is 1
    // highest factor of n is "n" itself
    // (n-1)th factor of n is "n/2"
    // so we need to find factors till n/2
    // n = 120 ; known factors are 1, ........... 60, 120
    //

    public static IntStream factors(int n){
        final int max = n < 5 ? n : n / 2;
        return IntStream.range(1, max)
                .filter(x-> n % x == 0 )
                .flatMap(x-> IntStream.of(x, n / x))
                .sorted();
    }

    public static boolean isPrime(int n){
        return  factors(n).count() == 2;
    }

    public  static IntStream finitePrimeSeries(int n){
        return IntStream.range(1, n + 1)
                .filter(Multiples::isPrime);
    }

   public static IntStream infinitePrimeSeries (){
        return IntStream.iterate(1, n-> n + 1)
                .filter(Multiples::isPrime);

        // why it is getting in infinite loop if I do  n-> n++
   }

}
