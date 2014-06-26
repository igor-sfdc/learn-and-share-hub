package resthub.google.maps.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import resthub.google.maps.example.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
