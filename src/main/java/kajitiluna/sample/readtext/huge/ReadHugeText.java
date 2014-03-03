package kajitiluna.sample.readtext.huge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReadHugeText {

    protected static final int READ_STEP = 100;

    public void execute(String filePath) throws IOException {
        BufferedReader bufReader = null;
        try {
            File file = new File(filePath);
            FileReader reader = new FileReader(file);
            bufReader = new BufferedReader(reader);

            boolean eof = false;

            System.gc();
            long startTime = System.currentTimeMillis();

            while (eof == false) {
                eof = this.readText(bufReader);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("RESULT : " + (endTime - startTime));
        } finally {
            if (bufReader != null) {
                try {
                    bufReader.close();
                } catch (IOException ioExc) {
                    // Do nothing.
                }
            }
        }
    }

    protected abstract boolean readText(BufferedReader bufReader) throws IOException;
}
