package countriescities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CityCountryMethods {
    List<Country> countries;
    List<City> cities;

    public CityCountryMethods(List<Country> countries, List<City> cities) {
        this.countries = countries;
        this.cities = cities; }

    public List<Country> getCountries() {
        return countries; }

    public void setCountries(List<Country> countries) {
        this.countries = countries; }

    public List<City> getCities() {
        return cities; }

    public void setCities(List<City> cities) {
        this.cities = cities; }
    //
    public HashMap<String,List<String>> countryCities(){
        HashMap<String,List<String>> countryCities=new HashMap<>();
        for(Country country:countries){
            countryCities.put(country.getName(),cities.stream()
                    								.filter(city -> city.getCountryCode().equals(" "+country.getCode()))
                    								.map(City::getName)
                    								.collect(Collectors.toList()));
        	}
        return countryCities; 
        }

    public HashMap<String,Integer> populations() {
    	HashMap<String,Integer> countriesPopulation = new HashMap<>();
        this.countries.stream()
        			.forEach(x -> countriesPopulation.put(x.getName(),x.getPopulation()));
        return countriesPopulation;
        }


    public Double averageOfPopulations() {
        return countries.stream()
        		.distinct()
        		.mapToDouble(Country::getPopulation)
        		.average().getAsDouble(); 
        }


    public Integer maximumPopulation() {
        return countries.stream()
        		.mapToInt(Country::getPopulation)
        		.max().getAsInt(); 
        }
    

    public List<City> sortedCitiesByCountryCode(String s) {
        return cities.stream()
        		.filter(city -> city.getCountryCode().equals(" " +s))
        		.sorted(Comparator.comparing(City::getPopulation))
        		.collect(Collectors.toList()); 
        }

    public HashMap<String,List<String>> HighestCityPopPerCountry() {
        HashMap<String,List<String>> countryHighestCities=new HashMap<>();
        for(Country c:countries){
            countryHighestCities.put(c.getName(),cities.stream()
                            						  .filter(city -> city.getCountryCode().equals(" " + c.getCode()))
                            						  .sorted(Comparator.comparing(City::getPopulation).reversed())
                            						  .limit(1)
                            						  .map(City::getName)
                            						  .collect(Collectors.toList()));
            }
        return countryHighestCities;
    }

    public List<String> HighestCapitalPop() {
    	List<City> capitals = new ArrayList<>(); 
    	
    	List<Integer> capitalCodes = countries.stream()
        			.map(Country::getCapital)
        			.distinct().collect(Collectors.toList());
    	//List<City> capitals = this.cities.contains(capitalCodes); 
    	for(Integer code:capitalCodes) {
    		cities.stream()
    				.filter(city -> city.getId().equals(code))
    				.forEach(city -> capitals.add(city));
    	}
        return capitals.stream()
        		.sorted(Comparator.comparing(City::getPopulation).reversed())
        		.limit(1)
        		.map(City::getName)
        		.collect(Collectors.toList());
    }
}