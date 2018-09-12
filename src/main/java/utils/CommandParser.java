package utils;

import enums.CommandEnum;
import enums.Face;
import model.CommandInput;
import model.Place;
import model.PlaceCommandInput;
import model.Point;

public class CommandParser {

    public static CommandInput parse(String line) {
        if (line.contains(CommandEnum.PLACE.toString())) {

            String[] strings = line.split(" ");
            String[] arguments = strings[1].split(",");

            int x = Integer.parseInt(arguments[0]);
            int y = Integer.parseInt(arguments[1]);
            Face face = Face.valueOf(arguments[2]);
            Place place = new Place(new Point(x, y), face);

            PlaceCommandInput command = new PlaceCommandInput(CommandEnum.PLACE);
            command.setPlace(place);

            return command;

        } else {
            CommandEnum commandEnum = CommandEnum.valueOf(line);
            return new CommandInput(commandEnum);
        }
    }
}
