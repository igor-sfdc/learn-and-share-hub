package coffeeshop.controller;

import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.web.controller.RepositoryBasedRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coffeeshop.model.Country;
import coffeeshop.repository.CountryRepository;

@Controller
@RequestMapping(value = "/api/country")
public class CountryController extends RepositoryBasedRestController<Country, Long, CountryRepository> {
    private final Logger slf4jLogger = LoggerFactory.getLogger(getClass());

    @Inject
    @Named("countryRepository")
    @Override
    public void setRepository(CountryRepository repository) {
        this.repository = repository;
    }


	@Override
	public Iterable<Country> findAll() {
		Iterable<Country> all = super.findAll();
		Iterator<Country> iterator = all.iterator();
		slf4jLogger.info("findAll:");
		while(iterator.hasNext()) {
			slf4jLogger.info("element: " + iterator.next());			
		}
		return all;
	}

	@Override
    public Page<Country> findPaginated(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "direction", required = false, defaultValue = "") String direction,
            @RequestParam(value = "properties", required = false) String properties) {
		// TODO Auto-generated method stub
		Page<Country> all = super.findPaginated(page, size, direction, properties);
		slf4jLogger.info("findPaginated:");
		Iterator<Country> iterator = all.iterator();
		while(iterator.hasNext()) {
			slf4jLogger.info("element: " + iterator.next());			
		}
		return all;
	}

    
}
