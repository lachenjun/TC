import java.util.Arrays;

// SRM581.D1.V250;
public class SurveillanceSystem {

	public static String getContainerInfo(String containers, int[] reports,
			int L) {
		int[] countFromBegining = new int[containers.length() - L + 1];
		for (int i = 0; i < containers.length() - L + 1; i++) {
			for (int j = 0; j < L; j++) {
				if (containers.charAt(i + j) == 'X')
					countFromBegining[i]++;
			}
		}

		char[] answer = new char[containers.length()];
		Arrays.fill(answer, '-');

		int[] requestsCount = new int[L + 1];
		for (int i : reports)
			requestsCount[i]++;
		
		for (int i = 0; i <= L; i++) {
			
			if (requestsCount[i] == 0)
				continue;
			
			int[] actualCount = new int[containers.length()];
			int possibleCountOfi = 0;
			for (int j = 0; j < containers.length() - L + 1; j++) {
				if (countFromBegining[j] == i) {
					for (int k = 0; k < L; k++)
						actualCount[j + k]++;
					possibleCountOfi++;
				}
			}

			for (int j = 0; j < containers.length(); j++) {
				if (actualCount[j] + requestsCount[i] >= 1 + possibleCountOfi)
					answer[j] = '+';
				else if (actualCount[j] > 0 && answer[j] == '-')
					answer[j] = '?';
			}
		}

		return new String(answer);
	}

	public static void main(String[] args) {
		System.out.println("??++++".equals(getContainerInfo("-X--XX", new int[] { 1, 2 }, 3)));
		System.out.println("++++++++++?".equals(getContainerInfo("------X-XX-", new int [] {3, 0, 2, 0}, 5)));
		System.out.println("???++++?++++++++++++++++++++??????--".equals(getContainerInfo("-XX--X-XX-X-X--X---XX-X---XXXX-----X", new int [] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 7)));
	}

}