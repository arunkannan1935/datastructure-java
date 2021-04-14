package datastructure;
/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;

public class CodeGladiatorProblem1 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] left = new int[testCase];
        int[] right = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }

        for (int j = 0; j < testCase; j++) {
//            System.out.println("-->"+left[j]+" "+ right[j]);
            int result = findPrimeDiff(left[j], right[j]);
            System.out.println(result);
        }
    }

    public static int findPrimeDiff(int left, int right) {
        int leftPrime = lowPrime(left, right);
        int rightPrime = highPrime(left, right);
//        System.out.println("-->"+leftPrime+" "+ rightPrime);
        if (leftPrime == 0 && rightPrime == 0) {
            return -1;
        }
        if (leftPrime == 0 || rightPrime == 0) {
            return 0;
        }
        return rightPrime - leftPrime;
    }

    public static int lowPrime(int l, int r) {
        for (int i = l; i <= r; i++) {
            if (isPrime(i)) return i;
        }
        return 0;
    }

    public static int highPrime(int l, int r) {
        for (int i = r; i >= l; i--) {
            if (isPrime(i)) return i;
        }
        return 0;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
