package commandpattern;

import interfaces.Robot;
import model.PlaceCommandInput;

public class PlaceCommand implements Command {
    private Robot robot;
    private PlaceCommandInput input;

    public PlaceCommand(Robot robot, PlaceCommandInput input){
        this.robot = robot;
        this.input = input;
    }
    public void execute() {
        robot.setCurrent(input.getPlace());
    }
}
