package yarrou.app.core;

import java.io.File;
import java.net.URL;

import static java.nio.file.Files.copy;

public class KopirovanieFiles {


    public  static void kopirovanie(File source, File dest) {
        try {
            copy(source.toPath(), dest.toPath());
            System.out.println("файл успешно скопирован");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public  static void kopirovanie(URL source, File dest) {
        File file=new File(source.getFile());
        try {
            copy(file.toPath(), dest.toPath());
            System.out.println("файл успешно скопирован");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}