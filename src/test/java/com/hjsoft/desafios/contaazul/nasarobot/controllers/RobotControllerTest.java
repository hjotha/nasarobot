package com.hjsoft.desafios.contaazul.nasarobot.controllers;

import com.hjsoft.desafios.contaazul.nasarobot.RobotApplication;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Tests for RobotController
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobotControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void test1_InitialPositionTest() {
        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/LR"),
                HttpMethod.POST, entity, String.class);

        assertEquals("(0, 0, N)\n", response.getBody());
    }

    @Test
    public void test2_InvalidCommandTest() {

        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/AAAA"),
                HttpMethod.POST, entity, String.class);

        assertEquals("400 Bad Request\n", response.getBody());
    }

    @Test
    public void test3_EmptyCommandTest() {

        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/"),
                HttpMethod.POST, entity, String.class);

        assertEquals("404 Not Found\n", response.getBody());
    }

    @Test
    public void test4_BigCommandTest() {

        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"),
                HttpMethod.POST, entity, String.class);

        assertEquals("400 Bad Request\n", response.getBody());
    }

    @Test
    public void test5_InvalidTurnCommandTest() {

        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/LM"),
                HttpMethod.POST, entity, String.class);

        assertEquals("400 Bad Request\n", response.getBody());
    }

    @Test
    public void test6_ValidCommandTest() {

        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/MMRMMRMM"),
                HttpMethod.POST, entity, String.class);

        assertEquals("(2, 0, S)\n", response.getBody());
    }

    @Test
    public void test7_ValidCommandTest() {

        HttpEntity<String> entity = new HttpEntity<String>(null,null);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rest/mars/MML"),
                HttpMethod.POST, entity, String.class);

        assertEquals("(0, 2, W)\n", response.getBody());
    }
}