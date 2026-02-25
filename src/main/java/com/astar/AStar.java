package com.astar;

import java.awt.*;
import java.util.ArrayList;

//By: Brandon Beckwith
class AStar {

    // NOTE: This is the only class you need to edit.
    //Feel free to add whatever methods you need here!

    /**
     * Runs A star on the given board
     * @param board The board to run A Star on
     * @param start The starting Point
     * @param end The ending Point
     * @return The spaces in order from the start Point to the end Point
     */
    public static ArrayList<Space> findPath(Board board, Point start, Point end) {

        //Setup an ArrayList to hold the path to  return to the GUI
        ArrayList<Space> path = new ArrayList<Space>();

        // TODO: Implement AStar
        //Space goal = board.getSpace(end.x, end.y);
        Space current = board.getSpace(start);
        current.setG(0);
        while (current.getType() != SpaceType.END) {
            for (Space s : board.getNeighbors(current)) {
                if (s.getType() != SpaceType.BLOCK) {
                    int g = current.getG() + 1;
                    
                    
                }
            }
        }

        return path;
    }
}
