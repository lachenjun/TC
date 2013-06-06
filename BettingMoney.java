// SRM191.D2.V250;

public class BettingMoney {

    public static int moneyMade(int[] amounts, int[] centsPerDollar,
            int finalResult) {
        int gain = 0;
        for (int i = 0; i < amounts.length; i++) {
            if (i == finalResult)
                gain -= amounts[i] * centsPerDollar[i];
            else
                gain += amounts[i] * 100;
        }
        return gain;
    }

    public static void main(String[] args) {
        System.out.println(moneyMade(
                new int[] { 5000, 5000 }, 
                new int[] { 100,2 }, 0));
    }
}
