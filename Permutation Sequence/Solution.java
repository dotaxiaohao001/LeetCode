public class Solution {
	public String getPermutation(int n, int k) {
	    int[] num = new int[n];
	    for(int i = 0; i < n; ++i){
	    	num[i] = i + 1;
	    }
	    for(int i = 1; i < k; ++i){
	    	NextPermutation(num);
	    }
	    String result = new String();
	    for(int i = 0; i < n; ++i){
	    	result += num[i];
	    }
	    return result;
	}

	public void NextPermutation(int[] num){
		int len = num.length;
		int i;
		for(i = len - 2; i >= 0; --i){
			if(num[i] < num[i+1])
				break;
		}
		if(i == -1)
			reverse(num, 0);
		if(i >= 0){
			for(int j = len - 1; j > i; --j){
				if(num[i] < num[j]){
					//swap num[i] and num[j]
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					break;
				}
			}
			reverse(num, i + 1);
		}
	}

	public void reverse(int[] num, int start){
		int j = start;
		int k = num.length - 1;
		while(j < k){
			int temp = num[j];
			num[j] = num[k];
			num[k] = temp;
			j++;
			k--;
		}
	}
}