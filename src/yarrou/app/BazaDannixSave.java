package yarrou.app;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

public class BazaDannixSave {

    public void saveBaza(String filePutsave, ArrayList<Products> bazaSaverProducts){
        try {//при выходе из программы записываем базу в файл
            System.out.println("приступаем к сохранениюю");
            System.out.println("сохранять будем по пути"+ filePutsave);
            Formatter bazaSaver = new Formatter(filePutsave);//создаем файл по обнаруженному пути
            System.out.println("создан файл базы");
            Iterator<Products> bazaSaverIt = bazaSaverProducts.iterator();//для каждого элемента в базе
            while (bazaSaverIt.hasNext()){
                Products productBazaSaver = bazaSaverIt.next();
                System.out.println("сохраняем данные продукта " +productBazaSaver.getName());
                bazaSaver.format("%s %s %s %s %s %s",productBazaSaver.getName(),productBazaSaver.getEnergo(),productBazaSaver.getBelki(),productBazaSaver.getJiri(),productBazaSaver.getUglevodi(),productBazaSaver.getPutIcon());//записываем в файл данные продукта
                if (bazaSaverIt.hasNext()){//если есть следующий продукт
                    bazaSaver.format("%s","\r\n");//добавляем переход на новую строку
                }
            }


            bazaSaver.close();
            System.out.println("база сохранена");
        }
        catch(Exception e){
            System.out.println("База не сохранена");
        }
    }
}
