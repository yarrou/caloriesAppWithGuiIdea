package yarrou.app;

import javax.swing.*;

public class VivodDialogaOshibkiDobavleniyaProducta extends JFrame{

    VivodDialogaOshibkiDobavleniyaProducta() {
        JOptionPane.showMessageDialog(null, "неправильно заполнена форма", "добавление продукта", JOptionPane.WARNING_MESSAGE);

    }
}