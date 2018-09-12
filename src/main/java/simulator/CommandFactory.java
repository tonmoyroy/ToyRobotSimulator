package simulator;

import commandpattern.*;
import interfaces.Robot;
import model.CommandInput;
import model.PlaceCommandInput;

public class CommandFactory {
    public Command createCommand(Robot robot, CommandInput input) {
        switch (input.getCommand()) {
            case PLACE:
                return new PlaceCommand(robot, (PlaceCommandInput) input);
            case MOVE:
                return new MoveCommand(robot);
            case LEFT:
                return new LeftCommand(robot);
            case RIGHT:
                return new RightCommand(robot);
            case REPORT:
                return new ReportCommand(robot);
            default:
                return new NoOpCommand();
        }
    }
}
