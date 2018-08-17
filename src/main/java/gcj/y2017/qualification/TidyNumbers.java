package gcj.y2017.qualification;

import java.io.BufferedReader;
import java.io.Writer;

import gcj.Gcj;

public class TidyNumbers extends Gcj {
	
	@Override
	public String getProblemLetter() {
		return "B";
	}

	@Override
	public String solveTestCase(BufferedReader reader, Writer writer) throws Exception {
		long n = Long.parseLong(reader.readLine());
		long result = biggestTidyNumber(n);
		return Long.toString(result);
	}
	
	public static long biggestTidyNumber(long n) {
		while (!isTidy(n)) {
			n = biggestTidyCandidate(n);
		}
		return n;
	}
	
	private static boolean isTidy(long n) {
		String nString = Long.toString(n);
		for (int i = 1; i < nString.length(); i++) {
			if (nString.charAt(i) < nString.charAt(i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	private static long biggestTidyCandidate(long n) {
		char[] nChars = Long.toString(n).toCharArray();
		for (int i = 1; i < nChars.length; i++) {
			if (nChars[i] < nChars[i - 1]) {
				for (int j = i; j < nChars.length; j++) {
					nChars[j] = '0';
				}
				break;
			}
		}
		return Long.parseLong(new String(nChars)) - 1;
	}
}
