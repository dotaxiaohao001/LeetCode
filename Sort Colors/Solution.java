public class Solution {
    public void sortColors(int[] A) {
    	int len = A.length;
    	int red = -1;
    	int blue = len;

    	int i = 0;
// if if if is not the case it will check one by one
    	while(i < blue) {
    		// red
    		if(A[i] == 0) {
    			red++;
    			swap(A, red, i);
    			i++;
    		}
    		// white do nothing
    		else if(A[i] == 1) {
    			i++;
    		}
    		// blue
    		else if(A[i] == 2) {
    			blue--;
    			swap(A, blue, i);
    			//can't i++, it not processed
    		}
    	}
        
    }

    private void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}