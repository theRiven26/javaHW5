//4*. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer[][]> mapArrays = new HashMap<>();
        Map<Integer, Integer[]> mapCoordinates = new HashMap<>();
        Integer[][] desk = new Integer[8][8];
        Integer[] arrCoordinates = new Integer[2];
        int count = 8;
        int countQueen = 1;
        StartCreateArray(desk);
        PrintArray(desk);
        int startI = 0;
        int startJ = 0;
        while (countQueen <= count) {
            mapArrays.put(countQueen, ArrayCopy(desk));
            if (AddQueenOnDesk(desk, arrCoordinates, countQueen, startI, startJ)) {
                mapCoordinates.put(countQueen, arrCoordinates.clone());
                countQueen++;
                startI++;
                startJ = 0;
            } else {
                countQueen--;
                desk = mapArrays.get(countQueen);
                startI = mapCoordinates.get(countQueen)[0];
                startJ = mapCoordinates.get(countQueen)[1] + 1;
            }
            ;
            PrintArray(desk);
        }
        CoordinatesToArray(mapCoordinates);
    }

    public static void CoordinatesToArray(Map<Integer, Integer[]> mapCoordinates) {
        Integer[][] newArray = new Integer[mapCoordinates.size()][mapCoordinates.size()];
        StartCreateArray(newArray);
        for (Map.Entry entry : mapCoordinates.entrySet()) {
            Integer[] arrValues = (Integer[]) entry.getValue();
            newArray[arrValues[0]][arrValues[1]] = (Integer) entry.getKey();
        }
        PrintArray(newArray);
    }

    public static void StartCreateArray(Integer[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    public static boolean AddQueenOnDesk(Integer[][] array, Integer[] arrCoordinates, int countQueen, int startI, int startJ) {

        for (int j = startJ; j < array[1].length; j++) {
            if (array[startI][j] == 0) {
                WayQueen(array, startI, j, countQueen);
                arrCoordinates[0] = startI;
                arrCoordinates[1] = j;
                return true;
            }

        }
        return false;
    }

    public static void PrintArray(Integer[][] array) {
        System.out.println();
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                if (array[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(array[i][j]);
                }

                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void WayQueen(Integer[][] array, int x, int y, int numQueen) {
        int diagX = 0;
        int diagY = 0;
        for (int j = 0; j < array[1].length; j++) {
            array[x][j] = numQueen;
        }
        for (int i = 0; i < array[0].length; i++) {
            array[i][y] = numQueen;
        }
        diagX = x;
        diagY = y;
        for (int k = x; k < array[0].length; k++) {
            if (diagX + 1 < array[0].length && diagY + 1 < array[0].length) {
                diagX = diagX + 1;
                diagY = diagY + 1;
            }
            array[diagX][diagY] = numQueen;
        }
        diagX = x;
        diagY = y;
        for (int k = x; k < array[0].length; k++) {
            if (diagX - 1 >= 0 && diagY - 1 >= 0) {
                diagX = diagX - 1;
                diagY = diagY - 1;
            }
            array[diagX][diagY] = numQueen;
        }
        diagX = x;
        diagY = y;
        for (int k = x; k < array[0].length; k++) {
            if (diagX + 1 < array[0].length && diagY - 1 >= 0) {

                diagX = diagX + 1;
                diagY = diagY - 1;
            }

            array[diagX][diagY] = numQueen;
        }
        diagX = x;
        diagY = y;
        for (int k = x; k < array[0].length; k++) {
            if (diagX - 1 >= 0 && diagY + 1 < array[0].length) {

                diagX = diagX - 1;
                diagY = diagY + 1;
            }

            array[diagX][diagY] = numQueen;
        }
    }

    public static Integer[][] ArrayCopy(Integer[][] array) {
        Integer[][] newArray = new Integer[array[0].length][array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }


}