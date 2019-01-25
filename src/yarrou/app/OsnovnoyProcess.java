package yarrou.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsnovnoyProcess {
    private GuiProgrammi glavnoeOkno;
    public  void osnProc () throws Exception{
        GuiProgrammi glavnoeOkno=new GuiProgrammi();//создаем интерфейс программы
        glavnoeOkno.setVisible(true);
        BazaDannixLoad opBazaDannix =new BazaDannixLoad();
        opBazaDannix.zagruzkaBazi();//загружаем базу данных
        glavnoeOkno.setBazaProducts(opBazaDannix.getEdaBaza());
        glavnoeOkno.setPutBazaSave(opBazaDannix.getPutFile());
        DobavlenieNovogoProducta dobNewProduct=new DobavlenieNovogoProducta();
        dobNewProduct.setBazaDannihNew(opBazaDannix.getEdaBaza());
        glavnoeOkno.setDobNewProdGui(dobNewProduct);
    }
}
