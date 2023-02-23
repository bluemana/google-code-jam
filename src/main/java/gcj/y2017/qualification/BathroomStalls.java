package gcj.y2017.qualification;

import java.io.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BathroomStalls {
	
	public static final String PROBLEM_LETTER = "C";

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
		String[] tokens = reader.readLine().split(" ");
		long n = Long.parseLong(tokens[0]);
		long k = Long.parseLong(tokens[1]);
		long[] lastStallDistances = lastStallDistances(n, k);
		return Long.toString(lastStallDistances[0]) + " " + Long.toString(lastStallDistances[1]);
	}
	
	public static long[] lastStallDistances(long n, long k) {
		SortedMap<Long, Long> sections = new TreeMap<>();
		sections.put(n, 1L);
		long maxDistance = -1;
		long minDistance = -1;
		while (k > 0) {
			long length = sections.lastKey();
			long count = sections.remove(length);
			maxDistance = length / 2;
			minDistance = (length - 1) / 2;
			k -= count;
			updateMap(sections, maxDistance, count);
			updateMap(sections, minDistance, count);
		}
		return new long[] {maxDistance, minDistance};
	}
	
	private static void updateMap(Map<Long, Long> map, long length, long count) {
		Long oldCount = map.get(length);
		if (oldCount != null) {
			count += oldCount;
		}
		map.put(length, count);
	}
}
