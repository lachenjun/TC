//srm555.D1.V255
import java.util.Arrays;
import java.util.TreeSet;

public class CuttingBitString
{
	public int getmin(String S)
	{
		TreeSet<String> powers = new TreeSet<String>();
		long init = 1;
		String intString = "1";
		while (intString.length() <= 50){
			intString = Long.toBinaryString(init);
			powers.add(intString);
			init *= 5;	
		}
		int len = S.length();
		int [] mins = new int [len]; 
		Arrays.fill(mins, Integer.MAX_VALUE/2);
		
		for (int i = 0; i < len; i++){
			if (powers.contains(S.substring(0, i+1)))
				mins[i] = 1;
			else {
				for (int j = 0; j < i; j++) {
					if (powers.contains(S.substring(j+1, i+1)))
						mins [i] = Math.min(mins[j]+1, mins[i]);
				}
			}
		}
		
		return mins[len-1] == Integer.MAX_VALUE/2 ? -1 : mins[len-1];
	}

}