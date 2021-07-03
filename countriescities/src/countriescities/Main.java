package countriescities;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        //Reading and Creating Cities Objects From CSV File
        CityReadCSV cityReadCSV=new CityReadCSV();
        List <City> cities=cityReadCSV.readCitiesFromCSV("/home/draz/git/Ai_pro_java_projects/countriescities/src/Cities.csv");

        //Reading and Creating Countries Objects From CSV File
        CountryReadCSV countryReadCSV = new CountryReadCSV();
        List<Country> countries = countryReadCSV.readCountriesFromCSV("/home/draz/git/Ai_pro_java_projects/countriescities/src/Countries.csv");
        //Methods Class
        CityCountryMethods cityCountryMethods = new CityCountryMethods(countries,cities);

        //Create a map that uses the country code as keys and a list of cities as the value for
        //each country.
        
        /*
        HashMap<String,List<String>> countryCities=countryCities=cityCountryMethods.countryCities();
        System.out.println(" Country:Cities\n" + countryCities);
        */
        
        /*************************************************** Get a List of countries population *************************************************/
        HashMap<String,Integer> populations = cityCountryMethods.populations();
        System.out.println("Populations list\n"+populations+"\n\n");
        
        /*************************************************** Get the average countries population ***********************************************/
        Double averagePopulation =cityCountryMethods.averageOfPopulations();
        System.out.println("Average of Population is " +averagePopulation+"\n\n");
        
        /*************************************************** Get the maximum countries population ***********************************************/
        Integer maximumPopulation=cityCountryMethods.maximumPopulation();
        System.out.println("Maximum Population is " + maximumPopulation+"\n\n");
        
        /***************************************************  Highest City Population Per Country  **********************************************/
        HashMap<String,List<String>> highestCities=cityCountryMethods.HighestCityPopPerCountry();
        System.out.println("List of cities with the highest population in each country\n"+highestCities+"\n\n");
        
        /***************************************************      Highest Capital Population       **********************************************/
        List<String> highestCapitalPop = cityCountryMethods.HighestCapitalPop();
        System.out.println("Capital With Highest Population is \n"+highestCapitalPop+"\n\n");
        /*
        // For a given country code (from Console) sort the cities according to the population
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Country Code");
        String s = scanner.nextLine();
        scanner.close();
        
        List <City> citiesSorted=cityCountryMethods.sortedCitiesByCountryCode(s);
        for(City c:citiesSorted){
            //System.out.println(c.getName()+" "+c.getPopulation());
            System.out.println(c);
        }
        */
    }
}