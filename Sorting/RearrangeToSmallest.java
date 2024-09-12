//https://leetcode.com/problems/smallest-value-of-the-rearranged-number/description/
package Sorting;

import java.util.*;

class RearrangeToSmallest {
    public static long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }

        int digits = numberOfDigits(num);
        int arr[] = new int[digits];
        System.out.println("length:" + arr.length);
        int idx = 0;
        long n = num;
        if (n < 0) {
            n = n * -1;
        }
        while (n > 0) {
            int dig = (int) n % 10;
            arr[idx] = dig;
            idx++;
            n = n / 10;
        }
        Arrays.sort(arr);
        long ans = 0;
        if (num < 0) {
            for (int i = arr.length - 1; i >= 0; i--) {
                ans = ans * 10 + arr[i];
            }
            ans = ans * -1;
            return ans;
        } else {
            int numberOfZeros = 0;
            boolean firstNonZeroDigit = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    numberOfZeros++;
                } else {
                    // If the number was positive, build the smallest possible number
                    // Step 1: Find the first non-zero digit
                    int firstNonZeroIndex = 0;
                    while (arr[firstNonZeroIndex] == 0) {
                        firstNonZeroIndex++;
                    }

                    // Step 2: Place the first non-zero digit
                    ans = arr[firstNonZeroIndex];

                    // Step 3: Append all the zeros
                    for (int j = 0; j < firstNonZeroIndex; j++) {
                        ans = ans * 10;
                    }

                    // Step 4: Append the remaining digits
                    for (int j = firstNonZeroIndex + 1; j < arr.length; j++) {
                        ans = ans * 10 + arr[i];
                    }
                }
            }
            return ans;

        }
    }

    private static int numberOfDigits(long n) {
        if (n < 0) {
            n = n * -1;
        }
        int dig = 0;
        while (n > 0) {
            ++dig;
            n = n / 10;
        }
        return dig;
    }

    public static void main(String[] args) {
        System.out.println("answer: " + smallestNumber(52000347));
    }

}
