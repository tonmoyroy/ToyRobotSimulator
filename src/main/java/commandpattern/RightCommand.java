package commandpattern;

import enums.Face;
import interfaces.Robot;
import model.Place;
import model.RotateFace;

public class RightCommand extends RotateCommand{
    private final Place current;

    public RightCommand(Robot robot){
        this.current = robot.getCurrent();
    }
    public void execute() {
        Face currentFace = current.getFace();
        RotateFace rotateFace = getRotateTable().get(currentFace);
        current.setFace(rotateFace.getRightFace());
    }
}
