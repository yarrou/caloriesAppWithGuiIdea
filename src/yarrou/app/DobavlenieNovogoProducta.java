package yarrou.app;

import java.util.ArrayList;
import java.util.Iterator;

public class DobavlenieNovogoProducta {
    private ArrayList<Products> bazaDannihNew;
    public void setBazaDannihNew(ArrayList<Products> bdnp){
        this.bazaDannihNew=bdnp;
    }
    private String itogAddNewProduct;
    public String getItogAddNewProduct(){
        return itogAddNewProduct;
    }
    public void dobavlyemProduct(String nameNewProduct,String energoNewProduct,String belkiNewProduct,String jiriNewProduct,String uglevodiNewProduct,String putIconNewProduct){
        double energod=Double.parseDouble(energoNewProduct);
        double belkid=Double.parseDouble(belkiNewProduct);
        double jirid=Double.parseDouble(jiriNewProduct);
        double ugled =Double.parseDouble(uglevodiNewProduct);
        Products addNewProducts = new Products(nameNewProduct,energod,belkid,jirid,ugled,putIconNewProduct);
        Iterator<Products> verNewProducts= bazaDannihNew.iterator();
        Products oneNewProductVerif = new Products(null,0,0,0,0,null);
        System.out.println("test 1 classa dobavleniya");
        boolean productNewInBaza=true;
        while (verNewProducts.hasNext()){
            System.out.println("test 2 classa dobavleniya");
            oneNewProductVerif=verNewProducts.next();
            System.out.println("test 3 classa dobavleniya");
            if (oneNewProductVerif.getName().equals(addNewProducts.getName())){
                itogAddNewProduct="продукт с таким названием уже существует";
                productNewInBaza=false;
            }
        }
        if (productNewInBaza){
            bazaDannihNew.add(addNewProducts);
            itogAddNewProduct="продукт успешно добавлен";
        }
    }
}
