package countriescities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityReadCSV {
    public CityReadCSV(){}
    public List<City> readCitiesFromCSV(String filename) throws NullPointerException, IOException {
        BufferedReader br=null;
        try { br = new BufferedReader(new FileReader(filename)); } catch (FileNotFoundException e) {
            e.printStackTrace(); }
        String [] attribute;
        String line;
        List<City> cities = new ArrayList<City>();
        while((line=br.readLine())!=null){
            attribute=line.split(",");
            City city = new City(
                    Integer.parseInt(
                    attribute[0]),
                    attribute[1],
                    Integer.parseInt(attribute[2]),
                    attribute[3]);
            cities.add(city); }
        return cities; }


}
