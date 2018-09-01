package utilities.fileUtilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class fileCommons {

    private static String extendedPath = "src/main/resources/";

    public static List<String> getFileContentAsList(String filename) {

        if (!new File(filename).exists()) {
            filename = extendedPath + filename;
        }

        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allLines;
    }

    public static void writeData(List<String> data, String filepath) {
        Path file = Paths.get(extendedPath + filepath);
        try {
            Files.write(file, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
