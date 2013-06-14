//SRM 549.D2.V250
public class BallAndHats {
	public int getHat(String hats, int numSwaps) {
		int index = hats.indexOf('o');
		if (numSwaps == 0)
			return index;

		if (index == 1) {
			return numSwaps % 2 == 1 ? 0 : 1;
		} else {
			return numSwaps % 2 == 1 ? 1 : 0;
		}
	}
}
