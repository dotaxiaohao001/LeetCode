import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	int strLen = S.length(); 
    	int listLen = L.length;
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	//empty dict? and dict has duplicates
    	if(strLen == 0 && listLen != 0)
    		return result;
    	int wordLen = L[0].length();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(int i = 0; i < listLen; ++i) {
        	if(dict.containsKey(L[i])) {
            	int val = dict.get(L[i]);
            	dict.put(L[i], val+1);//increase 1
        	}
        	else // set 1 if not contain
        		dict.put(L[i], 1);
        } 

        for(int i = 0; i + listLen*wordLen - 1 < strLen; ++i) {
        	HashMap<String, Integer> temp = new HashMap<String, Integer>();
        	int count = 0;
        	for(int j = i; j < i + listLen*wordLen; j = j+wordLen ) {
        		String str = S.substring(j, j+wordLen);
        		if(dict.containsKey(str)) {
        			if(!temp.containsKey(str))
        				temp.put(str, 1);
        			else{//
        				int val = temp.get(str);
        				if(val < dict.get(str))
        					temp.put(str, val+1);
        				else//more than the dict
        					break;
        			}
        			count++;
        		}
        		else
        			break;
        	}

        	if(count == listLen) {
        		result.add(i);
        	}
        }

        return result;
    }
	  public static void main(String args[]) {
		  Solution s = new Solution();
		  String[] T = {"fooo","barr","wing","ding","wing"};
		  System.out.println(s.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",T));
		 
	  }
	}
