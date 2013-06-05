package SRM203.D2L2.V600;

import java.util.Arrays;

public class MatchMaking {

    @SuppressWarnings("rawtypes")
	public static class Person implements Comparable {
		String Name;
		String Answers;
		boolean active = true;

		public Person(String Name, String Answers) {
			this.Answers = Answers;
			this.Name = Name;
		}

		public int matchs(String a) {
			int count = 0;
			for (int i = 0; i < Answers.length(); i++) {
				if (Answers.charAt(i) == a.charAt(i))
					++count;
			}
			return count;
		}

		@Override
		public int compareTo(Object o) {
			Person man = (Person) o;
			return Name.compareTo(man.Name);
		}
	}

	public static String makeMatch(String[] namesWomen, String[] answersWomen,
			String[] namesMen, String[] answersMen, String queryWoman) {
		Person[] women = new Person[namesWomen.length];
		Person[] men = new Person[namesMen.length];
		for (int i = 0; i < namesWomen.length; ++i) {
			women[i] = new Person(namesWomen[i], answersWomen[i]);
			men[i] = new Person(namesMen[i], answersMen[i]);
		}
		Arrays.sort(women);
		Arrays.sort(men);

		int bestMan = -1;
		for (int i = 0; i < women.length; i++) {
			Person curWomen = women[i];
			int maxMatch = 0;
			for (int j = 0; j < men.length; j++) {
				if (!men[j].active)
					continue;

				int matchs = curWomen.matchs(men[j].Answers);
				if (matchs > maxMatch) {
					bestMan = j;
					maxMatch = matchs;
				}
			}
			men[bestMan].active = false;
			if (curWomen.Name.equals(queryWoman))
				return men[bestMan].Name;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(MatchMaking.makeMatch(
				new String[]{"Constance", "Bertha", "Alice"}, 
				new String[]{"aaba", "baab", "aaaa"}, 
				new String[]{"Chip", "Biff", "Abe"}, 
				new String[]{"bbaa", "baaa", "aaab"}, 
				"Bertha"));
		
		
		System.out.println(MatchMaking.makeMatch(
				new String [] {"i", "a", "d", "m", "g", "c", "n", "f", "b", "h", "k", "e", "j", "l"},
				new String [] {"babbabaaaabbbabbbbaaabaababb", "baaabbaabbbbbababbaababbbabb", "aabaaaaabbabbbababbbbabaaabb", "babbaaabbababbaaaaaaabbbaaaa", "abbbabbbaaaabbaabbaabbbbaaaa", "abaaabababbabbbbaabbbaaabbaa", "abbbaaaabbabbaaaaaaaababbbab", "ababbaaaabaababaaababababbaa", "abbbbaaabaabbabaaabbbaabaaab", "abaaabbbaaaabbabaaabbaabbbbb", "bbabaabbabbbabbabaaabbbabbbb", "bbabbabbbbabaababaabbbbbaaab", "aaababbaabaabbbbbabaabaaaaaa", "baaaaabbbaabbbbabababbbabbab"}, 
				new String [] {"g", "n", "a", "m", "e", "h", "l", "b", "k", "d", "f", "i", "j", "c"},
				new String [] {"bbbabbbbbaabaaabbbbbbaaaaaab", "aabbaaabbababbbaaababbbaaaba", "bbbabaabbabbbbbaaaaabaaababa", "bbaabbabaaababbbbababbaaabab", "baaaabbabaabbabbaaaabbabbaba", "abbaaabaabababbbabababababab", "baaaabaaaababbaaaabababababa", "bbaaaaaababbaaabbbbaaaabbabb", "aaababbaaabaabbaaaaabababaab", "baaaabaaabbbabbabaaaabbabaaa", "abbbaabaaabbbbbabbbaaababaaa", "bababbbabbaababbbbbbbabababa", "bbabbbaabbbbaaaaaaababababab", "baaabbbabaababababbaaaaabbaa"}, 
				"l"));
	}
}
