public class Solution {
    public void setZeroes(int[][] matrix) {
    	
    	// m = r number   n = c number
    	int m = matrix.length, n = matrix[0].length;
    	//used to check the first row, column would be 0
    	boolean r = false, c = false;
    	
       for(int i = 0; i < m; ++i){
    	   if(matrix[i][0] == 0){
    		   c = true;
    		   break;
    	   }
       }
       for(int j = 0; j < n; ++j){
    	   if(matrix[0][j] == 0){
    		   r = true;
    		   break;
    	   }
       }
       for(int i = 1; i < m; ++i)
    	   for(int j = 1; j < n; ++j){
    		   if(matrix[i][j] == 0){
    			   //set 
    			   matrix[i][0] = 0;
    			   matrix[0][j] = 0; // first error typo matrix[0][i] = 0
    		   }
    	   }
       /*for(int i = 1; i < m; ++i){
    	   if(matrix[i][0] == 0){
    		   for(int j = 1; j < n; ++j)
    			   matrix[i][j] = 0;
    	   }
       }
       for(int j = 1; j < n; ++j){
    	   if(matrix[0][j] == 0){
    		   for(int i = 1; i < m; ++i)
    			   matrix[i][j] = 0;
    	   }
       }*/
       // alternative way
       for(int i = 1; i < m; ++i)
    	   for(int j = 1; j < n; ++j){
    		   if(matrix[0][j] == 0 || matrix[i][0] == 0)
    			   matrix[i][j] =0;
    	   }
       
       if(c == true){
    	   for(int i = 0; i < m; ++i)
    		   matrix[i][0] = 0;
       }
       if(r == true){
    	   for(int j = 0; j < n; ++j)
    		   matrix[0][j] = 0;
       } 
    }
}