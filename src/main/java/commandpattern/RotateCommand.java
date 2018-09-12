package commandpattern;

import enums.Face;
import model.RotateFace;

import java.util.EnumMap;

public abstract class RotateCommand implements Command {
    private EnumMap<Face, RotateFace> rotateTable;
    protected RotateCommand(){
        rotateTable = new EnumMap<Face, RotateFace>(Face.class);
        rotateTable.put(Face.NORTH, new RotateFace(Face.WEST, Face.EAST));
        rotateTable.put(Face.SOUTH, new RotateFace(Face.EAST, Face.WEST));
        rotateTable.put(Face.WEST, new RotateFace(Face.SOUTH, Face.NORTH));
        rotateTable.put(Face.EAST, new RotateFace(Face.NORTH, Face.SOUTH));
    }

    protected EnumMap<Face, RotateFace> getRotateTable(){
        return rotateTable;
    }
}
