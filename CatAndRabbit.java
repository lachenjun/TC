//SRM558.D2.V900
public class CatAndRabbit {
	public String getWinner(String tiles) {
		int whiteLength = 0;
		int result = 0;
		boolean continuous = true;
		for (int i = 0; i < tiles.length(); i++) {
			if (tiles.charAt(i) == '.')
				whiteLength ++;
			else {
				continuous = false;
				result ^= whiteLength;
				whiteLength = 0;
			}
		}
		if (continuous) return "Rabbit";
		return result == whiteLength ? "Rabbit" : "Cat";
	}
}
