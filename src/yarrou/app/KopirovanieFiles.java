package yarrou.app;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.copy;

public class KopirovanieFiles {

    public  void kopirovanie(File source, File dest) throws IOException {
        copy(source.toPath(), dest.toPath());
    }
}