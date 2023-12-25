package homeworksix;

import java.io.*;


public class FileReaderClass {
    public void readFile(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomUncheckedException("Error while reading file", e);
        }
    }
}