package commandpattern;

import enums.Face;
import interfaces.Robot;
import model.Place;
import model.Point;
import org.hamcrest.core.Is;
import org.junit.Test;
import simulator.ToyRobotImpl;

import static org.junit.Assert.assertThat;

public class MoveCommandTest {

    @Test
    public void test_when_move_to_valid_east() {
        Robot robot = new ToyRobotImpl();
        robot.setCurrent(new Place(new Point(0,0), Face.EAST));

        Command command = new MoveCommand(robot);
        command.execute();
        assertThat(robot.getCurrent().getFace(), Is.is(Face.EAST));
        assertThat("X position should be 1", robot.getCurrent().getPoint().getX(), Is.is(1));
        assertThat("Y position should be 0", robot.getCurrent().getPoint().getY(), Is.is(0));
    }

    @Test
    public void test_when_move_to_invalid_west() {
        Robot robot = new ToyRobotImpl();
        robot.setCurrent(new Place(new Point(0,0), Face.WEST));

        Command command = new MoveCommand(robot);
        command.execute();
        assertThat(robot.getCurrent().getFace(), Is.is(Face.WEST));
        assertThat("X position should be 0",robot.getCurrent().getPoint().getX(), Is.is(0));
        assertThat("Y position should be 0", robot.getCurrent().getPoint().getY(), Is.is(0));
    }
}