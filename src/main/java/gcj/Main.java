package gcj;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class Main {

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
}
