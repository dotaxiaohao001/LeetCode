public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        int len = strs.length;
        for(int i = 0; i < len; ++i){
        	String original = strs[i];
        	char[] sorted = original.toCharArray();
        	Arrays.sort(sorted); // don't have return value
        	String sortedStr = new String(sorted);

        	ArrayList<String> list = map.get(sortedStr);
        	if(list == null){
        		list = new ArrayList<String>();
        		list.add(original);
        		map.put(sortedStr, list);
        	}else{
        		list.add(original);
        	}
        }

        ArrayList<String> result = new ArrayList<String>();
        Set<String> keys = map.keySet();
        for(String str : keys){
        	ArrayList<String> val = map.get(str); // special type not primitive type
        	if(val.size() > 1){ // ArrayList is not length
        		result.addAll(val); // pay attention to the upper and lower case
        	}
        }

        return result;
    }
}