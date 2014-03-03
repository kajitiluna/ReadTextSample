package kajitiluna.sample.readtext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReadHugeText {

    private ReadType readType_;

    public ReadHugeText(ReadType readType) {
        this.readType_ = readType;
    }

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
                eof = this.readType_.readText(bufReader);
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
}
