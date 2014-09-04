/**
*思路： 就扫描一遍， 但是每次先记录一个起点start， 然后当遇到duplicate 时候就计算起点 start 到 当前的距离。 然后更新 start
* 1.更新start 是将 start 设置为第一次遇到 c 的下一个 （比如 abcbd， start在遇到第二个b时候会设置为2即c所在的位置，否则在之前无论如何都存在duplicates）
* 2.if里的判断如果c存在但是小于start 我们也当他不在字典里，道理如上
* 3. 容易出错是最后扫描完成 需要一个wild card， 因为从last start 到 j
*/
import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        //1 or 0 both ok
        if(len < 2)
            return len;
        int maxLen = 0;
        //start is next position of last duplicates otherwise always have duplicates
        int start = 0;
        // use the char as key and the position as the value 
        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
        for(int i = 0; i < len; ++i) {
            char c = s.charAt(i);

            if(!alphabet.containsKey(c) || alphabet.get(c) < start ) {
                alphabet.put(c, i);
            }
            else {
                int lastPos = alphabet.get(c);
                int curLen = i - start;
                if(curLen > maxLen)
                    maxLen = curLen;
                start = lastPos + 1;
                alphabet.put(c, i);
            }
        }
        //should possess the end assume it was a wild card
        if(len - start > maxLen)
            maxLen = len - start;
        return maxLen;
    }
    
    public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
    }
}