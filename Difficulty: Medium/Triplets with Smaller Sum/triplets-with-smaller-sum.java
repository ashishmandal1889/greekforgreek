import java.util.*;

class Solution {
    public int countTriplets(int sum, int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int ans = arr[i] + arr[left] + arr[right];

                if (ans < sum) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}