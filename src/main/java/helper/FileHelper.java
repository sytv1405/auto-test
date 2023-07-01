package helper;

import java.io.File;

public class FileHelper {
    public static boolean deleteFiles(String pathOfFolder, String extension) {
        boolean ret = false;
        File folder = new File(pathOfFolder);
        File[] fileList = folder.listFiles();
        for (File file : fileList) {
            String fileName = file.getName();
            if (fileName.endsWith("." + extension)) {
                ret = (new File(String.valueOf(file)).delete());
            }
        }
        return ret;
    }
}
