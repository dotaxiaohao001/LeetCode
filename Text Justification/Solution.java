import java.util.ArrayList;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        // process every L length row
        int start = 0;
        int hasLen = 0;
        for(int i = 0; i < words.length; ++i) {
        	//current line len with required space + current i
        	if(hasLen + words[i].length() + i - start > L) {
        		// this row should be from start to i - 1;
        		int remain = L - hasLen;
        		//i may equal to start
        		int spaceNum = 0; // everyone should have at least number 
        		int extraNum = 0; // those left side with more one
        		if(i-1 > start) {
        			spaceNum = remain / (i-1-start);
        			extraNum = remain % (i-1-start);
        		}

        		StringBuffer line = new StringBuffer();

        		for(int j = start; j < i-1; ++j) {
        			line.append(words[j]);
        			//add required space
        			for(int k = 0; k < spaceNum; ++k) {
        				line.append(" ");
        			}
        			//add extra one more space for extraNum position
        			if(extraNum > 0){
        				line.append(" ");
        			}
        			extraNum--;
        		}
        		//the last word has no space after
        		line.append(words[i-1]);
        		//maybe has only one word in a line, so only one slot at right
        		for(int j =  line.length(); j < L; ++j)
        			line.append(" ");
        		result.add(line.toString());
        		//reset for next line
        		hasLen = 0;
        		start = i;
        	}
        	//words[i] could in this line, so add it to hasLen
        	hasLen += words[i].length();
        }

        //for the next line
        StringBuffer lastLine = new StringBuffer();
        for(int i = start; i < words.length; ++i) {
        	lastLine.append(words[i]);
        	if(lastLine.length() < L) // maybe the last word reach to the end
        		lastLine.append(" ");
        }

        for(int i = lastLine.length(); i < L; ++i) {
        	lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }
	  public static void main(String args[]) {
		  Solution s = new Solution();
		  String[] T = {"This", "is", "an", "example", "of", "text", "justif", "ication."};
		  System.out.println(s.fullJustify(T,16));
		  String[] T1 = {"Listen","to","many,","speak","to","a","few."};
		  System.out.println(s.fullJustify(T1,6));
		  
		 
	  }
	}
