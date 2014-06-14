/*public class Solution {
    public int removeElement(int[] A, int elem) {
        int index = -1;
        int len = A.length;
        for(int i = 0; i < len; ++i){
        	if(A[i] != elem)
        		A[++index] = A[i];
        }
        return index + 1;

    }
}*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int k = len;// the index with value elem
        int i = 0;
        while(i < k){
        	if(A[i] != elem)
        		i++;
        	else{
        		//swap A[i] with A[k-1] here
        		A[i] = A[--k];
        		//A[k] = elem is not necessary
        	}
        }
        return k;
    }
}