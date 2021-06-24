package pyramids;
import java.util.*;

public class MainClass {

	public static void main(String[] args) throws Exception {
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("/home/draz/eclipse-workspace/pyramids/pyramids.csv",true);
		
		int i=0;
		
		for (Pyramid p:pyramids) {
			System.out.println("#"+(i++)+' '+p.pharaoh+' '+p.modern_name+' '+p.site+' '+p.height);
		}
	}

}
