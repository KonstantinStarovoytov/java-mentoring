package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVProviderReader {

    public static Iterator<Object[]> getCSVIterator(String path) {
        List<Object[]> testCases = new ArrayList<>();
        String[] data;
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                testCases.add(data);
            }
            testCases.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCases.iterator();
    }

}
