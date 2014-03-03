package kajitiluna.sample.readtext.huge;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadHugeTextByOneStep extends ReadHugeText {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "target/sample.txt";
        new ReadHugeTextByOneStep().execute(filePath);
    }

    @Override
    protected boolean readText(BufferedReader bufReader) throws IOException {
        boolean eof = false;
        int[] readArray = new int[READ_STEP];

        for (int index = 0; index < readArray.length; index++) {
            readArray[index] = bufReader.read();
            if (readArray[index] < 0) {
                eof = true;
                break;
            }
        }

        return eof;
    }
}
