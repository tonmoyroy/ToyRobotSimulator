package model;

import enums.Face;

public class RotateFace {

    private final Face leftFace;
    private final Face rightFace;

    public RotateFace(Face leftFace, Face rightFace) {
        this.leftFace = leftFace;
        this.rightFace = rightFace;
    }

    public Face getLeftFace() {
        return leftFace;
    }

    public Face getRightFace() {
        return rightFace;
    }
}
