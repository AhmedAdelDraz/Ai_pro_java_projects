package ip;

public class Parser {
	private String commandLine;
	private String splitor;
	
	public Parser(String commandLine) {
		this.commandLine = commandLine;
	}
	
	public void setCommandLine(String commandLine){
		this.commandLine = new String(commandLine);
	}
	
	public int []spliter(String splitor) {
		if (this.commandLine == null) {
			throw new RuntimeException("No command had been parsed");
		}
		
		else {
		this.splitor = new String(splitor);
		String []octats = this.commandLine.split(splitor);
		int [] int_octats = new int[4];
		
		for(int i=0;i<octats.length;i++) {
			int_octats[i] = Integer.parseInt(octats[i]);
		}
			
		return int_octats;
		}
	}
	
}   
