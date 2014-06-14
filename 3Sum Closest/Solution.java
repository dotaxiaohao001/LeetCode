public class Solution {
	public int threeSumClosest(int[] num, int target) {
	    int len = num.length;
	    Arrays.sort(num);
	    int result = Integer.MAX_VALUE;
	    int closet = Integer.MAX_VALUE;

	    for(int i = 0; i < len - 2; ++i){
	    	int first = num[i];
	    	int j = i + 1;
	    	int k = len - 1;
	    	while(j < k){
	    		int sum = first + num[j] + num[k];
	    		int dif = Math.abs(sum - target);
	    		if(dif < closet){
	    			result = sum;
	    			closet = dif;
	    		}

	    		if(sum < target)
	    			j++;
	    		else
	    			k--;
	    	}
	    }
	    return result;
	}
}