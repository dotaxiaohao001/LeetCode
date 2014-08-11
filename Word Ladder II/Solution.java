import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//solution get from: http://codeganker.blogspot.com/2014/04/word-ladder-ii-leetcode.html
public class Solution {
	class StringWithLevel {
		String str;
		int level;
		public  StringWithLevel (String s, int lvl) {
			str = s;
			level = lvl;
		}
	}
	// in order to record parent str, we search from end to start. 
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        HashSet<String> unvisitedSet = new HashSet<String>();
        //initial with all dict word + start
        unvisitedSet.addAll(dict);
        unvisitedSet.add(start);
        unvisitedSet.remove(end); // we start with end now at end case

        HashMap<String, ArrayList<String>> nextMap = new HashMap<String, ArrayList<String>>(); // used to record cur + 1 level to cur
        for(String s : unvisitedSet) {
        	nextMap.put(s, new ArrayList<String>());
        }

        Queue<StringWithLevel> queue = new LinkedList<StringWithLevel>();
        queue.add(new StringWithLevel(end, 0));
        boolean found = false;
        int finalLevel = Integer.MAX_VALUE;
        int curLevel = 0;
        int preLevel = 0;
        HashSet<String> visitedCurLevel = new HashSet<String>();
        //BFS
        while(!queue.isEmpty()) {
        	StringWithLevel cur = queue.poll();
        	String curStr = cur.str;
        	curLevel = cur.level;
        	
        	if(found && curLevel > finalLevel) 
        		break;
        	//remove all last level words, otherwise will cause duplicative visit  many to many(so should delete based on level)
        	if(curLevel > preLevel) {
        		unvisitedSet.removeAll(visitedCurLevel);
        		preLevel = curLevel;
        	}

        	char[] curStrCharArray = curStr.toCharArray();
        	for(int i = 0; i < curStrCharArray.length; ++i) {
        		char originalChar = curStrCharArray[i];
        		boolean foundCurLvl = false;
        		for(char c = 'a'; c <= 'z'; ++c) {
        			curStrCharArray[i] = c;
        			String newStr = new String(curStrCharArray);
        			// should not from word to itself waste!
        			if(c != originalChar && unvisitedSet.contains(newStr)) {
        				nextMap.get(newStr).add(curStr); //newStr could move to curStr(level - 1)
        				if(newStr.equals(start)) {
        					found = true;
        					foundCurLvl = true;
        					finalLevel = curLevel;
        					break; // there would only one possible to curStr
        				}
        				if(visitedCurLevel.add(newStr)) { // if newStr is not present add and return true
        					queue.add(new StringWithLevel(newStr, curLevel + 1));
        				}
        			}
        		}
        		if(foundCurLvl)
        			break; // only break for curStr, might be have other case convert to start, so should visit all cur lvl

        		curStrCharArray[i] = originalChar;
        	}
        }
        //get the path 
        if(found) {
        	ArrayList<String> list = new ArrayList<String>();
        	list.add(start);
        	getPath(start, end, list, finalLevel + 1, nextMap, result);
        }
        return result;
    }
// getPath is return find the path from cur to end;
    private void getPath(String cur, String end, ArrayList<String> list, int level, HashMap<String, ArrayList<String>> nextMap, ArrayList<ArrayList<String>> result) {
    	if(cur.equals(end)) // also means level == 0
    		result.add(new ArrayList<String>(list));
    	else if(level > 0) {
    		ArrayList<String> nextStrs = nextMap.get(cur);
    		for(String s : nextStrs) {
    			list.add(s);
    			getPath(s, end, list, level-1, nextMap, result);
    			list.remove(list.size()-1);
    		} 
    	}
    }
}