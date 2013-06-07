public class EelAndRabbit {

	public static int getmax(int[] l, int[] t) {
		int count = l.length;
		int res = 0;
		if (count <= 2)
			return count;
		for (int i = 0; i < count; i++) {
			for (int j = i+1; j < count; j++) {
				int test1 = t[i];
				int test2 = t[j];
				int tempcount = 0;
				for (int k = 0; k < count; k++) {
					if (test1 >= t[k] && test1 <= t[k] + l[k] || 
						test2 >= t[k] && test2 <= t[k] + l[k])
						tempcount ++;
				}
				if (tempcount > res)
					res = tempcount;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(getmax(
				new int [] {50, 51, 8,  41, 53, 34, 67, 59, 42, 64, 52, 20, 39, 71, 17, 59, 32, 65, 9, 49, 20, 72, 70}, 
				new int []{40,  52, 32, 0,  61, 55, 59, 42, 55, 61, 55, 23, 35, 22, 11, 22, 52, 65, 5, 28, 56, 6, 15}));
	//                  -     -  -   -    -  -    -   -  -   -   -   -   -   -        -   -         -    -  -   -                                                 
		//System.out.println(getmax(
		//		new int [] {2, 4, 3, 2, 2, 1, 10},
		//		new int [] {2, 6, 3, 7, 0, 2, 0}));
	}
}
