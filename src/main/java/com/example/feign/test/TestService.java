package com.example.feign.test;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestClient testClient;
    private final TestClient2 testClient2;

    public TestService(TestClient testClient, TestClient2 testClient2) {
        this.testClient = testClient;
        this.testClient2 = testClient2;
    }

    public String testFeign() {
        return testClient.testFeign();
    }

    public List<Object> testFeign2() {
        return testClient2.testFeign2();
    }

}
