import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(S);
        
        for(int i = 0; i < S.length; ++i) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            for(ArrayList<Integer> a : result) { // deep copy ! clone and constructor(list) is a shallow copy
                temp.add(new ArrayList(a));
            }
            for(ArrayList<Integer> a : temp) {
                a.add(S[i]);
            }
            result.addAll(temp);
        }
        return result;

    }
    
    public static void main(String[] args){
        Solution s = new Solution();
        
        int[] A= {3,2,1};
        
        
        //s.searchInsert(A, 4);
        System.out.println(s.subsets(A));
    }
}