package commandpattern;

import enums.Face;
import interfaces.Robot;
import model.Place;
import model.RotateFace;

public class LeftCommand extends RotateCommand {
    private final Place current;

    public LeftCommand(Robot robot){
        this.current = robot.getCurrent();
    }
    public void execute() {
        Face currentFace = current.getFace();
        RotateFace rotateFace = getRotateTable().get(currentFace);
        current.setFace(rotateFace.getLeftFace());
    }
}
