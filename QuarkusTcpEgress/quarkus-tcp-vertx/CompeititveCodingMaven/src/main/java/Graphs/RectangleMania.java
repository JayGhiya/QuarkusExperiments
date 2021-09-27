package Graphs;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Graphs.RectangleMania.getCoordString;

//How many rectangles can be formed with given set of cartesian coordinates
public class RectangleMania {

    public static String Up = "UP";
    public static String Down = "DOWN";
    public static String Left = "LEFT";
    public static String Right = "RIGHT";


    public static int rectangleMania(Point[] coords) {
        //get the coordinate table
        Map<String, Map<String, List<Point>>> coordTable = getCoordinateMap(coords);

        return getRectangleCount(coords, coordTable);
    }

    public static int getRectangleCount(Point[] coords, Map<String, Map<String, List<Point>>> coordTable) {
        //assume every point is bottom left and traverse clockwise direction from it to find out rectangle
        int rectangeleCount = 0;
        for (Point coord1 : coords) {
            //get the map key
            rectangeleCount += clockwiseparseCoord(coord1, coordTable, "UP", coord1);

        }
        return rectangeleCount;
    }

    public static int clockwiseparseCoord(Point currentCoord1, Map<String, Map<String, List<Point>>> coordtable, String direction, Point sourceCoord) {

        String coordToString =getCoordString(currentCoord1);

        if (direction.equals("LEFT")) {
            //end of clockwise loop
            //check if cuurentCoord in left has sourceCoord

            if (coordtable.containsKey(coordToString) && coordtable.get(coordToString).containsKey("LEFT") && coordtable.get(coordToString).get("LEFT").contains(sourceCoord)) {
                return 1;
            } else {
                return 0;
            }

        }

        int rectangleCount = 0;
        String nextDirection = getNextDirection(direction);
        for(Point coord2 : coordtable.get(currentCoord1).get(direction))
        {
            rectangleCount+=clockwiseparseCoord(coord2,coordtable,nextDirection,sourceCoord);
        }
        return rectangleCount;
    }

    public static String getNextDirection(String direction)
    {
        if(direction.equals(Up))
        {
            return Right;
        }
        else if(direction.equals(Right))
        {
            return Down;
        }
        else if(direction.equals(Down))
        {
            return Left;
        }
        return  "";
    }

    public static Map<String, Map<String, List<Point>>> getCoordinateMap(Point[] coords) {
        Map<String, Map<String, List<Point>>> coordTable = new HashMap<>();

        for (Point coord1 : coords) {
            Map<String, List<Point>> coordDirectionTable = new HashMap<>();

            coordDirectionTable.put(Up, new ArrayList());

            coordDirectionTable.put(Down, new ArrayList());

            coordDirectionTable.put(Left, new ArrayList());

            coordDirectionTable.put(Right, new ArrayList());

            for (Point coord2 : coords) {
                //now get the direction of current coordinate
                String currentDirection = getCurrentDirection(coord1, coord2);
                if (coordDirectionTable.containsKey(currentDirection)) {
                    //add it to the map
                    coordDirectionTable.get(currentDirection).add(coord2);
                }
            }
            //then populate the main map
            //get the string version of current coordinate
            String coordString = getCoordString(coord1);
            coordTable.put(coordString, coordDirectionTable);
        }

        return coordTable;
    }

    public static String getCoordString(Point coord) {
        return Integer.toString(coord.x) + "-" + Integer.toString(coord.y);
    }

    public static String getCurrentDirection(Point source, Point target) {
        //find for the source point where does the point fall in
        if (source.y == target.y) {
            if (source.x > target.x) {
                return "RIGHT";
            } else if (source.x < target.x) {
                return "LEFT";
            }
        } else if (source.x == target.x) {
            if (source.y > target.y) {
                return "DOWN";
            } else if (source.y < target.y) {
                return "UP";
            }
        }
        return "";

    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
