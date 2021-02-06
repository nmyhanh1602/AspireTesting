package common;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CommonFile {
    private File file;
    private String line = null;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;

    public List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            file = new File(filePath);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
                fr.close();
                br.close();
            } catch (IOException ioex) {
            }

        } catch (FileNotFoundException ex) {
        }
        return lines;
    }

    public void write(String path, String content) {
        try {
            file = new File(path);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            bw.write(content);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
