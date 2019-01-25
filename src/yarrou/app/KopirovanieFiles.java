package yarrou.app;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.copy;

public class KopirovanieFiles {


    public  void kopirovanie(File source, File dest) {
        try {
            copy(source.toPath(), dest.toPath());
            System.out.println("файл успешно скопирован");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}