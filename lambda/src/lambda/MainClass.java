package lambda;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String	string1 ="Adel";
		String  string2 ="Ahmed";
		String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
		String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
		
		System.out.println(longer);
		System.out.println(first);
	}

}
