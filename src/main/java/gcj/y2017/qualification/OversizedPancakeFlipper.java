package gcj.y2017.qualification;

import java.io.*;

public class OversizedPancakeFlipper {
	
	public static final String PROBLEM_LETTER = "A";

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
        // Parse input
        String[] tokens = reader.readLine().split(" ");
        String pancakesRow = tokens[0];
        int pancakeFlipperSize = Integer.parseInt(tokens[1]);
        // Solve test case
        int minFlips = minFlips(pancakesRow, pancakeFlipperSize);
        // Format result
        String result = (minFlips == -1) ? "IMPOSSIBLE" : Integer.toString(minFlips);
        return result;
    }
    
    public static int minFlips(String pancakesRow, int pancakeFlipperSize) {
    	int flips = 0;
    	for (int i = 0; i <= pancakesRow.length() - pancakeFlipperSize; i++) {
    		if (pancakesRow.charAt(i) == '-') {
    			pancakesRow = flip(pancakesRow, i, pancakeFlipperSize);
    			flips++;
    		}
    	}
    	return isAllHappySideUp(pancakesRow) ? flips : -1;
    }
    
    private static boolean isAllHappySideUp(String pancakesRow) {
    	return !pancakesRow.contains("-");
    }
    
    private static String flip(String pancakesRow, int startIndex, int pancakeFlipperSize) {
    	StringBuilder builder = new StringBuilder(pancakesRow.substring(0, startIndex));
    	int endIndex = startIndex + pancakeFlipperSize;
    	for (int i = startIndex; i < endIndex; i++) {
    		builder.append(pancakesRow.charAt(i) == '+' ? '-' : '+');
    	}
    	builder.append(pancakesRow.substring(endIndex, pancakesRow.length()));
    	return builder.toString();
    }
}
