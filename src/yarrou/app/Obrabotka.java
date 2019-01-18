package yarrou.app;

import java.util.ArrayList;
import java.util.Iterator;

public class Obrabotka {
	private boolean sootvetstvie;
	private String prIc;
	public String getPrIc(){
		return prIc;
	}
	public boolean getSootvetstvie(){
		return sootvetstvie;
	}
	private String result;
	public String getResult(){
		return result;
	}
	public void obrabotkaDannix(String zapros,ArrayList<Products> polu4enayaBazaDannix){
		//String product = input.next();//запрос
		sootvetstvie=true;
		int indeks = -1 ;
		Iterator<Products> oneProduct = polu4enayaBazaDannix.iterator();
		Products oneProductVerif = new Products(null,0,0,0,0,null);
		while(oneProduct.hasNext()){//прогоняем запрос по базе
			oneProductVerif = oneProduct.next();
			indeks++;
			if(zapros.equals(oneProductVerif.getName())) {//если запрос соответствует элементу в базе
				this.result=oneProductVerif.vivod(oneProductVerif.getName(), oneProductVerif.getEnergo());//выводим данные по запросу
				this.prIc=oneProductVerif.getPutIcon();
				sootvetstvie=false;//если найдено соответствие ,то меняем переменную
				break;
			}
		}
		if(sootvetstvie){//если переменная не изменена ,то выводим отрицательный результат
			this.result="не найдено соответствий";
		}}}

