package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public abstract class Gcj {
	
	private static final Map<String, Class<? extends Gcj>> SIMPLE_NAME_TO_CLASS_MAP;
	
	static {
    	Reflections reflections = new Reflections(Gcj.class.getPackageName());
    	Set<Class<? extends Gcj>> gcjSubtypes = reflections.getSubTypesOf(Gcj.class);
    	SIMPLE_NAME_TO_CLASS_MAP = new HashMap<>();
    	for (Class<? extends Gcj> c : gcjSubtypes) {
    		SIMPLE_NAME_TO_CLASS_MAP.put(c.getSimpleName(), c);
    	}
	}
	
    public static void main(String[] args) throws Exception {
    	String problemTitle = null;
    	File inputFile = null;
    	File outputFile = null;
    	for (int i = 0; i < args.length; i++) {
    		String arg = args[i];
    		if (arg.startsWith("-p=")) {
    			problemTitle = arg.substring(3);
    		}
    		if (arg.startsWith("-i=")) {
    			inputFile = new File(arg.substring(3));
    		} else if (arg.startsWith("-o=")) {
    			outputFile = new File(arg.substring(3));
    		}
    	}
    	Gcj gcj = (Gcj) Class
    		.forName(SIMPLE_NAME_TO_CLASS_MAP.get(problemTitle).getCanonicalName())
    		.getConstructor().newInstance();
    	gcj.solve(inputFile, outputFile);
    }
    
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
