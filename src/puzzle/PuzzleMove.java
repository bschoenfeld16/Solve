/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import framework.Move;
import framework.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import puzzle.PuzzleMove.Coordinates;

/**
 *
 * @author Schoen
 */
public class PuzzleMove extends Move {

    public PuzzleMove(String moveName) {
        super(moveName);

        List list1 = new ArrayList<Coordinates>();
        //frist row
        m.put(new Coordinates(0, 0), list1);
        list1.add(new Coordinates(1, 0));
        list1.add(new Coordinates(0, 1));

        List list2 = new ArrayList<Coordinates>();
        //second row
        m.put(new Coordinates(0, 1), list2);
        list2.add(new Coordinates(0, 0));
        list2.add(new Coordinates(0, 2));
        list2.add(new Coordinates(1, 1));

        //third row
        List list3 = new ArrayList<Coordinates>();
        m.put(new Coordinates(0, 2), list3);
        list3.add(new Coordinates(0, 1));
        list3.add(new Coordinates(1, 2));

        //fourth row
        List list4 = new ArrayList<Coordinates>();
        m.put(new Coordinates(1, 0), list4);
        list4.add(new Coordinates(0, 0));
        list4.add(new Coordinates(2, 0));
        list4.add(new Coordinates(1, 1));

        //fifth row
        List list5 = new ArrayList<Coordinates>();
        m.put(new Coordinates(1, 1), list5);
        list5.add(new Coordinates(0, 1));
        list5.add(new Coordinates(2, 1));
        list5.add(new Coordinates(1, 2));
        list5.add(new Coordinates(1, 0));

        //sixth row
        List list6 = new ArrayList<Coordinates>();
        m.put(new Coordinates(1, 2), list6);
        list6.add(new Coordinates(0, 2));
        list6.add(new Coordinates(2, 2));
        list6.add(new Coordinates(1, 1));

        //seventh row
        List list7 = new ArrayList<Coordinates>();
        m.put(new Coordinates(2, 0), list7);
        list7.add(new Coordinates(1, 0));
        list7.add(new Coordinates(2, 1));

        //eigth row
        List list8 = new ArrayList<Coordinates>();
        m.put(new Coordinates(2, 1), list8);
        list8.add(new Coordinates(2, 2));
        list8.add(new Coordinates(2, 0));
        list8.add(new Coordinates(1, 1));

        //ninth row
        List list9 = new ArrayList<Coordinates>();
        m.put(new Coordinates(2, 2), list9);
        list9.add(new Coordinates(1, 2));
        list9.add(new Coordinates(2, 1));

    }

    @Override
    public State doMove(State otherState) {
        if (otherState instanceof PuzzleState) {
            PuzzleState oldState = (PuzzleState) otherState;
            PuzzleState newState = null;
            String stringTileNumber = getMoveName();
            int tileNumber;
            tileNumber = Integer.parseInt(stringTileNumber.substring(stringTileNumber.length() - 1));
            Coordinates tileToBeMovedCoordinates = new Coordinates();
            Coordinates blankCoordinates = new Coordinates();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int tile = oldState.getTile(i, j);
                    if (tile == tileNumber) {
                        tileToBeMovedCoordinates.i = i;
                        tileToBeMovedCoordinates.j = j;
                    } else if (tile == 0) {
                        blankCoordinates.i = i;
                        blankCoordinates.j = j;
                    }

                }
            }

            if (isMoveLegal(blankCoordinates, tileToBeMovedCoordinates)) {
                newState = new PuzzleState(oldState);
                newState.setTile(0, tileToBeMovedCoordinates);
                newState.setTile(tileNumber, blankCoordinates);

                return newState;

            }

        }
        return null;
    }

    public boolean isMoveLegal(Coordinates blankCoordinates, Coordinates tileToBeMovedCoordinates) {
        //TODO: exit loop when both are found       
        List<Coordinates> legalMoveLocations = m.get(blankCoordinates);

        return legalMoveLocations.contains(tileToBeMovedCoordinates);

    }

    class Coordinates {

        int i, j;

        Coordinates() {

        }

        Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return i + j;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Coordinates)) {
                return false;
            } else {
                return this.i == ((Coordinates) object).i && this.j == ((Coordinates) object).j;
            }
        }

    }

    Map<Coordinates, List<Coordinates>> m = new HashMap<Coordinates, List<Coordinates>>();

}
