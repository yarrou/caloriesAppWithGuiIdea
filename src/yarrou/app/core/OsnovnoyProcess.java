package yarrou.app.core;

import yarrou.app.gui.GuiProgrammi;
import yarrou.app.bazaDannich.BazaDannixLoad;

public class OsnovnoyProcess {
    private GuiProgrammi glavnoeOkno;
    public  void osnProc () throws Exception{

        BazaDannixLoad opBazaDannix =new BazaDannixLoad();
        opBazaDannix.zagruzkaBazi();//загружаем базу данных
        GuiProgrammi glavnoeOkno=new GuiProgrammi();//создаем интерфейс программы
        glavnoeOkno.setVisible(true);
        glavnoeOkno.setBazaProducts(opBazaDannix.getEdaBaza());//передаем полученную базу окну интерфейса
        glavnoeOkno.setPutBazaSave(opBazaDannix.getPutFile());//передаем окну интерфейса путь сохранения базы
        DobavlenieNovogoProducta dobNewProduct=new DobavlenieNovogoProducta();
        dobNewProduct.setBazaDannihNew(opBazaDannix.getEdaBaza());
        glavnoeOkno.setDobNewProdGui(dobNewProduct);
    }
}
