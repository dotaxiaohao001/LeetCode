public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len <= 2) 
        	return len;
		//similar just compare the two before
        int index = 2;// index is next postion of valid array. from 0 1 | 2
        for(int i = 2; i < len; ++i){
        	if(A[i] != A[index - 2])
        		A[index++] = A[i];
        }
        return index;// no need plus 1
    }
}

//better
/*public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        int num = 2;//allowed at most twice
        if(len <= num) // smaller than 2 already valid
        	return len;
        int index = num;//next position
        for(int i = num; i < len; ++i){
        	if(A[i] != A[index - num])
        		A[index++] = A[i];
        }
        return index;// no need plus 1
    }
}*/