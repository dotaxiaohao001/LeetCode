public class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();

        String[] dir = path.split("/");

        for(int i = 0; i < dir.length; ++i){
        	if(dir[i].equals(".") || dir[i].equals(""))  // can't use ==  object same, should use equals to compare the value.
        		continue;
        	else if(dir[i].equals("..")){
        		if(!s.empty())
        			s.pop();
        	}else{
        		s.push(dir[i]);
        	}
        }

        StringBuffer result = new StringBuffer();
        while(!s.empty()){
        	result = result.insert(0, s.pop());
        	result = result.insert(0, "/");
        }
        
        String r = result.toString();
        if(r.equals(""))
        	return "/";
        else
        	return r;
    }
}