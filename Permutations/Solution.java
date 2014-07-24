public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i = 0; i < num.length; ++i) {
        	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        	
        	for(ArrayList<Integer> a : result) {
        		for(int j = 0; j <= a.size(); ++j) {
        			ArrayList<Integer> p = new ArrayList<Integer>(a);
        			p.add(j,num[i]);
        			temp.add(p);
        		}
        	}
        	result = temp;
        }
        return result;
    }
}