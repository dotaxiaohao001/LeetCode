public class Solution {
	public void nextPermutation(int[] num) {
	    //find the rightest num[i] < num[i+1]
	    int len = num.length;
	    int i;
	    for(i = len - 2; i >= 0; --i){
	    	if(num[i] < num[i+1])
	    		break;
	    }
	    if(i == -1){
	    //reverse the whole array
	    	reverse(num, 0);
	    }
	    if(i >= 0){
	    	int j;
	    	for(j = len - 1; j > i; --j){
	    		if(num[i] < num[j]){
	    			//swap
	    			int temp = num[i];
	    			num[i] = num[j];
	    			num[j] = temp;
	    			break;
	    		}
	    	}
	    	reverse(num, i+1);
	    }
	}

	public void reverse(int[] num, int start){
		int len = num.length;
		int j = start;
		int k = len - 1;
		while(j < k){
			int temp = num[j];
			num[j] = num[k];
			num[k] = temp;
			j++;
			k--;
		}
}
}