package com.hjsoft.desafios.contaazul.nasarobot.interfaces;

import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidCommandException;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;

public interface RobotService {

    String getPosition();

    void sendCommand(String command) throws InvalidCommandException, InvalidPositionException;

}
