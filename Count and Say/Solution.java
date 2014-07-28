public class Solution {
    public String countAndSay(int n) {
        StringBuffer str = new StringBuffer();
        str.append(1);// n == 1
        for(int i = 2; i <= n; ++i){
        	StringBuffer temp = new StringBuffer();
        	int len = str.length();
        	char last = str.charAt(0);
        	int count = 1;

        	for(int j = 1; j < len; ++j){
        		if(last == str.charAt(j))
        			count++;
        		else{
        			temp.append(count);
        			temp.append(last);
        			count = 1;
        			last = str.charAt(j);
        		}
        	}
        	temp.append(count);
        	temp.append(last);
        	str = temp;
        }
        return str.toString();

    }
}