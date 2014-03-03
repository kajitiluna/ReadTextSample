package kajitiluna.sample.readtext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadManyText {

    private ReadType readType_;

    public static void main(String[] args) throws IOException {
        new ReadManyText(ReadType.BY_ONE_STEP).execute("target/manyDirs");
        // new ReadManyText(ReadType.BY_ARRAY).execute("target/manyDirs");
    }

    public ReadManyText(ReadType readType) {
        this.readType_ = readType;
    }

    public void execute(String filePath) throws IOException {
        File parentDir = new File(filePath);
        File[] subFiles = parentDir.listFiles();

        System.gc();
        long startTime = System.currentTimeMillis();

        for (File file : subFiles) {
            BufferedReader bufReader = null;
            try {
                FileReader reader = new FileReader(file);
                bufReader = new BufferedReader(reader);

                boolean eof = false;

                while (eof == false) {
                    eof = this.readType_.readText(bufReader);
                }
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

        long endTime = System.currentTimeMillis();
        System.out.println("RESULT : " + (endTime - startTime));
    }
}
