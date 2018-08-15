package gcj.y2017.qualification;

import java.io.BufferedReader;
import java.io.Writer;

import gcj.Gcj;

public class OversizedPancakeFlipper extends Gcj {

	@Override
    public String solveTestCase(BufferedReader reader, Writer writer) throws Exception {
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
