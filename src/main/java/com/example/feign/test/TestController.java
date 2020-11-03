package com.example.feign.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class TestController {

    private final TestService testService;
    private final RestTemplate restTemplate;
    private static final String url = "https://restcountries.eu/rest/v2/all";

    public TestController(TestService testService, RestTemplate restTemplate) {
        this.testService = testService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String test1() {
        return testService.testFeign();
    }

    @GetMapping("/feign/countries")
    public List<Object> test2() {
        return testService.testFeign2();
    }

    @GetMapping("/rest/countries")
    public List<Object> test3() {
        Object[] countries = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(Objects.requireNonNull(countries));
    }
}
