package yarrou.app.bazaDannich;/*
Этот класс предназначен для проверки наличия директории для базы данных и графики.
Если директория отсуствует,то она будет создана.
Статический метод будет принимать аргумент с путем для проверки и создания директории.
Метод возвращает правда если папка уже существует и ложь если пришлось создавать
 */

import java.io.File;

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
}
