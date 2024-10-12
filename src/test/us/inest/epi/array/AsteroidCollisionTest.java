package us.inest.epi.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class AsteroidCollisionTest {
    @Test
    public void testAsteroidCollision() {
        int[] input = new int[] { 10, 2, -5 };
        int[] result = AsteroidCollision.asteroidCollision(input);
        int[] expected = new int[] { 10 };
        assertArrayEquals(expected, result);
    }
}
