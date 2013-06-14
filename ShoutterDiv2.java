// SRM 580.D2.V250
public class ShoutterDiv2 {

	static int count(int[] s, int[] t) {
		int length = s.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if ((s[i] <= t[j] && t[i] >= s[j]) || (s[j] <= t[i] && t[j] >= s[i]))
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count(new int[] { 1, 2, 4 }, new int[] { 3, 4, 6 }));
		System.out.println(count(new int[] {9,26,8,35,3,58,91,24,10,26,22,18,15,12,15,27,15,60,76,19,12,16,37,35,25,4,22,47,65,3,2,23,26,33,7,11,34,74,67,32,15,45,20,53,60,25,74,13,44,51}, 
								 new int[] {26,62,80,80,52,83,100,71,20,73,23,32,80,37,34,55,51,86,97,89,17,81,74,94,79,85,77,97,87,8,70,46,58,70,97,35,80,76,82,80,19,56,65,62,80,49,79,28,75,78}));
	}

}
