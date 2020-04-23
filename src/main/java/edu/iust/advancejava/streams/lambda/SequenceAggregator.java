package edu.iust.advancejava.streams.lambda;

import java.util.*;

public class SequenceAggregator {
    public static int sum(Collection<Integer> list) {
        int result = 0;
        for (int item : list)
            result += item;
        return result;
    }

    public static int product(Collection<Integer> list) {
        int result = 1;
        for (int item : list)
            result *= item;
        return result;
    }


    public static <T> T simpleReduce(T initValue, SimpleAggregator<T> aggregator, Collection<T> list) {
        T result = initValue;
        for (T item : list)
            result = aggregator.op(result, item);

        return result;
    }

    public static <U, T> U reduce(U initValue, Aggregator<U, T> aggregator, Collection<T> list) {

        U result = initValue;

        for (T item : list)
            result = aggregator.op(result, item);

        return result;
    }

    public static <U, T> Collection<U> map(Collection<T> list, Mapper<U, T> mapper) {
        Collection<U> output = new ArrayList<>();

        for (T item : list)
            output.add(mapper.map(item));
        return output;
    }

    public static <T> Collection<T> filter(Collection<T> list, Predicate<T> predicate) {
        Collection<T> output = new ArrayList<>();

        for (T item : list)
            if (predicate.test(item))
                output.add(item);
        return output;
    }

    public static <U, T> Collection<U> mapUsingReduce(Collection<T> list, Mapper<U, T> mapper) {
        return reduce(new ArrayList<U>(), (result, item) -> {
            result.add(mapper.map(item));
            return result;
        }, list);
    }

    public static <T> Collection<T> filterUsingReduce(Collection<T> list, Predicate<T> filter) {
        return reduce(new ArrayList<T>(), (result, item) -> {
            if (filter.test(item))
                result.add(item);
            return result;
        }, list);
    }

    public static <T> Collection<T> takeWhile(Collection<T> list, Predicate<T> check) {
        Collection<T> output = new ArrayList<>();
        for (T item : list)
            if (check.test(item))
                output.add(item);
            else
                break;

        return output;
    }

    // flatMap is almost same as map function, the difference is this time it has to deal with collection of collections
    // each element in the list is itself a list/array
    // we have to just map a function that will add all the elements of a list into "output list" n-times
    // we have to just slightly change the implementation of map()
    public static <U, T> Collection<U> flatMap(Collection<T> list, Mapper<Collection<U>, T> flatMapper) {
        Collection<U> output = new ArrayList<>();
        for (T items : list)
            output.addAll(flatMapper.map(items));
        return output;
    }

}