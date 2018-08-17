package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public abstract class Gcj {
	
	public abstract String getProblemLetter();
    
    public void solve(File inputFile, File outputFile) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                Writer writer = new BufferedWriter(new FileWriter(outputFile))) {
            solve(reader, writer);
        }
    }

    public void solve(BufferedReader reader, Writer writer) throws Exception {
        int testCasesCount = Integer.parseInt(reader.readLine());
        for (int t = 0; t < testCasesCount; t++) {
            String result = solveTestCase(reader, writer);
            writer.write(String.format("Case #%d: %s\n", (t + 1), result));
        }
        writer.flush();
    }
    
    public abstract String solveTestCase(BufferedReader reader, Writer writer) throws Exception;
}
