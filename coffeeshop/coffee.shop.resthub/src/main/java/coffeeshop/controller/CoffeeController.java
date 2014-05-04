package coffeeshop.controller;

import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.web.controller.RepositoryBasedRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coffeeshop.model.Coffee;
import coffeeshop.repository.CoffeeRepository;
@Controller
@RequestMapping(value = "/api/coffee")
public class CoffeeController extends RepositoryBasedRestController<Coffee, Long, CoffeeRepository> {
    private final Logger slf4jLogger = LoggerFactory.getLogger(CoffeeController.class);

    @Inject
    @Named("coffeeRepository")
    @Override
    public void setRepository(CoffeeRepository repository) {
        this.repository = repository;
    }

    // TODO: Temporarily override super methods
    @Override
	public Coffee create(@RequestBody Coffee resource) {
        slf4jLogger.info("Create: " + resource);
		return super.create(resource);
	}

	@Override
	public void delete(@PathVariable Long id) {
        slf4jLogger.info("Delete: " + id);
		super.delete(id);
	}

	@Override
	public Coffee update(@PathVariable Long id, @RequestBody Coffee resource) {
        slf4jLogger.info("update: " + id + " - " + resource);
		return super.update(id, resource);
	}

	@Override
	public Iterable<Coffee> findAll() {
		Iterable<Coffee> all = super.findAll();
		Iterator<Coffee> iterator = all.iterator();
        slf4jLogger.info("findAll:");
		while(iterator.hasNext()) {
	        slf4jLogger.info("element: " + iterator.next());		
		}
		return all;
	}

	@Override
	public Coffee findById(@PathVariable Long id) {
        slf4jLogger.info("findById: " + id);	
		return super.findById(id);
	}

	@Override
    public Page<Coffee> findPaginated(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "direction", required = false, defaultValue = "") String direction,
            @RequestParam(value = "properties", required = false) String properties) {
		Page<Coffee> all = super.findPaginated(page, size, direction, properties);
        slf4jLogger.info("findPaginated:");
		Iterator<Coffee> iterator = all.iterator();
		while(iterator.hasNext()) {
	        slf4jLogger.info("element: " + iterator.next());			
		}
		return all;
	}
    
}
