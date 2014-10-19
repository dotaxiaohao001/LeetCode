/**
*思路： 直接用dfs 超时， 所以用了数学方法，从左到右确定每个位置的数， 因为对与 permutation a1, a2, .. an.
* n-1个数的permutation是 (n-1)!. 所以k-1 / (n-1)! 可以得到第把数几move to head 了。 假如k <= (n-1),我们知道，第一个就是1，
*因为2到9 所组成的所有组合都不能超过98765432. 之后依次类推。 巧妙～
*上一次是利用next permutation，
*错误： k-1， 除之后与index对应，否则k =（n-1）！应该是以198765432
*/

import java.util.ArrayList;

public class Solution {
	public String getPermutation(int n, int k) {
		ArrayList<Integer> number = new ArrayList<Integer>();
		int permutationCount = 1;
		for(int i = 1; i <= n; ++i) {
			number.add(i);
			permutationCount = permutationCount * i;
		}

		//if we want the (n-1)!th permutation, so the permutation[0] should be smallest, and [1, n-1]is largest (n-1) 
		//length permutaion. number are 2 to n

		k--; //use to accord to index
		String result = "";
		for(int i = 0; i < n; ++i) {
			permutationCount = permutationCount / (n-i); // it is the total number of permutation for n-1 numbers
			int leftMostIndex = k / permutationCount;

			result = result + number.get(leftMostIndex);
			//remove this number
			number.remove(leftMostIndex);

			//process the remain n-1 number
			k = k % permutationCount;
		}
		return result;
	}
	
	
	int count;
	public String getPermutation2(int n, int k) {
		boolean[] digit = new boolean[10];
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder solution = new StringBuilder();
		count = 0;
		helper(result , solution, n, 0, digit,  k);
		return result.get(k-1);
	}

	private void helper(ArrayList<String> result, StringBuilder solution, int n, int level, boolean[] digit, int k) {
		if(level == n) {
			result.add(solution.toString());
			count++;
			return;
		}

		for(int i = 1; i <= n; ++i) {
		    if(count == k) {
		        break;//already get the require result, no need move forward.
		    }
			if(!digit[i]) {
				digit[i] = true;
				solution.append(i);
				helper(result, solution, n, level+1, digit, k);
				solution.deleteCharAt(solution.length()-1);
				digit[i] = false;
			}
		}
	}
	

	public static void main(String[] args) {
		  Solution s = new Solution();
		  System.out.println(s.getPermutation(9, 331987));
	}

}