public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        combinations(n, k, 1, result, ans);
        return result;
    }

    private void combinations(int n, int k, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ans) {
    	if(k == 0){
    		result.add(new ArrayList<Integer>(ans));
    		return;
    	}

    	for(int i = start; i <= n; ++i) {
    		ans.add(i);
    		combinations(n, k-1, i+1, result, ans);
    		ans.remove(ans.size() - 1);
    	}
    }
}

// 1. Java ArrayList copy constructor is proved to be a shallow copy constructor by the cases of point and rect.
// However,
// 2. Even though it is a shallow copy constructor, using Set and Add method on one arraylist 
// does not change the other arraylist in shallow copy.
// 3. Java ArrayList copy constructor is quite safe on integer and string arraylist 
// because int and string are immutable in java. Their elements can only be changed by set and add methods as i know.


/*import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int val = 1;
    public static void main(String[] args){
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        Solution s3 = new Solution();
        
        ArrayList<Solution> r1 = new ArrayList<Solution>();
        r1.add(s1);
        r1.add(s2);  //[Solution@4c76ec2d, Solution@76d88aa2]
        ArrayList<Solution> r2 = new ArrayList<Solution>(r1);
        r2.add(s3);  //[Solution@4c76ec2d, Solution@76d88aa2, Solution@6c10a234]
        r2.get(0).val = 2; // r1 also changed
        

        
        //s.searchInsert(A, 4);
        //System.out.println(s.subsets(A));
    }
}*/