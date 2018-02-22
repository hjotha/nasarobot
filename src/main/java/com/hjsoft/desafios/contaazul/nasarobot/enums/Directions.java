package com.hjsoft.desafios.contaazul.nasarobot.enums;

public enum Directions {
    NORTH {
        @Override
        public Directions prev() {
            return WEST;
        }
    },
    EAST,
    SOUTH,
    WEST {
        @Override
        public Directions next() {
            return NORTH;
        }
    };

    public Directions next() {
        return values()[ordinal() + 1];
    }

    public Directions prev() {
        return values()[ordinal() - 1];
    }
}