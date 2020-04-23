package edu.iust.advancejava.streams.lambda;
import static edu.iust.advancejava.streams.lambda.SequenceAggregator.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SequenceAggregatorTest {

    @Test
    void Usingsum() {
        assertEquals(15, sum(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(0, sum(Arrays.asList()));
        assertEquals(0, sum(Collections.emptyList()));
        assertEquals(10, sum(Arrays.asList(new Integer[]{2, 3, 5})));
    }

    @Test
    void usingProduct() {
        assertEquals(24, product(Arrays.asList(1, 2, 3, 4)));
        assertEquals(20, product(Arrays.asList(10, 1, 1, 1, 1, 2)));
        assertEquals(0, product(Arrays.asList(10, 3, 29, 22, 0 , 2, 1, 49, 10)));
    }

    @Test
    void testSimpleReduce() {
        assertEquals(10,simpleReduce(3,(x,y)-> x + y, Arrays.asList(1, 3, 2, 1)));
    }

    @Test
    void testReduce() {
        assertEquals(10, reduce(3, (x,y)-> x + y, Arrays.asList(1, 3, 1, 2 )));

        assertArrayEquals(new Integer[]{4, 4, 8, 7}, reduce(new ArrayList<Integer>(), (result, item)-> {
            result.add(item.length());
            return result;
        }, Arrays.asList("cats", "Dogs", "sparrows", "parrots")).toArray());

        assertArrayEquals(new Integer[] {0, 3, 6, 9, 10}, reduce(new ArrayList<Integer>(), (result, item) -> {
            if( item >= 0)
                result.add(item);
            return result;
        }, Arrays.asList(0, 3, -5, 6, -1, 9, 10, -9, -4)).toArray());

        assertEquals(" Hello everyone! my name is Mustafa Basit", reduce(new String(), (result,item)-> {
            return result + " " + item ; }, Arrays.asList("Hello", "everyone!", "my", "name", "is", "Mustafa", "Basit")).toString());
        /*
        // why doing this way below assertion is failing -
        assertEquals(new Integer[] {3, 4, 5, 6, 7, 8, 9, 10}, reduce(new ArrayList<Integer>(), (result, item)-> {
            for (Integer i = item; i <= 10; i++)
                result.add(i);
            return result;
        }, Arrays.asList(3)).toArray());
        */

        assertEquals(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10), reduce(new ArrayList<Integer>(), (result, item)-> {
            for (Integer i = item; i <= 10; i++)
                result.add(i);
            return result;
        }, Arrays.asList(3)));


    }

    @Test
    void testMap() {
        assertArrayEquals(new Integer[] {11, 22, 33, 44, 55}, map(Arrays.asList(1, 2, 3, 4, 5), item -> item * 11).toArray());
        assertArrayEquals(new Integer[] {4, 7, 4}, map(Arrays.asList("cats", "parrots", "rats"), String::length).toArray());
        assertArrayEquals(new String[] {"CATS", "PARROTS", "RATS"}, map(Arrays.asList("cats", "parrots", "rats"), String::toUpperCase).toArray());
    }

    @Test
    void testFilter() {
        assertArrayEquals(new String[] {"Afshaan", "Nuzhat", "Shayesta"}, filter(Arrays.asList("Iqra", "Zakir", "Afshaan", "Nuzhat", "Basit", "Nasir","Shayesta"),
                s-> s.length() > 5).toArray());
    }

    @Test
    void TestMapUsingReduce(){
        assertArrayEquals(new Integer[] {2, 4, 6, 9}, mapUsingReduce(Arrays.asList(1, 3, 5, 8), x-> x+1).toArray() );
    }

    @Test
    void testFilterUsingReduce(){
        assertArrayEquals(new Integer[] {2, 4, 6, 8, 10},filterUsingReduce(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), item-> item % 2 == 0).toArray());
    }


    @Test
    void testTakeWhile() {
        assertArrayEquals(new Integer[] {1, 2, 3}, takeWhile(Arrays.asList(1, 2, 3, -4, -1, 3, -2, 5, 0), item -> item > 0).toArray());
    }

    @Test
    void testFlatMap() {
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6}, flatMap(Arrays.asList(new Integer[] {1, 2}, new Integer[] {3, 4, 5}, new Integer[] {6}), Arrays::asList).toArray());

        assertArrayEquals(new Integer[] {2, 4, 6, 3, 6, 9, 4, 8, 12}, flatMap(Arrays.asList(2, 3, 4), new Mapper<Collection<Integer>, Integer>() {
            @Override
            public Collection<Integer> map( Integer item) {
                /*
                 this time item is not a list, is just a single element,
                 as we know the output for this is collection
                 we have to generate the multiple of given number upto (item * 3)
                 if item = 3, output should be 3, 6, 9
                 we can generate this list via sequence generator with constant step
                */

                return SequenceGenerator.range(item, (item * 3) + 1, item);
            }
        }).toArray());

    }
}