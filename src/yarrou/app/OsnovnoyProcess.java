package yarrou.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsnovnoyProcess {
    private GuiProgrammi glavnoeOkno;
    public  void osnProc () throws Exception{
        GuiProgrammi glavnoeOkno=new GuiProgrammi();
        glavnoeOkno.setVisible(true);
        BazaDannix opBazaDannix =new BazaDannix();
        opBazaDannix.zagruzkaBazi();
        glavnoeOkno.setBazaDannix(opBazaDannix);
        Obrabotka opObrabotka= new Obrabotka();
        glavnoeOkno.setObrabotka(opObrabotka);
        opBazaDannix.saveBaza(opBazaDannix.getPutFile(),opBazaDannix.getEdaBaza());
        DobavlenieNovogoProducta dobNewProduct=new DobavlenieNovogoProducta();
        dobNewProduct.setBazaDannihNew(opBazaDannix.getEdaBaza());
        glavnoeOkno.setDobNewProdGui(dobNewProduct);
    }
}
