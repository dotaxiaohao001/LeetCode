public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		        int len = num.length;
		        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		        Arrays.sort(num);

		        for(int i = 0; i < len - 3; ++i){
		        	int first = num[i];
		        	for(int j = i + 1; j < len - 2; ++j){
		        		int second = num[j];
		        		int k = j + 1;
		        		int t = len - 1;
		        		while(k < t){
		       				int left = first + second;
		       				int right = target - left;
		       				int sum = num[k] + num[t];
		        			if(sum == right){
		        				ArrayList<Integer> quadruplet = new ArrayList<Integer>();
		        				quadruplet.add(first);
		        				quadruplet.add(second);
		        				quadruplet.add(num[k]);
		        				quadruplet.add(num[t]);
		        				if(!result.contains(quadruplet)){
		        					result.add(quadruplet);
		        				}
		        				k++;
		        				t--;
		        			}else if(sum < right){
		        				k++;
		        			}else{
		        				t--;
		        			}
		        		}
		        	}
		        }
		        return result;
		    }
}