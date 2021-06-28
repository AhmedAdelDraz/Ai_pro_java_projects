package countriescities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class CityCountryMethods {
    List<Country> countries;
    List<City> cities;

    public CityCountryMethods(List<Country> countries, List<City> cities) {
        this.countries = countries;
        this.cities = cities;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    //
    public List<Integer> populations() {
        return this.countries.stream().map(Country::getPopulation).collect(Collectors.toList());
    }

    public Double averageOfPopulations() {
        return countries.stream().mapToDouble(Country::getPopulation).average().getAsDouble();
    }

    public Integer maximumPopulation() {
        return countries.stream().mapToInt(Country::getPopulation).max().getAsInt();
    }
    
    
    public List<String> HighestCityPopPerCountry(String s,int order) {
        return cities.stream()
        		.filter(city -> city.getCountryCode().equals(" " + s))
        		.sorted(Comparator.comparing(City::getPopulation).reversed())
        		.limit(order)
        		.map(City::getName)
        		.collect(Collectors.toList());
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
    
    public Map<String, List<String>> countryCity(){
    	Map<String, List<String>> countryCities = new HashMap<>();
        
        List<String> countriesCodes = countries.stream()
        		.map(Country::getCode)
        		.distinct().collect(Collectors.toList());
                
        for(String code: countriesCodes) {
        	List<String> citiesNames = cities.stream()
        			.filter(city -> city.getCountryCode().equals(" "+code))
        			.map(City::getName)
        			.collect(Collectors.toList());
        	countryCities.put(code, citiesNames);
        }
    	return countryCities;
    }
    
}
