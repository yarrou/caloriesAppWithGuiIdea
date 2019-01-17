package yarrou.app;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;

public class BazaDannix {
	private ArrayList <Products>edaBaza;
	private String putFile;
	private boolean localBaza;
	private String itogZagruzki;
	public ArrayList getEdaBaza(){
		return edaBaza;
	}
	public String getItogZagruzki(){
		return itogZagruzki;
	}
	public boolean getLocalBaza(){
		return localBaza;
	}
	public String getPutFile(){
		return putFile;
	}
	private OknoDialogaZagruzki odz;
	

	public void saveBaza(String filePutsave,ArrayList<Products> bazaSaverProducts){
		try {//при выходе из программы записываем базу в файл
			Formatter bazaSaver = new Formatter(filePutsave);//создаем файл по обнаруженному пути
			Iterator<Products> bazaSaverIt = bazaSaverProducts.iterator();//для каждого элемента в базе
			while (bazaSaverIt.hasNext()){
				Products productBazaSaver = bazaSaverIt.next();
				System.out.println("сохраняем данные продукта " +productBazaSaver.getName());
				bazaSaver.format("%s %s %s %s %s",productBazaSaver.getName(),productBazaSaver.getEnergo(),productBazaSaver.getBelki(),productBazaSaver.getJiri(),productBazaSaver.getUglevodi());//записываем в файл данные продукта
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
	public void zagruzkaBazi() throws Exception {
		ArrayList <Products> edaBazaProcess= new ArrayList();
		ArrayList <String> put_k_baze = new ArrayList();//создаем список путей к файлу с данными
		put_k_baze.add("yarrouapp/baza.txt");//по умолчанию
		put_k_baze.add("hjhstorage/emulated/0/yarrouapp/baza.txt");//для андроид
		put_k_baze.add("C:/yarrouapp/baza.txt");//для виндовс
		put_k_baze.add("/sdcard/yarrouapp/baza.txt");
		localBaza = false;
		for (String putFile:put_k_baze){
			File bazaProducts = new File(putFile);
			if (bazaProducts.exists()){
				itogZagruzki=("локальная база загруженна по пути " + putFile);
				localBaza=true;
				FileReader bazaReader = new FileReader(putFile);
				Scanner bazaScanner = new Scanner(bazaReader);
				while (bazaScanner.hasNext()){
					String productInBaza = bazaScanner.nextLine();
					String[] productInBazaMass = productInBaza.split("\\s");
					String nameProduct = productInBazaMass[0];
					//System.out.println("количество продуктов в обнаруженной базе"+productInBazaMass.length);
					double caloriiProduct = Double.parseDouble(productInBazaMass[1]);
					double belkiProduct=Double.parseDouble(productInBazaMass[2]);
					double jiriProduct =Double.parseDouble(productInBazaMass[3]);
					double uglevodiProduct=Double.parseDouble(productInBazaMass[4]);
					String iconProduct=productInBazaMass[5];
					Products productInBazaNew = new Products(nameProduct ,caloriiProduct,belkiProduct,jiriProduct,uglevodiProduct,iconProduct);
					edaBazaProcess.add(productInBazaNew);
				}
				System.out.println("кроличество продуктов в загруженной базе "+edaBazaProcess.size());
				break;
			}
		}

		if(localBaza!=true){
			itogZagruzki=("используется встроенная база данных");
			Products izum = new Products("изюм",264.0,3.1,0.5,79.,"yarrouappCaloriiWithGui/grafics/products/изюм.jpg");
			Products kuraga = new Products("курага",215.0,3.4,0.5,63.0,"yarrouappCaloriiWithGui/grafics/products/курага.jpeg");
			edaBazaProcess.add(izum);
			edaBazaProcess.add(kuraga);
		}
		OknoDialogaZagruzki odz =new OknoDialogaZagruzki(itogZagruzki);
		odz.setVisible(true);
	this.edaBaza=edaBazaProcess;
	}
}
