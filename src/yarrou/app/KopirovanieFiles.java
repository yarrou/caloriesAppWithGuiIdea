package yarrou.app;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.copy;

public class KopirovanieFiles {

    public  void kopirovanie(String source, String dest) throws IOException {
        File sourceFile=new File(source);
        File destFile=new File(dest);
        copy(sourceFile.toPath(), destFile.toPath());
    }
}