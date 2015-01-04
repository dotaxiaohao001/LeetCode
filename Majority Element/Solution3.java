public class Solution {
    public int majorityElement(int[] num) {
    	return majorityElementHelper(num, 0, num.length-1);
    }

    private int majorityElementHelper(int[] num, int start, int end) {
    	if(start == end) {
    		return num[start];
    	}

    	int mid = (end + start)/2;

    	int leftCandidate = majorityElementHelper(num, start, mid);
    	int rightCandidate = majorityElementHelper(num, mid+1, end);

    	if(leftCandidate == rightCandidate) {
    		return leftCandidate;
    	} else {
    		int count =0;
    		for(int i = start; i <= end; ++i) {
    			if(num[i] == leftCandidate) {
    				count++;
    			}
    		}

    		if(count > (end - start + 1) / 2) {
    			return leftCandidate;
    		} else {
    			return rightCandidate;
    		}
    	}
    }
}