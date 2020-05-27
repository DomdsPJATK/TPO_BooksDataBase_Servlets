package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JspFileReader {

    private String path;
    private Scanner scanner;

    public JspFileReader(String path) {
        this.path = path;
        try {
            this.scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String read(){
        StringBuilder builder = new StringBuilder();
        while(scanner.hasNextLine()) builder.append(scanner.nextLine());
        return builder.toString();
    }



}
