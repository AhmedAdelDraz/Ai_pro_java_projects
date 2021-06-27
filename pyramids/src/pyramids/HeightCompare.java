package pyramids;
import java.util.Comparator;

public class HeightCompare implements Comparator<Pyramid>{
	public int compare(Pyramid a, Pyramid b)
    {
        return (int)(b.height - a.height);
    }
}
