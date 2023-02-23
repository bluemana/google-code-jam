package gcj;

import java.io.BufferedReader;
import java.io.Writer;

public interface Gcj {

    String getProblemLetter();

    void solve(BufferedReader reader, Writer writer) throws Exception;
}
