package com.shpp.p2p.cs.opidhaiko.assignment8_ext;
/* File: Assignment8.java
 *
 *
 */

import acm.graphics.GObject;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.event.MouseEvent;

public class Assignment8 extends WindowProgram implements ModelConstants {

    int direction;

    public void run() {
        direction = 1;
        addMouseListeners();
        Model mod = new Model();

        for (int i = 0; i < mod.squares.length; i++) {
            for (int j = 0; j < mod.squares[i].circles.length; j++) {
                add(mod.squares[i].circles[j]);
            }
        }

        while (true) {
            for (int i = 1; i < mod.squares.length; i++) {

                for (int j = 0; j < mod.squares[i].circles.length; j++) {

                    Square currentSquare = mod.squares[i];
                    Circle currentCircle = mod.squares[i].circles[j];

                    if (direction > 0) {
                        if (currentCircle.getX() > currentSquare.leftUpCornerX && currentCircle.getY() == currentSquare.leftUpCornerY) {
                            currentCircle.speedX = direction > 0 ? -SPEED : SPEED;
                            currentCircle.speedY = 0;
                        }

                        if (currentCircle.getX() == currentSquare.leftUpCornerX && currentCircle.getY() < currentSquare.leftDownCornerY) {
                            currentCircle.speedX = 0;
                            currentCircle.speedY = direction > 0 ? SPEED : -SPEED;
                        }

                        if (currentCircle.getX() < currentSquare.rightDownCornerX && currentCircle.getY() == currentSquare.leftDownCornerY) {
                            currentCircle.speedX = direction > 0 ? SPEED : -SPEED;
                            currentCircle.speedY = 0;
                        }

                        if (currentCircle.getX() == currentSquare.rightDownCornerX && currentCircle.getY() > currentSquare.rightUpCornerY) {
                            currentCircle.speedX = 0;
                            currentCircle.speedY = direction > 0 ? -SPEED : SPEED;

                        }

                    } else {
                        if (currentCircle.getX() == currentSquare.leftUpCornerX && currentCircle.getY() > currentSquare.leftUpCornerY) {
                            currentCircle.speedX = 0;
                            currentCircle.speedY = direction > 0 ? SPEED : -SPEED;
                        }

                        if (currentCircle.getX() < currentSquare.rightUpCornerX && currentCircle.getY() == currentSquare.leftUpCornerY) {
                            currentCircle.speedX = direction > 0 ? -SPEED : SPEED;
                            currentCircle.speedY = 0;
                        }

                        if (currentCircle.getX() == currentSquare.rightUpCornerX && currentCircle.getY() < currentSquare.rightDownCornerY) {
                            currentCircle.speedX = 0;
                            currentCircle.speedY = direction > 0 ? -SPEED : SPEED;

                        }

                        if (currentCircle.getX() > currentSquare.leftDownCornerX && currentCircle.getY() == currentSquare.rightDownCornerY) {
                            currentCircle.speedX = direction > 0 ? SPEED : -SPEED;
                            currentCircle.speedY = 0;

                        }

                    }
                    currentCircle.move(currentCircle.speedX, currentCircle.speedY);
                }
            }
            pause(10);
        }
    }


    public void mousePressed(MouseEvent e) {
        GObject selectedObject = getElementAt(e.getX(), e.getY());
        if (selectedObject != null) {
            direction *= -1;
        }
    }
}
