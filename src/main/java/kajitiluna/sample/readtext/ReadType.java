package kajitiluna.sample.readtext;

import java.io.BufferedReader;
import java.io.IOException;

public enum ReadType {
    BY_ONE_STEP {
        @Override
        public boolean readText(BufferedReader bufReader) throws IOException {
            boolean eof = false;
            int[] readArray = new int[READ_COUNT];

            for (int index = 0; index < readArray.length; index++) {
                readArray[index] = bufReader.read();
                if (readArray[index] < 0) {
                    eof = true;
                    break;
                }
            }

            return eof;
        }
    },

    BY_ARRAY {
        @Override
        public boolean readText(BufferedReader bufReader) throws IOException {
            boolean eof = false;
            char[] readArray = new char[READ_COUNT];

            for (int index = 0; index < readArray.length; index++) {
                int readCount = bufReader.read(readArray);
                if (readCount < 0) {
                    eof = true;
                    break;
                }
            }

            return eof;
        }
    };

    private static final int READ_COUNT = 100;

    public abstract boolean readText(BufferedReader bufReader) throws IOException;
}
