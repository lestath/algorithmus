package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pelski on 07.05.2017.
 */
public class SourceManager {
    private static SourceManager ourInstance = new SourceManager();

    public static SourceManager getInstance() {
        return ourInstance;
    }

    private FileOutputStream fop = null;
    private File file;
    private String content;

    public void addln(String text) {
        content += text;
        content += System.lineSeparator();
    }

    public void add(String text) {
        content += text;
    }

    public void save() {
        regenerateFile();

        byte[] contentInBytes = content.getBytes();

        try {
            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            content = "";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Done");
    }

    private SourceManager() {
        content = "";
    }

    private void regenerateFile() {
        file = new File("main.txt");
        try {
            fop = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
