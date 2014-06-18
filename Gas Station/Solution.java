public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        int total = 0;
        int index = 0;
        for(int i = 0; i < len; ++i){
        	int dif = gas[i] - cost[i];
        	sum += dif;
        	if(sum < 0){
        		index = i + 1;
        		sum = 0;
        	}
        	total += dif;
        }
        return total >= 0 ? index : -1;
    }
}