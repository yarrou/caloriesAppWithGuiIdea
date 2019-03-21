package yarrou.app.core;

import yarrou.app.gui.VivodDialogaOshibkiDobavleniyaProducta;

import java.util.ArrayList;
import java.util.Iterator;

public class DobavlenieNovogoProducta {


    public boolean getDobavlenieItog() {
        return dobavlenieItog;
    }
    private boolean dobavlenieItog;


    private ArrayList<Products> bazaDannihNew;
    void setBazaDannihNew(ArrayList<Products> bdnp){
        this.bazaDannihNew=bdnp;
    }
    public ArrayList<Products> getBazaDannihNew(){
        return bazaDannihNew;
    }


    private String itogAddNewProduct;
    public String getItogAddNewProduct(){
        return itogAddNewProduct;
    }


    public void dobavlyemProduct(String nameNewProduct, String energoNewProduct, String belkiNewProduct, String jiriNewProduct, String uglevodiNewProduct, String putIconNewProduct){
        this.dobavlenieItog=true;
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
            this.bazaDannihNew.add(addNewProducts);
            itogAddNewProduct="продукт успешно добавлен";
        }}
        catch (NumberFormatException e){
            dobavlenieItog=false;
            VivodDialogaOshibkiDobavleniyaProducta denp= new VivodDialogaOshibkiDobavleniyaProducta();
            denp.setVisible(false);

        }
    }
}