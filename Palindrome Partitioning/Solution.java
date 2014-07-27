import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        int len = s.length();
        char[] letters = s.toCharArray();
        boolean[][] pali = new boolean[len][len];
        for(int i = len-1; i >= 0; --i){ // why backward, cause (i,j) depend(i+1,j-1)
        	for(int j = i; j < len; ++j){ // back or forward both ok
        		pali[i][j] = letters[i] == letters[j] && (j-i < 2 || pali[i+1][j-1]);// if[i+1][j-1] if p[i] == p[j] ==> pali[i][j]
        	}
        }
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> ans = new ArrayList<String>();
        addPartition(result, ans, s, 0, pali);
        return result;
    }

    private void addPartition(ArrayList<ArrayList<String>> result, ArrayList<String> ans, String s, int start, boolean[][] pali){
    	if(start == s.length()){
    		ArrayList<String> newAns = new ArrayList<String>(ans);
    		result.add(newAns);
    		return;
    	}

    	for(int i = start+1; i <= s.length(); ++i){
    		String subPali = s.substring(start, i); // start, i-1
    		if(pali[start][i-1]){
    			ans.add(subPali);
    			addPartition(result, ans, s, i, pali);
    			ans.remove(ans.size()-1);
    		}
    	}
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.partition("aba"));
    }
}