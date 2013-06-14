import java.io.ObjectInputStream.GetField;

import javax.xml.transform.Templates;

//SRM558.D1.V275
public class Stamp {
	public int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		int len = desiredColor.length();
		int mincost = stampCost + pushCost * len;

		for (int step = 3; step <= len; step++) {
			int[] costs = new int[len];
			costs[0] = 1;
			for (int j = 1; j < costs.length; j++) {
				costs[j] = 50;
			}

			for (int i = 0; i < step; i++) {
				for (int j = i + 1; j < step; j++) {
					if (!sameColor(desiredColor, i, j))
						break;
				}
			}

			for (int i = 0; i < step; i++) {
				costs[i] = 1;
			}

			for (int i = step; i < costs.length; i++) {
				for (int j = 1; j <= step; j++) {
					if (i >= j && sameColor(desiredColor, i, i - j))
						costs[i] = Math.min(costs[i - j] + 1, costs[i]);
					else
						break;
				}
				if (costs[i] == 50)
					break;
			}
		}

		return mincost;
	}

	private boolean sameColor(String desiredColor, int i, int j) {
		return desiredColor.charAt(i) == desiredColor.charAt(j)
				|| desiredColor.charAt(i) == '*'
				|| desiredColor.charAt(j) == '*';
	}

}
