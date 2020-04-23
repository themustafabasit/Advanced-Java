package edu.iust.advancejava.java8newfeatures.interfacechanges;
import edu.iust.advancejava.java8newfeatures.interfacechanges.ExtensionMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionMethodTest {

    @Test
    void testApplyBreaks() {
        assertEquals(
                "Brakes Applied",
                new ExtensionMethod().applyBreaks()
        );
    }

    @Test
    void testChangeGear() {
        assertEquals(
                "Gear Changed",
                new ExtensionMethod().changeGear()
        );
    }

    @Test
    void testSpeedUp() {
        assertEquals(
                new String("Speed Increased"),
                new ExtensionMethod().speedUp()
        );
    }
}