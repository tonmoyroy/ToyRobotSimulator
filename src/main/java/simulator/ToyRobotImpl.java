package simulator;

import commandpattern.Command;
import interfaces.Robot;
import model.CommandInput;
import model.Place;

public class ToyRobotImpl implements Robot {
    private final CommandFactory factory;
    private Place current;

    public ToyRobotImpl() {
        this.factory = new CommandFactory();

    }

    public void execute(CommandInput commandInput) {
        Command command = factory.createCommand(this, commandInput);
        command.execute();
    }

    public Place getCurrent() {
        return current;
    }

    public void setCurrent(Place current) {
        this.current = current;
    }
}
