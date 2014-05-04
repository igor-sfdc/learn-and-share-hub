package coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeeshop.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
