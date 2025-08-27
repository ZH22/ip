package Nacho;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;

public class ExternalStorageController {
    // Handles Interactions with external file

    private static final String DATA_DIR = "./data/";
    private static final String DATA_FILENAME = "mainStore.txt";
    private static final String CORRUPTED_TEMP_FILENAME = "oldCorrupted.txt";

    public static void updateStore(String newContent) {

        // Create Data Directory and File if not exist
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
            File storageFile = new File(DATA_DIR + DATA_FILENAME);
            storageFile.createNewFile();

            FileWriter storageWriter = new FileWriter(DATA_DIR + DATA_FILENAME);
            storageWriter.write(newContent);
            storageWriter.close();

        } catch (IOException e) {
            System.out.println("An I/O error occurred " + e.getMessage());
        }
    }

    public static void createTempCorruptedFile() {
        // Creates a copy of the data file into a temporary file storing potentially corrupted data
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
            File corruptedTempFile = new File(DATA_DIR + CORRUPTED_TEMP_FILENAME);
            corruptedTempFile.createNewFile();

            String corruptedContent = ExternalStorageController.getStore();

            FileWriter corruptWriter = new FileWriter(DATA_DIR + CORRUPTED_TEMP_FILENAME);
            corruptWriter.write(corruptedContent);
            corruptWriter.close();

        } catch (IOException e) {
            System.out.println("An I/O error occurred " + e.getMessage());
        }
    }

    public static String getStore() {
        try {
            return Files.readString(Paths.get(DATA_DIR + DATA_FILENAME));
        } catch (IOException e){
            System.out.println("An I/O error occurred " + e.getMessage());
            return "";
        }
    }
}
