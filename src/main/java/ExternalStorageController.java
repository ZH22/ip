import java.io.DataInput;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;

public class ExternalStorageController {

    private static final String DATA_DIR = "./data/";
    private static final String DATA_FILENAME = "mainStore.txt";

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

    public static String getStore() {
        return "TEMP";
    }
}
