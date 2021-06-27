package lambda;

public class StringUtils {
	public static String betterString(String s1, String s2,Bipredicate<String> p) {
		String out = p.test(s1, s2) ? s1:s2;
		return out;
	}
}
