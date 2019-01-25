package yarrou.app;

import javax.swing.*;

class OknoDialogaZagruzki extends JFrame {
    private String dialogVivodaZagruzki;
    OknoDialogaZagruzki(String dvz){
        this.dialogVivodaZagruzki=dvz;
        JOptionPane.showMessageDialog(null, dialogVivodaZagruzki, "Загрузка базы", JOptionPane.WARNING_MESSAGE);


    }
}
