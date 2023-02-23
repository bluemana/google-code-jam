package gcj.y2017.qualification;

import gcj.Gcj;
import gcj.GcjTest;

import java.io.BufferedReader;
import java.io.Writer;

public class OversizedPancakeFlipperTest extends GcjTest {

	@Override
	public Gcj createGcjInstance() {
		return new Gcj() {

			public String getProblemLetter() {
				return OversizedPancakeFlipper.PROBLEM_LETTER;
			}

			public void solve(BufferedReader reader, Writer writer) throws Exception {
				OversizedPancakeFlipper.solve(reader, writer);
			}
		};
	}
}