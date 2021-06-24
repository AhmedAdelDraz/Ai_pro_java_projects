package pyramids;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.NumberFormatException;
public class PyramidCSVDAO {
/*
	PyramidCSVDAO(){
	}
*/	
	public List<Pyramid> readPyramidsFromCSV(String fileName,boolean header)throws Exception{
		List<Pyramid> pyramids = new LinkedList<>();
		Thread th = new Thread(new Runnable() {
									public void run() {
										try {
											String[] placeholder;
											Pyramid pyramid;
											
											BufferedReader br = new BufferedReader(new FileReader(fileName));
											String line = br.readLine();
											
											if (header==true) {
												line = br.readLine();
											}

											if (line!=null) {
												placeholder = line.split(",");
												pyramid = createPyramid(placeholder);
												pyramids.add(pyramid);
											}
											
											do {
												line = br.readLine();
												if(line == null) break;
												placeholder = line.split(",");
												pyramid = createPyramid(placeholder);
												pyramids.add(pyramid);
											}while(line!=null);
											
											br.close();
											
											}catch(IOException ex) {
												ex.printStackTrace();
											}
									}
								});
		th.start();
		th.join();
		
		return pyramids;
	}
	
	public Pyramid createPyramid(String[] metadata) {
		try {
			Pyramid pyramid = new Pyramid(metadata[0],metadata[2],metadata[4],Float.parseFloat(metadata[7]));
			return pyramid;
		}catch(NumberFormatException ex) {
			Pyramid pyramid = new Pyramid(metadata[0],metadata[2],metadata[4],0);
			return pyramid;
		}
	}
	
}
