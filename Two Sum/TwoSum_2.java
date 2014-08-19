/**
*Two Sum
*/
// mistake:
// 1. 数组不一定是有序， 直接在原数组排序会破坏index
// 2. index is not zero-based should + 1
// 3. typo， numbers(number), miss ;


// 思路：
// 1.排序数组
// 2.设置两头reference 从两边 往 中间 move
// 3.如果sum 为当前l 和 r指向的和
// 	if sum == target ==>l r为所要求的数
// 	if sum > target  ==> r-- 所有比r bigger or equal 都 使得 l+r > target 
// 	if sum < target  ==> l++  同理 < target
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	int len = numbers.length;
    	int l = 0;
    	int r = len-1;
    	int[] sortNumbers = new int[len];
    	for(int i = 0; i < len; ++i) {
    		sortNumbers[i] = numbers[i];
    	}
    	//numbers is not necessarily the sorted array, so should sort first
    	Arrays.sort(sortNumbers);
    	int first = 0;
    	int second = 0;
    	while(l < r) {
    		int sum = sortNumbers[l] + sortNumbers[r];
    		if(sum == target) {
    			first = sortNumbers[l];
    			second = sortNumbers[r];
    			break;
    		}
    		else if(sum < target) {
    			l++;
    		}
    		else {//sum > target
    			r--;
    		}
    	}

    	//find the two number in original array index
    	boolean findFirst = false;
    	for(int i = 0; i < len; ++i) {
    		if(numbers[i] == first || numbers[i] == second) {
    			if(!findFirst) {
    				result[0] = i+1;
    				findFirst = true;
    			}
    			else {
    				result[1] = i+1;
    				break;
    			}
    		}
    	}


    	return result; // default return 0 0
    }
}