package model;

import enums.CommandEnum;
public class PlaceCommandInput extends CommandInput {
    private Place place;

    public PlaceCommandInput(CommandEnum command) {
        super(command);
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}