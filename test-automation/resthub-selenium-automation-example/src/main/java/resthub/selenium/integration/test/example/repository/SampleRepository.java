package resthub.selenium.integration.test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import resthub.selenium.integration.test.example.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
