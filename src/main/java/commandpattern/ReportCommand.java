package commandpattern;

import interfaces.Robot;
import model.Place;

public class ReportCommand implements Command {
    private final Place current;

    public ReportCommand(Robot robot){
        this.current = robot.getCurrent();
    }

    public void execute() {
        int x = current.getPoint().getX();
        int y = current.getPoint().getY();
        String faceStr = current.getFace().toString();
        System.out.println("Output: " + x + "," + y + "," + faceStr);
    }
}
