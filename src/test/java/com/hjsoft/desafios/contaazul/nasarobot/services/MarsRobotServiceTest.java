package com.hjsoft.desafios.contaazul.nasarobot.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Tests for MarsRobotService
 */
@RunWith(SpringRunner.class)
@AutoConfigureWebMvc
//@WebMvcTest( MarsRobotService.class, PlanetMarsService.class)
public class MarsRobotServiceTest {

    @Autowired
    MarsRobotService marsRobotService;

    @Test
    public void getPositionInitialTest() {
      assertEquals( marsRobotService.getPosition(), "(0, 0, N)" );
    }

    @Test
    public void executeCommand() {
    }
}