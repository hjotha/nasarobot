package com.hjsoft.desafios.contaazul.nasarobot.services;

import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidCommandException;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Tests for RobotServiceImpl
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RobotServiceImpl.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobotServiceImplTest {

    @Autowired
    RobotServiceImpl robotService;

    @Test
    public void test1_getPositionInitialTest() {
        assertEquals("(0, 0, N)\n", robotService.getPosition());
    }

    @Test(expected = InvalidCommandException.class)
    public void test2_executeCommandInvalidCharTest() {
        robotService.executeCommand("AAA");
    }

    @Test(expected = InvalidCommandException.class)
    public void test3_executeCommandNullTest() {
        robotService.executeCommand(null);
    }

    @Test(expected = InvalidPositionException.class)
    public void test4_executeCommandBigStringTest() {
        robotService.executeCommand("MMMMMMMMMMMMMMMM");
    }

    @Test(expected = InvalidPositionException.class)
    public void test5_executeCommandInvalidTurnTest() {
        robotService.executeCommand("LM");
    }

    @Test
    public void test6_executeCommandValidTest() {
        robotService.executeCommand("MMRMMRMM");
        assertEquals("(2, 0, S)\n", robotService.getPosition());
    }

    @Test
    public void test7_executeCommandValidTest() {
        robotService.executeCommand("MML");
        assertEquals("(0, 2, W)\n", robotService.getPosition());
    }
}