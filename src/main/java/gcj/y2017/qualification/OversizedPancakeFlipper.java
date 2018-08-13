package gcj.y2017.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class OversizedPancakeFlipper {

    public static void main(String[] args) throws Exception {
    	File inputFile = null;
    	File outputFile = null;
    	for (int i = 0; i < args.length; i++) {
    		String arg = args[i];
    		if (arg.startsWith("-i=")) {
    			inputFile = new File(arg.substring(3));
    		} else if (arg.startsWith("-o=")) {
    			outputFile = new File(arg.substring(3));
    		}
    	}
    	solve(inputFile, outputFile);
    }
    
    public static void solve(File inputFile, File outputFile) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                Writer writer = new BufferedWriter(new FileWriter(outputFile))) {
            solve(reader, writer);
        }
    }

    public static void solve(BufferedReader reader, Writer writer) throws Exception {
        int testCasesCount = Integer.parseInt(reader.readLine());
        for (int t = 0; t < testCasesCount; t++) {
            String result = solveTestCase(reader, writer);
            writer.write(String.format("Case #%d: %s\n", (t + 1), result));
        }
        writer.flush();
    }

    private static String solveTestCase(BufferedReader reader, Writer writer) throws Exception {
        // Parse input
        String[] tokens = reader.readLine().split(" ");
        String pancakesRow = tokens[0];
        int pancakeFlipperSize = Integer.parseInt(tokens[1]);
        // Solve test case
        int minFlips = minFlips(pancakesRow, pancakeFlipperSize);
        // Format result
        String result = (minFlips == -1) ? "IMPOSSIBLE" : "" + minFlips;
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
    
    private static String flip(String pancakesRow, int idx, int pancakeFlipperSize) {
    	StringBuilder builder = new StringBuilder(pancakesRow.substring(0, idx));
    	for (int i = idx; i < idx + pancakeFlipperSize; i++) {
    		builder.append(pancakesRow.charAt(i) == '+' ? '-' : '+');
    	}
    	if (idx + pancakeFlipperSize < pancakesRow.length()) {
    		builder.append(pancakesRow.substring(idx + pancakeFlipperSize, pancakesRow.length()));
    	}
    	return builder.toString();
    }
}
