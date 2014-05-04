package coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeeshop.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
