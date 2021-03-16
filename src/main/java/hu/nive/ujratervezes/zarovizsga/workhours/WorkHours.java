package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public static final int WORKHOURS_POSITION = 1;
    public static final int DATE_POSITION = 2;
    public static final int NAME_POSITION = 0;

    public String minWork(String file) {

        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))){
            return lineReader(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }

    private String lineReader(BufferedReader reader) throws IOException {
        String line;
        String name = "";
        int minHours = Integer.MAX_VALUE;
        String date = "";
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int hours = Integer.parseInt(parts[WORKHOURS_POSITION]);
            if (hours < minHours) {
                minHours = hours;
                date = parts[DATE_POSITION];
                name = parts[NAME_POSITION];
            }
        }
        return name + ": " + date;
    }

}
