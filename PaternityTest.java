package SRM.DIL1.V1000;

public class PaternityTest {
	public static int[] possibleFathers(String child, String mother,
			String[] men) {
		int DNALength = child.length();
		int[] retInt = new int[men.length];
		boolean[] mustfromFarther = new boolean[DNALength];

		for (int i = 0; i < DNALength; i++) {
			if (child.charAt(i) != mother.charAt(i))
				mustfromFarther[i] = true;
		}

		int fathers = 0;
		for (int i = 0; i < men.length; ++i) {
			int matchNum = 0;
			boolean Possible = true;
			for (int k = 0; k < men[i].length(); k++) {
				if (child.charAt(k) == men[i].charAt(k))
					matchNum++;
				if (mustfromFarther[k] && child.charAt(k) != men[i].charAt(k)) {
					Possible = false;
					break;
				}
			}
			if (matchNum >= men[i].length() / 2 && Possible) {
				retInt[fathers++] = i;
			}

		}
		int[] rr = new int[fathers];
		for (int i = 0; i < fathers; i++)
			rr[i] = retInt[i];
		return rr;
	}

	public static void main(String[] args) {
		//int[] retInt = possibleFathers(	"YDHXMKFWTYWSPGTVDBYG", "ODHXJTFWTHWDPGLSZBEX", new String []{"YMHXMKFHTYOSRGTVDBYG", "YDHSMKQDTYWSOGTVDBYG", "YPHAMKDWOYWSPGTVDUYG", "YDHMMKMWTYJSPXTVDJYG", "YDVXMKZUOYCSPMTVDBYG"});
		
		int[] retInt = possibleFathers("WXETPYCHUWSQEMKKYNVP", "AXQTUQVAUOSQEEKCYNVP", new String []{"WNELPYCHXWXPCMNKDDXD", "WFEEPYCHFWDNPMKKALIW", "WSEFPYCHEWEFGMPKIQCK", "WAEXPYCHAWEQXMSKYARN", "WKEXPYCHYWLLFMGKKFBB"});
		for (int x : retInt)
			System.out.println(x);
	}
}
