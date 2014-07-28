import java.util.ArrayList;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int[] ip = new int[4];
        getIP(result, s, ip, 0, 0);
        return result;
    }

    private void getIP(ArrayList<String> result, String s, int[] ip, int start, int step){
    	int len = s.length() - start;
    	if(len < 4-step || len > (4-step)*3)
    		return;
    	
    	if(step == 4){
    		String ans = "";
    		if(len == 0){
    			for(int i = 0; i < 3; ++i){
    				ans += Integer.toString(ip[i]);
    				ans += "."; 
    			}
    			ans += Integer.toString(ip[3]);
    			result.add(ans);
    		}
    		return;
    	}
    	int addr = 0;
    	for(int i = start; i < start+3 && i < s.length(); ++i){ // i should in s boundary
    		int num = s.charAt(i) - '0';
    		addr = addr * 10 + num;
    		if(addr >= 0 && addr <= 255){
    			ip[step] = addr;
    			getIP(result, s, ip, i+1, step+1);
    			ip[step] = 0;
    		}
    		if(addr == 0) // 012 is invalid
    			break;
    	}
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		String str = "010010";
    		System.out.println(s.restoreIpAddresses(str));
    }
}