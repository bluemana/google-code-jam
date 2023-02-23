package gcj.y2017.qualification;

import java.io.*;

public class TidyNumbers {
	
	public static final String PROBLEM_LETTER = "B";

	public static void main(String[] args) throws Exception {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			solve(reader, writer);
		}
	}

	public static void solve(BufferedReader reader, Writer writer) throws Exception {
		int testCasesCount = Integer.parseInt(reader.readLine());
		for (int t = 0; t < testCasesCount; t++) {
			String result = solveTestCase(reader);
			writer.write(String.format("Case #%d: %s\n", (t + 1), result));
		}
		writer.flush();
	}

	private static String solveTestCase(BufferedReader reader) throws Exception {
		long n = Long.parseLong(reader.readLine());
		long result = biggestTidyNumber(n);
		return Long.toString(result);
	}
	
	private static long biggestTidyNumber(long n) {
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
