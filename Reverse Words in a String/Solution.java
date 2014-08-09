public class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        String[] array = str.split(" ");
        //maybe include " ";

        StringBuffer result = new StringBuffer();

        for(int i = array.length - 1; i > 0; --i) {
        	if(array[i].equals(""))
        		continue;
        	else{
        		result.append(array[i]);
        		result.append(" ");
        	}
        }

        if(!array[0].equals(" "))
        	result.append(array[0]);

        return result.toString();
    }
}