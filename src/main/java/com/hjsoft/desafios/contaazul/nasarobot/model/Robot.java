/**
 * This bean contains the basic robot attributes.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.model;

import com.hjsoft.desafios.contaazul.nasarobot.enums.Directions;

/**
 * Robot bean
 */
public class Robot {

    /**
     * Robot's facing
     *
     * Init Robot facing with the default direction.
     */
    private Directions facing = Directions.NORTH;

    /**
     * Robot's planet
     */
    private Planet planet;

    /**
     * Planet setting constructor.
     *
     * @param planet the current planet
     */
    public Robot(Planet planet) {
        this.planet = planet;
    }

    /**
     *  Gets the current facing.
     *
     * @return enum with current facing.
     */
    public Directions getFacing() {
        return facing;
    }

    /**
     * Sets the current facing.
     *
     * @param facing enum with facing.
     */
    public void setFacing(Directions facing) {
        this.facing = facing;
    }

    /**
     * Gets the current robot planet.
     *
     * @return the planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * Set the current robot planet.
     *
     * @param planet the planet
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
