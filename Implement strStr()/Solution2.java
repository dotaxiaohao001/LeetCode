/**
*思路： brute force  the most important thing is len1 - i < len2 (no need to compare the left)
* pass the last case
*
*/

public int strStr(String haystack, String needle) {
   for (int i = 0; ; i++) {
      for (int j = 0; ; j++) { // j means the jth char from start point need to be compared.
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1; //here means no further comparation needed
        //cause not enough characters.
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      } 
    }
}

public class Solution {
    public int strStr(String haystack, String needle) {
      if(haystack == null || needle == null) {
            return -1;
      }

      int len1 = haystack.length();
      int len2 = needle.length();
      if(len1 == 0 && len2 == 0) {
          return 0;
      }
      for(int i = 0; i < len1; ++i) {
      if(len1 - i < len2) {
              break;
      }
            int j = i;
            int k = 0;
            while(j < len1 && k < len2) {
                  if(haystack.charAt(j) == needle.charAt(k)) {
                        j++;
                        k++;
                  } else {
                        break;
                  }
            }
            if(k == len2) {
                  return j - len2;
            }
      }

      return -1;
    }
}