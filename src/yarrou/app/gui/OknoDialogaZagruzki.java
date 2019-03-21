package yarrou.app.gui;

import javax.swing.*;

public class OknoDialogaZagruzki extends JFrame {
    private String dialogVivodaZagruzki;
    public OknoDialogaZagruzki(String dvz){
        this.dialogVivodaZagruzki=dvz;
        JOptionPane.showMessageDialog(null, dialogVivodaZagruzki, "Загрузка базы", JOptionPane.WARNING_MESSAGE);


    }
}
