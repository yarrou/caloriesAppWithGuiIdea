package yarrou.app.core;

import yarrou.app.bazaDannich.BazaDannichCreator;

import java.io.IOException;

public class FilesStructureCreator {
    public  void createStructureApp() throws IOException {
        BazaDannichCreator.directoriesCreator("yarrouappCaloriiWithGui/baza");
        BazaDannichCreator.directoriesCreator("yarrouappCaloriiWithGui/grafics/gui");
        BazaDannichCreator.directoriesCreator("yarrouappCaloriiWithGui/grafics/products");
        BazaDannichCreator bazaDannichCreator = new BazaDannichCreator();
        bazaDannichCreator.createFilesFromResourses("grafics/products/изюм.jpg","yarrouappCaloriiWithGui/grafics/products/изюм.jpg");
        bazaDannichCreator.createFilesFromResourses("grafics/products/курага.jpeg","yarrouappCaloriiWithGui/grafics/products/курага.jpeg");

    }

}
