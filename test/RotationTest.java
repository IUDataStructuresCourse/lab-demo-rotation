import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RotationTest {

    //specification for ripple_rotate
    static boolean is_rotated(int[] A_orig, int[] A_new) {
        if (A_orig.length == 0) {
            return Arrays.equals(A_orig, A_new);
        } else {
            boolean result = A_new[0] == A_orig[A_orig.length - 1];
            for (int i = 0; i != A_orig.length - 1; ++i) {
                result = result && (A_orig[i] == A_new[i + 1]);
            }
            return result;
        }
    }

    @Test
    public void test_rotation_simple() {
        int[] A = {1, 2, 3, 4, 5};
        int[] A_orig = Arrays.copyOf(A, A.length);
        Rotation.rotate_ripple(A);
        assertTrue(is_rotated(A_orig, A));
    }

    @Test
    public void test_rotation_random() {
        for (int t = 0; t != 100; ++t) {
            Random r = new Random();
            int[] A = new int[r.nextInt(100)];
            for (int i = 0; i != A.length; ++ i) {
                A[i] = r.nextInt();
            }
            int[] A_orig = Arrays.copyOf(A, A.length);
            Rotation.rotate_ripple(A);

            assertTrue(is_rotated(A_orig, A));
        }
    }
}
