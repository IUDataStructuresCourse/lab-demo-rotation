import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RotationTest {
    // Test oracle
    private static void rotate_save_n_shift(int[] A) {
        if (A.length > 1) {
            int last = A[A.length - 1];
            for (int i=A.length - 1; i != 0; --i) {
                A[i] = A[i-1];
            }
            A[0] = last;
        }
    }

    @Test
    public void test_rotation_simple() {
        String test_description = "rotating a small array";
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {1, 2, 3, 4, 5};
        rotate_save_n_shift(A);
        Rotation.rotate_ripple(B);
        try {
            assertArrayEquals(A, B);
        } catch (Exception e) {
            fail(test_description + e.toString());
        }
    }

    @Test
    public void test_rotation_random() {
        String test_description = "rotating an array with random integers";
        Random r = new Random();
        int[] A = new int[100];
        for (int i = 0; i != A.length; ++ i) {
            A[i] = r.nextInt();
        }
        int[] B = Arrays.copyOf(A, A.length);
        rotate_save_n_shift(A);
        Rotation.rotate_ripple(B);
        try {
            assertArrayEquals(A, B);
        } catch (Exception e) {
            fail(test_description + e.toString());
        }
    }
}
