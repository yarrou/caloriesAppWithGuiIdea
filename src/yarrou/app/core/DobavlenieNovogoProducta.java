package yarrou.app.core;

import yarrou.app.gui.VivodDialogaOshibkiDobavleniyaProducta;

import java.util.ArrayList;
import java.util.Iterator;

public class DobavlenieNovogoProducta {


    public static boolean getDobavlenieItog() {
        return dobavlenieItog;
    }
    private static boolean dobavlenieItog;


    private static ArrayList<Products> bazaDannihNew;
    static void setBazaDannihNew(ArrayList<Products> bdnp){
        bazaDannihNew=bdnp;
    }
    public static ArrayList<Products> getBazaDannihNew(){
        return bazaDannihNew;
    }


    private static String itogAddNewProduct;
    public String getItogAddNewProduct(){
        return itogAddNewProduct;
    }


    public static void dobavlyemProduct(String nameNewProduct, String energoNewProduct, String belkiNewProduct, String jiriNewProduct, String uglevodiNewProduct, String putIconNewProduct){
        dobavlenieItog=true;
        try{
        double energod=Double.parseDouble(energoNewProduct);
        double belkid=Double.parseDouble(belkiNewProduct);
        double jirid=Double.parseDouble(jiriNewProduct);
        double ugled =Double.parseDouble(uglevodiNewProduct);
        Products addNewProducts = new Products(nameNewProduct,energod,belkid,jirid,ugled,putIconNewProduct);
        Iterator<Products> verNewProducts= bazaDannihNew.iterator();
        Products oneNewProductVerif = new Products(null,0,0,0,0,null);
        boolean productNewInBaza=true;
        while (verNewProducts.hasNext()){
            oneNewProductVerif=verNewProducts.next();
            if (oneNewProductVerif.getName().equals(addNewProducts.getName())){
                itogAddNewProduct="продукт с таким названием уже существует";
                productNewInBaza=false;
            }
        }
        if (productNewInBaza){
            bazaDannihNew.add(addNewProducts);
            itogAddNewProduct="продукт успешно добавлен";
        }}
        catch (NumberFormatException e){
            dobavlenieItog=false;
            VivodDialogaOshibkiDobavleniyaProducta denp= new VivodDialogaOshibkiDobavleniyaProducta();
            denp.setVisible(false);

        }
    }
}
