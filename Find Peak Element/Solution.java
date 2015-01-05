//O(n) solution straight forward way
public class Solution {
    public int findPeakElement(int[] num) {
    	int maxIndex = 0;
    	int maxVal = num[0];

    	for(int i = 1; i< num.length; ++i) {
    		if(num[i] > maxVal) {
    			maxVal = num[i];
    			maxIndex = i;
    		}
    	}

    	return maxIndex;
        
    }
}