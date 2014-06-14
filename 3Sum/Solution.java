public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = num.length;

		Arrays.sort(num);

		for(int i = 0; i < len - 2; ++i){// should be small than len-2, j at most is len -2, k is len - 1
			int first = num[i];
			if(first > 0) break;// reduce time the first number should be non-positive
			if(i > 0 && num[i] == num[i-1]) continue;// reduce duplicate.
			int j = i + 1;
			int k = len - 1;
			// 2 sum equal to -first
			while(j < k){
				if(first + num[j] + num[k] == 0)
				{
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(first);
					solution.add(num[j]);
					solution.add(num[k]);
					//if(!result.contains(solution))
						result.add(solution);
					j++;
					k--;
				}else if(first + num[j] + num[k] < 0){
					j++;
				}else{
					k--;
				}
			}
		}
		return result;
	}
}