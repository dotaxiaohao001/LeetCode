import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Solution {
	private static final String NumRegEx = "[-+]?([0-9]*\\.?[0-9]+|[0-9]+\\.[0-9]*)([eE][-+]?[0-9]+)?";//3. and .3 both valid but . is not valid
	private static Pattern pattern = Pattern.compile(NumRegEx);
	private static Matcher matcher;
	public boolean isNumber(String s) {
		matcher = pattern.matcher(s.trim());
		return matcher.matches();
    }
}