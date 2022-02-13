package com.shpp.p2p.cs.opidhaiko.assignment8_ext;

import acm.util.RandomGenerator;

public interface ModelConstants {

    /**
     * Width and height of application window in pixels
     */
    int APPLICATION_WIDTH = 400;

    int APPLICATION_HEIGHT = 600;
    /**
     * Dimensions of canvas (usually the same)
     */
    int WIDTH = APPLICATION_WIDTH;

    int HEIGHT = APPLICATION_HEIGHT;

    /**
     * Radius of the ball in pixels
     */
    int BALL_RADIUS = 20;

    int BALLS_AMOUNT = 9; //9,25,49

    double SPEED = 1;

    int direction = 1;

    double OFFSET = 50;

    /**
     * initiation of Randomizer
     */
    RandomGenerator rgen = RandomGenerator.getInstance();

}
