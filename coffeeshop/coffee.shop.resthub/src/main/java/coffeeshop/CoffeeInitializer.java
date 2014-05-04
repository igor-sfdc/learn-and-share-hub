package coffeeshop;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.util.PostInitialize;
import org.springframework.context.annotation.DependsOn;

import coffeeshop.model.Coffee;
import coffeeshop.model.Country;
import coffeeshop.repository.CoffeeRepository;
import coffeeshop.repository.CountryRepository;

@Named("coffeeInitializer")
@DependsOn("CountryInitializer")
public class CoffeeInitializer {

    @Inject
    @Named("coffeeRepository")
    private CoffeeRepository coffeeRepository;    
    
    @Inject
    @Named("countryRepository")
    private CountryRepository countryRepository;
    
    
    // CoffeeInitializer needs to be executed after CountryInitializer
    @PostInitialize(order=2)
    public void init() {
    	
    	List<Country> allCountries = countryRepository.findAll();   	
    	
    	Coffee coffee1 = new Coffee("Colombian creme");
    	coffee1.setDescription("Chocolatey");
    	coffee1.setRegion("Mountain");
    	coffee1.setCountryFrom(allCountries.get(0));
    	coffee1.setProcessed("roasted");
    	coffee1.setWeight(2);
		coffeeRepository.save(coffee1);
		
    	Coffee coffee2 = new Coffee("French Roast");
    	coffee2.setDescription("bitter");
    	coffee2.setRegion("Shade");
    	coffee2.setCountryFrom(allCountries.get(1));
    	coffee2.setProcessed("roasted");
    	coffee2.setWeight(1);
		coffeeRepository.save(coffee2);
		
    	Coffee coffee3 = new Coffee("Tassimo");
    	coffee3.setDescription("Curious");
    	coffee3.setRegion("Unknown");
    	coffee3.setCountryFrom(allCountries.get(2));
    	coffee3.setProcessed("capsule");
    	coffee3.setWeight(1);
		coffeeRepository.save(coffee3);
    }
}
