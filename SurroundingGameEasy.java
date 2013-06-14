//SRM558.D2.V250
public class SurroundingGameEasy {
	public int score(String[] cost, String[] benefit, String[] stone) {
		int count = stone.length;
		int width = stone[0].length();
		int sum = 0;

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < width; j++) {
				boolean dom1 = stone[i].charAt(j) == 'o';
				if (dom1)
					sum -= cost[i].charAt(j) - '0';

				boolean dom2 = ((i == 0 || stone[i - 1].charAt(j) == 'o')
						&& (i == count-1 || stone[i + 1].charAt(j) == 'o')
						&& (j == 0 || stone[i].charAt(j - 1) == 'o') 
						&& (j == width-1 || stone[i].charAt(j + 1) == 'o'));
				if (dom1 || dom2)
					sum += benefit[i].charAt(j) - '0';

			}
		}
		return sum;
	}
}
