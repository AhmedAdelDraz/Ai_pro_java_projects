package countriescities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryReadCSV {
    public CountryReadCSV(){}
        public List<Country> readCountriesFromCSV(String filename) throws NullPointerException, IOException {
            BufferedReader br=null;
            try { br = new BufferedReader(new FileReader(filename)); } catch (FileNotFoundException e) {
                e.printStackTrace(); }
            String [] attribute;
            String line;
            List <Country> countries = new ArrayList<Country>();
            while((line=br.readLine())!=null){
                attribute=line.split(",");
                Country country = new Country(
                        attribute[0],
                        attribute[1],
                        attribute[2],
                        Double.parseDouble(attribute[3]),
                        (int) Float.parseFloat(attribute[4]),
                        Double.parseDouble(attribute[5]),
                        Integer.parseInt(attribute[6]));
                countries.add(country); }
            return countries; }


    }