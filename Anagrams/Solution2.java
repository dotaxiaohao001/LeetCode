/**
*思路： 因为anagram的定义是字母数一样就是顺序不一样，所以当我 把string里的字母排序之后如果是anagram必然排序之后得结构一样，
*怎么找到一样？ 就用到了hashmap，（如果map里面有 就将当前为排序前得string 添加进去， 否则创一个)；
*最后遍历一遍map，找到里面group大小大于1 的就是所要的string.
*这里用到了两个不太用的函数 一个addAll 和 keySet
*addAll: Appends all of the elements in the specified collection to the end of this list,
*keySet: Returns a Set view of the keys contained in this map.
*
*错误： char[] 自带的toString是type@address 应该用Arrays.toString(char[])。这和打印时候用的函数一个道理。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> anagrams(String[] strs) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(strs == null || strs.length == 0) {
    		return result;
    	}

    	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	for(int i = 0; i < strs.length; ++i) {
    		char[] chars = strs[i].toCharArray();
    		Arrays.sort(chars);

    		ArrayList<String> group = map.get(Arrays.toString(chars));
    		if(group == null) {
    			ArrayList<String> newGroup = new ArrayList<String>();//newGroup is not necessary just use group
    			newGroup.add(strs[i]);
    			map.put(Arrays.toString(chars),newGroup);
    		} else {			
    			group.add(strs[i]);
    		}
    	}
    	
    	Set<String> keys = map.keySet();
    	for(String key : keys) {
    		ArrayList<String> group = map.get(key);
    		if(group.size() > 1) {
    			result.addAll(group);
    		}
    	}

    	return result;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] num = {-2,-3,-1};
		String[] strs = {"abc", "cba", "ddd"};
		System.out.println(s.anagrams(strs));
		
    	HashMap<String,Integer> map = new HashMap<String, Integer>();
    	String s1 = new String("kkk");
    	String s2 = new String("kkk");
    	map.put(s1, 123);
    	System.out.println(map.get(s2));
    	
    	HashMap<char[],Integer> map1 = new HashMap<char[], Integer>();
    	char[] c1 = {'a'};
    	char[] c2 = {'a'};
    	map1.put(c1, 456);
    	System.out.println(map1.get(c2));
    	
    	HashMap<String,Integer> map2 = new HashMap<String, Integer>();
    	char[] c3 = {'a'};
    	char[] c4 = {'a'};
    	map2.put(c3.toString(), 456);
    	System.out.println(c3.toString() == c4.toString());
    	String s3 = c3.toString();
    	String s4 = c4.toString();
    	//Java's toString() for an array is to print [, followed by a character representing the type of the array's elements (in your case C for char), 
    	//followed by @ then the "identity hash code" of the array (think of it like you would a "memory address").
    	System.out.println(s3+ "and" + s4 );
    	System.out.println(c3.toString().equals(c4.toString()));
    	System.out.println(map2.get(c4.toString()));
    	
    	String s5 = Arrays.toString(c3);
    	String s6 = Arrays.toString(c4);
    	map2.put(s5, 998);
    	System.out.println(map2.get(s6));
	}

}