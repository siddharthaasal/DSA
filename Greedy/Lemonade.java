package Greedy;
import java.util.*;
class Lemonade {
    public boolean lemonadeChange(int[] arr) {
        int[] denominations = new int[3]; // 5, 10, 20
        Arrays.fill(denominations, 0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                denominations[0]++;
            } else if (arr[i] == 10) {
                if (denominations[0] == 0) {
                    return false;
                }
                denominations[0]--;
                denominations[1]++;
            } else {
                // 20
                if (denominations[1] >= 1 && denominations[0] >= 1) {
                    denominations[1]--;
                    denominations[0]--;
                    // denominations[2]++;
                } else if (denominations[0] >= 3) {
                    denominations[0] -= 3;
                    // denominations[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}