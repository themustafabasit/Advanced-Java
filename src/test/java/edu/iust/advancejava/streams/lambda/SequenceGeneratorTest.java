package edu.iust.advancejava.streams.lambda;
import static edu.iust.advancejava.streams.lambda.SequenceGenerator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceGeneratorTest {

    @Test
    void usingRange() {
        // constant step
        assertArrayEquals(
                range(1, 10, 2).toArray(),
                new Integer[] {1, 3, 5, 7, 9});
    }

    @Test
    void usingRangeWithStepLogic() {
        // constant step logic test
        assertArrayEquals(
                rangeWithStepLogic(1, 10, new StepLogic() {
                    @Override
                    public int increment(int i) {
                        return (i + 2);
                    }}).toArray(),
                new Integer[] {1, 3, 5, 7, 9}
        );

        // variable step logic test
        assertArrayEquals(
                rangeWithStepLogic(2, 10, new StepLogic() {
                    @Override
                    public int increment(int i) {
                        return (i * i);
                    }}).toArray(),
                new Integer[] {2, 4}
        );

        // same as above one, but done via lambda
        assertArrayEquals(
                rangeWithStepLogic(2, 10, (i) -> (i * i)).toArray(),
                new Integer[] {2, 4});
    }


    @Test
    void usingGenericSeriesWithLogic() {
        // constant step
        assertArrayEquals(
                genericSeriesWithLogic(1, (seed) -> seed > 5 ? null : seed + 1).toArray(),
                new Integer[]{1, 2, 3, 4, 5, 6}
        );

        //variable step
        assertArrayEquals(
                genericSeriesWithLogic(2, (seed) -> seed > 100 ? null : seed * seed).toArray(),
                new Integer[]{2, 4, 16, 256}
        );

        assertArrayEquals(
                genericSeriesWithLogic("A", new Generator<String>() {
                    @Override
                    public String nextValue(String seed) {
                        if (seed.equals("E"))
                            return null;
                        else
                         return  Character.toString((seed.charAt(0) + 1 ) );
                    }
                }).toArray(),
                new String[] {"A", "B", "C", "D", "E"}
        );
    }
}