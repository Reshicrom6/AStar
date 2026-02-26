package com.astar;

import java.awt.*;
import java.util.*;

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
        Space startSpace = board.getSpace(start);
        Space endSpace = board.getSpace(end);

        startSpace.setG(0);
        startSpace.setH(manhattan(startSpace, endSpace));

        PriorityQueue<Space> frontier = new PriorityQueue<>(); 
        frontier.add(startSpace);

        Set<Space> explored = new HashSet<>();

        Space current = null;

        while (!frontier.isEmpty()) {
            current = frontier.poll();

            if (current.getPoint().equals(end)) break;

            if (explored.contains(current)) continue;
            explored.add(current);

            for (Space neighbor : board.getNeighbors(current)) {
                if (explored.contains(neighbor)) continue;

                int g = current.getG() + 1;

                if (neighbor.getG() == 0 || g < neighbor.getG()) {
                    neighbor.setG(g);
                    neighbor.setH((manhattan(neighbor, endSpace)));
                    neighbor.setPrevious(current);

                    frontier.add(neighbor);
                }
            }
        }

        if (current != null && current.getPoint().equals(end)) {
            Space node = current;
            while (node != null) {
                path.add(0, node);
                node = node.getPrevious();
            }
        }

        path.getLast().setType(SpaceType.END);
        return path;
    }

    private static int manhattan(Space from, Space to) {
        return Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY());
    }
}
