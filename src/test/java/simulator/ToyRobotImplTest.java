package simulator;

import enums.CommandEnum;
import enums.Face;
import model.CommandInput;
import model.Place;
import model.PlaceCommandInput;
import model.Point;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyRobotImplTest {

    private ToyRobotImpl robot;

    @Before
    public void initiate() {
        this.robot = new ToyRobotImpl();
    }

    @Test()
    public void test_inputA() {
        PlaceCommandInput commandInput = new PlaceCommandInput(CommandEnum.PLACE);
        commandInput.setPlace(new Place(new Point(0, 0), Face.NORTH));
        robot.execute(commandInput);
        assertValues(Face.NORTH, 0, 0);

        robot.execute(new CommandInput(CommandEnum.MOVE));
        assertValues(Face.NORTH, 0, 1);

        robot.execute(new CommandInput(CommandEnum.REPORT));
        assertValues(Face.NORTH, 0, 1);
    }

    @Test()
    public void test_inputB() {
        PlaceCommandInput commandInput = new PlaceCommandInput(CommandEnum.PLACE);
        commandInput.setPlace(new Place(new Point(0, 0), Face.NORTH));
        robot.execute(commandInput);
        assertValues(Face.NORTH, 0, 0);

        robot.execute(new CommandInput(CommandEnum.LEFT));
        assertValues(Face.WEST, 0, 0);

        robot.execute(new CommandInput(CommandEnum.REPORT));
        assertValues(Face.WEST, 0, 0);
    }

    @Test()
    public void test_inputC() {
        PlaceCommandInput commandInput = new PlaceCommandInput(CommandEnum.PLACE);
        commandInput.setPlace(new Place(new Point(1, 2), Face.EAST));
        robot.execute(commandInput);
        assertValues(Face.EAST, 1, 2);

        robot.execute(new CommandInput(CommandEnum.MOVE));
        assertValues(Face.EAST, 2, 2);

        robot.execute(new CommandInput(CommandEnum.MOVE));
        assertValues(Face.EAST, 3, 2);

        robot.execute(new CommandInput(CommandEnum.LEFT));
        assertValues(Face.NORTH, 3, 2);

        robot.execute(new CommandInput(CommandEnum.MOVE));
        assertValues(Face.NORTH, 3, 3);

        robot.execute(new CommandInput(CommandEnum.REPORT));
        assertValues(Face.NORTH, 3, 3);
    }

    private void assertValues(Face expectedFace, int expectedX, int expectedY) {
        assertThat(robot.getCurrent().getFace(), Is.is(expectedFace));
        assertThat("X position should be " + expectedX, robot.getCurrent().getPoint().getX(), Is.is(expectedX));
        assertThat("Y position should be " + expectedY, robot.getCurrent().getPoint().getY(), Is.is(expectedY));
    }
}