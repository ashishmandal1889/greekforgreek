class Solution {
    public int minSubarraySum(int[] arr) {
        // code here 
        int currentsum = arr[0];
        int minsum = arr[0];
        for(int i = 1;i<arr.length;i++){
            currentsum = Math.min(currentsum+arr[i],arr[i]);
            minsum = Math.min(minsum,currentsum);
        }
        return minsum;
    }
}