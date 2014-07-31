public class Solution {
    public int sqrt(int x) {
    //case 0
    	if(x == 0)
    		return 0;
    // case 1 mid could be 0, cannot divide 0
    	if(x == 1)
    		return 1;
    	int left = 0;
    	int right = x;
    	while(left <= right){
    		int mid = left + (right - left)/2;
    		if(x/mid == mid)
    			return mid;
    		else if(x/mid > mid) // at right
    			left = mid + 1;
    		else // at left
    			right = mid - 1;
    	}
    	return (left+right)/2;        
    }
}