package yarrou.app.bazaDannich;

import yarrou.app.gui.OknoDialogaZagruzki;
import yarrou.app.core.Products;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class BazaDannixLoad {
	private static ArrayList <Products>edaBaza;
	private static String putFile;
	private static boolean localBaza;
	private static String itogZagruzki;
	public static ArrayList getEdaBaza(){
		return edaBaza;
	}
	public static String getPutFile(){
		return putFile;
	}
	private OknoDialogaZagruzki odz;
	


	public static void zagruzkaBazi() throws Exception {
		ArrayList <Products> edaBazaProcess= new ArrayList();
		ArrayList <String> put_k_baze = new ArrayList();//создаем список путей к файлу с данными
		put_k_baze.add("yarrouappCaloriiWithGui/baza/baza.txt");//по умолчанию
		put_k_baze.add("hjhstorage/emulated/0/yarrouapp/baza.txt");//для андроид
		put_k_baze.add("C:/yarrouapp/baza.txt");//для виндовс
		put_k_baze.add("/sdcard/yarrouapp/baza.txt");
		localBaza = false;
		for (String putFil:put_k_baze){
			File bazaProducts = new File(putFil);
			if (bazaProducts.exists()){
				putFile=putFil;
				itogZagruzki=("локальная база загруженна по пути " + putFile);
				localBaza=true;
				FileReader bazaReader = new FileReader(putFile);
				Scanner bazaScanner = new Scanner(bazaReader);
				while (bazaScanner.hasNext()){
					String productInBaza = bazaScanner.nextLine();
					String[] productInBazaMass = productInBaza.split("\\s");
					String nameProduct = productInBazaMass[0];
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
			putFile="yarrouappCaloriiWithGui/baza/baza.txt";
		}
		OknoDialogaZagruzki odz =new OknoDialogaZagruzki(itogZagruzki);
	edaBaza=edaBazaProcess;
	}
}
