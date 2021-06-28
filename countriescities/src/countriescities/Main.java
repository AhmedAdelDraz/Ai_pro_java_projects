package countriescities;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String [] args) throws IOException {

        //Reading and Creating Cities Objects From CSV File
        CityReadCSV cityReadCSV=new CityReadCSV();
        List <City> cities=cityReadCSV.readCitiesFromCSV("/home/draz/eclipse-workspace/countriescities/Cities.csv");

        //Reading and Creating Countries Objects From CSV File
        CountryReadCSV countryReadCSV = new CountryReadCSV();
        List<Country> countries = countryReadCSV.readCountriesFromCSV("/home/draz/eclipse-workspace/countriescities/Countries.csv");
        //Methods Class
        CityCountryMethods cityCountryMethods=new CityCountryMethods(countries,cities);
        //Create a map that uses the country code as keys and a list of cities as the value for
        //each country. 

/*
        Map<String, List<String>> countryCities = cityCountryMethods.countryCity();        
        System.out.println(countryCities);
*/                		
                		
/*       
              		// For a given country code (from Console) get the highest the city of the highest population.
        List <String> citiesSorted=cityCountryMethods.HighestCityPopPerCountry("EGY",1);
        for(String c:citiesSorted){
            System.out.println(c);
            }
*/
        List <String> capitalsStored = cityCountryMethods.HighestCapitalPop();
        for(String capital:capitalsStored) {
        	System.out.println(capital);
        }
        
/*
 
        //Get a List of countries population
        List<Integer> populations = cityCountryMethods.populations();
        System.out.println(populations);

        //Get the average countries population
        Double average =cityCountryMethods.averageOfPopulations();
        System.out.println("Average of Population is " +average);

        //Get the maximum countries population
        Integer maximumPopulation=cityCountryMethods.maximumPopulation();
        System.out.println("Maximum Population is " + maximumPopulation);
  */
    }
}

