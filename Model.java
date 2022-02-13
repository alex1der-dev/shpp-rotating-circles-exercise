package com.shpp.p2p.cs.opidhaiko.assignment8_ext;

import acm.graphics.GOval;
import acm.util.RandomGenerator;

public class Model implements ModelConstants {

    Square[] squares;

    Model() {

        int counter = this.countSquares();
        this.squares = new Square[counter];
        for (int i = 0; i < counter; i++) {
            this.squares[i] = new Square(i);
        }
    }

    int countSquares() {

        int dotsOnSquareSide = (int) Math.sqrt(BALLS_AMOUNT);
        int counter = 1;
        while (dotsOnSquareSide > 1) {
            dotsOnSquareSide -= 2;
            counter++;
        }
        return counter;
    }
}

class Square implements ModelConstants {
    Circle[] circles;
    double leftUpCornerX;
    double leftUpCornerY;
    double leftDownCornerX;
    double leftDownCornerY;
    double rightUpCornerX;
    double rightUpCornerY;
    double rightDownCornerX;
    double rightDownCornerY;

    Square(int i) {

        int amount = i == 0 ? 1 : i * 8;
        this.circles = new Circle[amount];

        this.leftUpCornerX = i == 0 ? WIDTH / 2d - BALL_RADIUS : WIDTH / 2d - OFFSET * i - BALL_RADIUS;
        this.leftUpCornerY = i == 0 ? HEIGHT / 2d - BALL_RADIUS : HEIGHT / 2d - OFFSET * i - BALL_RADIUS;

        this.leftDownCornerX = this.leftUpCornerX;
        this.leftDownCornerY = i == 0 ? HEIGHT / 2d - BALL_RADIUS : HEIGHT / 2d + OFFSET * i - BALL_RADIUS;

        this.rightDownCornerX = i == 0 ? WIDTH / 2d - BALL_RADIUS : WIDTH / 2d + OFFSET * i - BALL_RADIUS;
        this.rightDownCornerY = this.leftDownCornerY;

        this.rightUpCornerX = this.rightDownCornerX;
        this.rightUpCornerY = this.leftUpCornerY;

        for (int j = 0; j < amount; j++) {

            this.circles[j] = new Circle(this.leftUpCornerX, this.leftUpCornerY);
            if (j > 0 && j <= amount / 4) {
                this.circles[j] = new Circle(this.leftUpCornerX, this.circles[j - 1].getY() + OFFSET);
            }
            if (j > amount / 4 && j <= amount / 4 * 2) {
                this.circles[j] = new Circle(this.circles[j - 1].getX() + OFFSET, this.leftDownCornerY);
            }
            if (j > amount / 4 * 2 && j <= amount / 4 * 3) {
                this.circles[j] = new Circle(this.rightDownCornerX, this.circles[j - 1].getY() - OFFSET);
            }
            if (j > amount / 4 * 3) {
                this.circles[j] = new Circle(this.circles[j - 1].getX() - OFFSET, this.rightUpCornerY);
            }
        }
    }
}

class Circle extends GOval implements ModelConstants{
    double speedX;
    double speedY;


    public Circle(double v, double v1) {
        super(v, v1, BALL_RADIUS * 2, BALL_RADIUS * 2);
        this.speedX = 0;
        this.speedY = 0;
        this.setColor(rgen.nextColor());
        this.setFilled(true);
    }
}