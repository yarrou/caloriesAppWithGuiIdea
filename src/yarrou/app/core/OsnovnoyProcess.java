package yarrou.app.core;

import yarrou.app.gui.GuiProgrammi;
import yarrou.app.bazaDannich.BazaDannixLoad;

public class OsnovnoyProcess {
    private GuiProgrammi glavnoeOkno;
    public  void osnProc () throws Exception{

        BazaDannixLoad.zagruzkaBazi();//загружаем базу данных
        GuiProgrammi glavnoeOkno=new GuiProgrammi();//создаем интерфейс программы
        glavnoeOkno.setVisible(true);
        glavnoeOkno.setBazaProducts(BazaDannixLoad.getEdaBaza());//передаем полученную базу окну интерфейса
        glavnoeOkno.setPutBazaSave(BazaDannixLoad.getPutFile());//передаем окну интерфейса путь сохранения базы
        DobavlenieNovogoProducta.setBazaDannihNew(BazaDannixLoad.getEdaBaza());
    }
}
