package pyramids;
import java.util.*;

public class MainClass {

	public static void main(String[] args) throws Exception {
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("/home/draz/git/Ai_pro_java_projects/pyramids/pyramids.csv",true);
		
		int i=0;
		
		for (Pyramid p:pyramids) {
			System.out.println("#"+(i++)+' '+p.pharaoh+' '+p.modern_name+' '+p.site+' '+p.height);
		}
		
		Map<String,Integer> sites =  pDAO.siteNumbers(pyramids);
		System.out.println(sites);	
		
		List<Pyramid> sorted_pyramids = pDAO.sort(pyramids);
		
		for (Pyramid p:sorted_pyramids) {
			System.out.println("#"+(i++)+' '+p.pharaoh+' '+p.modern_name+' '+p.site+' '+p.height);
		}
	}
	

}
