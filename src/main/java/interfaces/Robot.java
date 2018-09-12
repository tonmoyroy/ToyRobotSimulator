package interfaces;

import model.Place;

public interface Robot {
    Place getCurrent();
    void setCurrent(Place current);
}
