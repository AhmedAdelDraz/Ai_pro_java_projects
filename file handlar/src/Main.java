import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		FileWriter writer = new FileWriter("/home/draz/Desktop/java_output.txt");
		BufferedWriter buffer = new BufferedWriter(writer);
		
		String line;
		do {	
			line = br.readLine();
			if(!line.equalsIgnoreCase("stop")){
					buffer.write(line+"\n");
			}
		}
		while(!line.equalsIgnoreCase("stop"));
		
	
		br.close();
		buffer.close();
		
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
	}

}
