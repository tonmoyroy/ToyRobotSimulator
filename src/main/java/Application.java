import model.CommandInput;
import simulator.ToyRobotImpl;
import utils.CommandParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        ToyRobotImpl toyRobot = new ToyRobotImpl();
        while ((line = br.readLine()) != null) {
            CommandInput commandInput = CommandParser.parse(line);
            toyRobot.execute(commandInput);
        }
    }
}
