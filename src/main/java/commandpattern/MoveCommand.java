package commandpattern;

import enums.Face;
import interfaces.Robot;
import model.Place;
import model.Point;

import java.util.EnumMap;

public class MoveCommand implements Command {

    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;

    private final Place current;
    private EnumMap<Face, Point> moveTable;
    public MoveCommand(Robot robot){
        this.current = robot.getCurrent();
        moveTable = new EnumMap<Face, Point>(Face.class);
        moveTable.put(Face.NORTH, new Point(0, 1));
        moveTable.put(Face.SOUTH, new Point(0, -1));
        moveTable.put(Face.WEST, new Point(-1, 0));
        moveTable.put(Face.EAST, new Point(1, 0));
    }

    public void execute() {
        Face currentFace = current.getFace();
        Point singleMove = moveTable.get(currentFace);

        if(validateMove(singleMove)){
            int newX = getNewX(singleMove);
            int newY = getNewY(singleMove);
            current.setPoint(new Point(newX, newY));
        }
    }

    private int getNewY(Point singleMove) {
        return current.getPoint().getY() + singleMove.getY();
    }

    private int getNewX(Point singleMove) {
        return current.getPoint().getX() + singleMove.getX();
    }

    private boolean validateMove(Point singleMove) {
        int newX = getNewX(singleMove);
        if (newX < 0 || newX >= MAX_X) return false;

        int newY = getNewY(singleMove);
        if (newY < 0 || newY >= MAX_Y) return false;

        return true;
    }
}
