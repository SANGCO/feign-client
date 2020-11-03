package com.example.feign.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "countries", url="https://restcountries.eu")
public interface TestClient2 {

    @GetMapping("/rest/v2/all")
    List<Object> testFeign2();
}
