package yarrou.app.bazaDannich;

import yarrou.app.core.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BazaDannixSave {

    public void saveBaza(String filePutsave, ArrayList<Products> bazaSaverProducts) throws IOException {

        File proverkaBazaFile = new File(filePutsave);
        if(proverkaBazaFile.exists()){
            FileWriter fileObnulator = new FileWriter(proverkaBazaFile);
            fileObnulator.write("");
        }
        Writer bazaSave = null;
        try {//при выходе из программы записываем базу в файл
            System.out.println("приступаем к сохранениюю");
            System.out.println("сохранять будем по пути"+ filePutsave);
            //Formatter bazaSaver = new Formatter(filePutsave);//создаем файл по обнаруженному пути
            //System.out.println("создан файл базы");
            Iterator<Products> bazaSaverIt = bazaSaverProducts.iterator();//для каждого элемента в базе
            bazaSave = new OutputStreamWriter(new FileOutputStream(filePutsave,true));
            while (bazaSaverIt.hasNext()){
                Products productBazaSaver = bazaSaverIt.next();
                bazaSave.write(productBazaSaver.getName()+" "+productBazaSaver.getEnergo()+" "+productBazaSaver.getBelki()+" "+productBazaSaver.getJiri()+" "+productBazaSaver.getUglevodi()+" "+productBazaSaver.getPutIcon());//записываем в файл данные продукта
                System.out.println("сохраняем данные продукта " +productBazaSaver.getName());
                if (bazaSaverIt.hasNext()){//если есть следующий продукт
                    bazaSave.write("\r\n");//добавляем переход на новую строку
                }
            }


            bazaSave.close();
            System.out.println("база сохранена");
        }
        catch(Exception e){
            System.out.println("База не сохранена");
            e.printStackTrace();
        }
    }
}
