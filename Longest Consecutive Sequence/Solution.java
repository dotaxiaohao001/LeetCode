public class Solution {
    public int longestConsecutive(int[] num) {
        HashSet s = new HashSet();
        for(int i = 0; i < num.length; ++i){
        	s.add(num[i]);
        }
        int longest = 0;
        for(int i = 0; i < num.length; ++i){
        	int count = 0; 
        	int c = num[i];
        	int l = c - 1;
        	int r = c + 1;
        	if(s.contains(c)){
        		count++;
        		s.remove(c);
        	}
        	else
        		continue;
        	while(s.contains(l)){
        		count++;
        		s.remove(l);
        		l--;
        	}
        	while(s.contains(r)){
        		count++;
        		s.remove(r);
        		r++;
        	}
        	if(count > longest)
        		longest = count;
        }
        return longest;
    }
}