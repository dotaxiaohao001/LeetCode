import java.util.Arrays;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int i = 0;
        int j = len - 1;
        int[] result = new int[2];
        // copy array
        int[] sortNum = new int [len];
        for(int k = 0; k < len; ++k){
        	sortNum[k] = numbers[k];
        }
        Arrays.sort(sortNum);
        while(i < j){
        	if(sortNum[i] + sortNum[j] == target){
        		result[0] = sortNum[i];
        		result[1] = sortNum[j];
        		break;
        	}
        	else if(sortNum[i] + sortNum[j] < target)
        		i++;
        	else// sortNum[i] + sortNum[j] > target
        		j--;
        }
        //find index in original array
        int[] index = new int[2];
        int h = 0;
        int finded = -1;
        for(int k = 0; k < len; ++k){
        	if(numbers[k] == result[0]){
        		index[h] = k + 1;
        		h++;
        		finded = k;
        		break;
        	}
        }
        for(int k = 0; k < len; ++k){
        	if(numbers[k] == result[1]&&k != finded){
        		index[h] = k + 1;
        		break;
        	}
        }
        //exchange index if index0 > index1
        if(index[0] > index[1]){
        	int temp = index[0];
        	index[0] = index[1];
        	index[1] = temp;
        }
        return index;
    }
    
    public static void main(String[] args){
    	int[] num = {2, 3, 7, 3,11 ,15};
    	int t = 6;
    	Solution s = new Solution();
    	int[] re = s.twoSum(num, t);
    	System.out.println(re[0]);
    	System.out.println(re[1]);
    	
    }
}