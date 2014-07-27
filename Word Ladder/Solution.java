import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> distance = new LinkedList<Integer>();
        wordQueue.add(start);
        distance.add(1);

        while(!wordQueue.isEmpty()) {
            String word = wordQueue.remove();
            int len = distance.remove();
            //reach the end status
            if(word.equals(end)){
                return len;
            }
            // intermediated status
            //check every possible next status 
            for(int i = 0; i < word.length(); ++i){
                for(char c = 'a'; c <= 'z'; ++c){
                    char[] letters = word.toCharArray();
                    //if two status is same it cannot be the short path
                    if(letters[i] != c){
                        letters[i] = c;
                        String newWord = new String(letters);
                        if(dict.contains(newWord)){
                            wordQueue.add(newWord);
                            distance.add(len+1);
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}