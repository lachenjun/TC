public class TinSoldiers {

	static long fact(int n) {
		long result = 1;
		while (n > 1) {
			result *= n;
			n--;
		}
		return result;
	}

	public static int lineUps(int[] a) {
		int count = 0;
		int oddcount = 0;
		for (int i = 0; i < a.length; i++) {
			count += a[i];
			oddcount += a[i] % 2;
		}
		long X = fact(count);
		for (int i = 0; i < a.length; i++){
			X /= fact(a[i]);
		}

		long x = 0;
		if (oddcount <= 1) {
			x = fact(count / 2);
			for (int i = 0; i < a.length; i++)
				x /= fact(a[i] / 2);
		}

		return (int) (X + x) / 2;
	}

	public static void main(String[] args) {
		System.out.println(lineUps(new int [] {2, 2, 1}));
		System.out.println(lineUps(new int [] {5, 1, 1, 1}));
		System.out.println(lineUps(new int [] {4, 2, 2, 5, 4}));
		System.out.println(lineUps(new int [] {4, 3, 3}));
		System.out.println(lineUps(new int [] {5, 2, 2, 4}));
	}
}
