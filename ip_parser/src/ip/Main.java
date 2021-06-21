package ip;

public class Main {

	public static void main(String[] args) {
		String input = "163.121.12.30";
		Parser iparser = new Parser(input);
		
		//iparser.setCommandLine(input);
		int []octats = iparser.spliter("\\.");
		
		for(int value: octats){
			System.out.println(value);
		}
	}

}
