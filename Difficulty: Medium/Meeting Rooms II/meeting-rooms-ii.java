class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int ans = 0;
        int room = 0;
        while(i<start.length){
            if(start[i]<end[j]){
                room++;
                i++;
            }else{
                room--;
                j++;
            }
            ans = Math.max(ans,room);
        }
        return ans;
    }
}
