package ITI;
import java.util.*;
import java.util.stream.*;

public class StreamsTest{
		public static void main(String [] args){
			InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance ();
			Map<String,Optional<City>> highestCityByCountry = worldDao.findAllCountries().stream()
											.collect(Collectors.toMap(
												Country::getCode,
												country->country.getCities().stream()
																			.max(Comparator.comparingInt(City::getPopulation))
												)					
											);
				
											
											
			Map<String,Optional<City>> highestCityByContinent = worldDao.findAllCountries().stream()
											.collect(Collectors.groupingBy(
												Country::getContinent,
												Collectors.flatMapping(country -> country.getCities().stream(),
																		Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
									
										))
										);
			Optional<City> highestPopulatedCapitalCity = worldDao.findAllCountries().stream()
												.map(Country::getCapital)
												.filter(id -> id != null && id > 0)
												.map(worldDao::findCityById)   										
												.max(Comparator.comparingInt(City::getPopulation));
											
			System.out.println("The highest population city of each country : ");
			highestCityByCountry.forEach((code, city) -> 
			System.out.println(code + " -> " + city.map(City::getName).orElse("No city")));
			System.out.print("\n\n\n");
			System.out.println("The highest population city of each continent : ");
			highestCityByContinent.forEach((continent, city) -> 
			System.out.println(continent + " -> " + city.map(City::getName).orElse("No city")));
			System.out.print("\n\n\n");
			System.out.println("The highest population capital city in the world " + highestPopulatedCapitalCity.map(City::getName).orElse("No city"));		
		}
}