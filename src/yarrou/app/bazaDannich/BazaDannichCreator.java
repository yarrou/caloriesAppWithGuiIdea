package yarrou.app.bazaDannich;/*
Этот класс предназначен для проверки наличия директории для базы данных и графики.
Если директория отсуствует,то она будет создана.
Статический метод будет принимать аргумент с путем для проверки и создания директории.
Метод возвращает правда если папка уже существует и ложь если пришлось создавать
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BazaDannichCreator {
    public static boolean directoriesCreator(String put){
        File papka=new File(put);
        if(papka.exists()&&papka.isDirectory()){
            return true;
        }
        else {
            papka.mkdirs();
            return false;
        }

    }
    public void createFilesFromResourses(String otkuda,String kuda) {
        URL putiz =getClass().getClassLoader().getResource(otkuda);
        InputStream inputStream= null;
        File proverka=new File(kuda);
        if (proverka.exists()==false) {
            try {
                inputStream = putiz.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.copy(inputStream, Paths.get(kuda));
                System.out.println("file copies");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
else {
    System.out.println("файл уже существует");
        }

    }
}
