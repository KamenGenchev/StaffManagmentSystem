package com.sirma.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class CsvReader implements DataFileReader {
    @Override
    public List<String[]> readDataFile(File file) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            if (reader.readLine() == null) {
                return list;
            }

            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(arr);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading csv file");
        }

        return list;
    }
}
