package SRM155.D1L2.V450;

public class QuipuReader {
    public static int[] readKnots(String[] knots) {
        int[] retInt = new int[knots.length];

        int knotsLength = knots[0].length();
        boolean[] isDigitalArea = new boolean[knotsLength];
        for (int j = 0; j < knotsLength; j++) {
            isDigitalArea[j] = false;
            for (int i = 0; i < knots.length; i++) {
                if (knots[i].charAt(j) == 'X') {
                    isDigitalArea[j] = true;
                    break;
                }
            }
        }

        boolean [] needCarry = new boolean [knotsLength];
        for (int j = 0; j < knotsLength; j++) {
            for (int i = 0; i < knots.length; i++) {
                if (isDigitalArea[j]) {
                    int change = 0;
                    if (knots[i].charAt(j) == 'X')
                        change = 1;
                    if (needCarry[i]) {
                        retInt[i] = retInt[i] * 10 + change;
                    } else {
                        retInt[i] += change;
                    }
                    needCarry[i] = false;
                } else
                    needCarry[i] = true;
            }
        }
        return retInt;
    }

    public static void main(String[] args) {
        int[] retInt = readKnots(new String[] { "--XXX-XXXXXXXX----------XXXXXXXXX--XXXXXXXX-",
                  "--XX----XXXX-----XXXXXX---XXX------XXXXXXXX-",
                  "--------------------X----XXXXXXXX--XXXXXXXX-",
                  "--XX-------X------XXXX----XXX-------XXXXXX--",
                  "--XXX---XXXXX-------X------XX--------X------",
                  "-XXXX--XXXXXXX-----------XXXXXXX----XXXXX---",
                  "-----------X---XXXXXXXX----XX--------XXX----",
                  "-----------X---XXXXXXXX----X----------------",
                  "---X--XXXXXXXX--XXXXXXX---XXX---------------",
                  "--XX---XXXXXXX--XXXXXXX----XX-------XXXXX---"  }
);
        for (int x : retInt)
            System.out.println(x);
    }
}
