package kajitiluna.sample.readtext.huge;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadHugeTextByArray extends ReadHugeText {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "target/sample.txt";
        new ReadHugeTextByArray().execute(filePath);
    }

    @Override
    protected boolean readText(BufferedReader bufReader) throws IOException {
        boolean eof = false;
        char[] readArray = new char[READ_STEP];

        for (int index = 0; index < readArray.length; index++) {
            int readCount = bufReader.read(readArray);
            if (readCount < 0) {
                eof = true;
                break;
            }
        }

        return eof;
    }
}
