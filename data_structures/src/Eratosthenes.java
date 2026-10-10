import java.util.Scanner;
import java.util.Arrays;
/**
 * for int n >= 2, give each prime number x < n.
 *
 */

public class Eratosthenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean[] arr;

        while (true) {
            System.out.println("Give an integer n>=2: ");

            try {
                n = Integer.parseInt(sc.nextLine());

                if (n >= 2) {
                    break; // valid input
                }

                System.out.println("The number must be at least 2.");
            } catch (NumberFormatException e) {  // for sc.nextInt() we would use InputMismatchException
                System.out.println("Please enter a valid int.");
            }
        }

        // initialize array
        arr = new boolean[n];
        Arrays.fill(arr, 2, n, true);

        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                for (int j = i; (long) i * j < n; j++) { // to avoid overflow
                    arr[j * i] = false;
                }
            }
        }

        // results
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}