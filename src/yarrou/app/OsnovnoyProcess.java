package yarrou.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsnovnoyProcess {
    private GuiProgrammi glavnoeOkno;
    public  void osnProc () throws Exception{
        GuiProgrammi glavnoeOkno=new GuiProgrammi();//создаем интерфейс программы
        glavnoeOkno.setVisible(true);
        BazaDannix opBazaDannix =new BazaDannix();
        opBazaDannix.zagruzkaBazi();//загружаем базу данных
        glavnoeOkno.setBazaDannix(opBazaDannix);//прередаем загруженную базу gui
        Obrabotka opObrabotka= new Obrabotka();
        glavnoeOkno.setObrabotka(opObrabotka);
        DobavlenieNovogoProducta dobNewProduct=new DobavlenieNovogoProducta();
        dobNewProduct.setBazaDannihNew(opBazaDannix.getEdaBaza());
        glavnoeOkno.setDobNewProdGui(dobNewProduct);
        opBazaDannix.saveBaza(opBazaDannix.getPutFile(),opBazaDannix.getEdaBaza());
    }
}
