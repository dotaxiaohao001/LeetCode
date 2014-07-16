public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>()); // add empty subset
        Arrays.sort(num);
        int start = 0;
        for(int i = 0; i < num.length; ++i) {
        	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        	int size = result.size();
        	for(int j = start; j < size; ++j) { // when face duplicates only add from the last new element
        		temp.add( new ArrayList<Integer>( result.get(j) ) );
        	}
        	for(ArrayList<Integer> a : temp) {
        		a.add(num[i]);
        	}
        	if(i < num.length - 1 && num[i] == num[i+1]) { // check the next would be same or not 
        		start = size;
        	}else {
        		start = 0;
        	}

        	result.addAll(temp);
        }
        return result;
    }
}