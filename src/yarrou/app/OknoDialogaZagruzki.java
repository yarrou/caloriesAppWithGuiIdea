package yarrou.app;

import javax.swing.*;

public class OknoDialogaZagruzki extends JFrame {
    private String dialogVivodaZagruzki;
    public OknoDialogaZagruzki(String dvz){
        this.dialogVivodaZagruzki=dvz;
        JOptionPane.showMessageDialog(null, dialogVivodaZagruzki, "Информация", JOptionPane.WARNING_MESSAGE);


    }
}
