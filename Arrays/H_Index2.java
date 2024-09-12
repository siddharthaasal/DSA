package Arrays;

import java.util.*;

class H_Index2 {
    public int hIndex(int[] citations) {
        int start = 0, end = citations.length-1;
        int ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            int h = citations.length - mid;
            if(citations[mid]>=h){
                //go left
                ans = Math.max(ans, h);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
