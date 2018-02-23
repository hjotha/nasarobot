/**
 * This enum represents the four cardinal direction points:
 * <p>
 * NORTH, EAST, SOUTH, WEST
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.enums;

/**
 * Directions that can be used.
 *
 * Note the clever usage of @Override to cycle between the directions.
 * Order is important here.
 */
public enum Directions {
    /**
     * North direction.
     */
    NORTH {
        @Override
        public Directions prev() {
            return WEST; // prev from North is West
        }
    },
    /**
     * East direction.
     */
    EAST,
    /**
     * South direction.
     */
    SOUTH,
    /**
     * West direction.
     */
    WEST {
        @Override
        public Directions next() {
            return NORTH; // next from West is North
        }
    };

    /**
     *  Get next direction in cycle.
     * @return next direction
     */
    public Directions next() {
        return values()[ordinal() + 1];
    }

    /**
     * Get previous direction in cycle.
     * @return previous direction
     */
    public Directions prev() {
        return values()[ordinal() - 1];
    }
}