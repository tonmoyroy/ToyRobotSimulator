package model;

import enums.Face;

public class Place {
    private Point point;
    private Face face;

    public Place(Point point, Face face) {
        this.point = point;
        this.face = face;
    }

    public void setFace(Face face){
        this.face = face;
    }

    public Face getFace() {
        return face;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
}
