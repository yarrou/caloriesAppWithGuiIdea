package yarrou.app.gui;

import javax.swing.*;

public class VivodDialogaOshibkiDobavleniyaProducta extends JFrame{

    public VivodDialogaOshibkiDobavleniyaProducta() {
        JOptionPane.showMessageDialog(null, "неправильно заполнена форма", "добавление продукта", JOptionPane.WARNING_MESSAGE);

    }
}