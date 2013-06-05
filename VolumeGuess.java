package SRM191.D1L1.V250;

import java.util.StringTokenizer;

public class VolumeGuess {

    public static int correctVolume(String[] queries, int numberOfBoxes,
            int ithBox) {
        int[] boxs = new int[numberOfBoxes];
        for (int i = 0; i < queries.length; i++) {
            StringTokenizer st = new StringTokenizer (queries[i], ",");
            int box1 = Integer.parseInt(st.nextToken());
            int box2 = Integer.parseInt(st.nextToken());
            int smallValue = Integer.parseInt(st.nextToken());
            boxs[box1-1] = Math.max(boxs[box1-1], smallValue);
            boxs[box2-1] = Math.max(boxs[box2-1], smallValue);
        }

        return boxs[ithBox-1];
    }

    public static void main(String[] args) {
        System.out.println(correctVolume(new String []     {"1,2,31", "1,3,9", "1,4,31", "2,4,32", "3,4,9", "3,2,9"}, 4, 1));
    }
}
