package resthub.selenium.integration.test.example;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.util.PostInitialize;

import resthub.selenium.integration.test.example.model.Sample;
import resthub.selenium.integration.test.example.repository.SampleRepository;

@Named("sampleInitializer")
public class SampleInitializer {

    @Inject
    @Named("sampleRepository")
    private SampleRepository sampleRepository;

    @PostInitialize
    public void init() {
        sampleRepository.save(new Sample("testSample1"));
        sampleRepository.save(new Sample("testSample2"));
        sampleRepository.save(new Sample("testSample3"));
    }
}
