package yarrou.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OknoProgrammiGui {
    private BazaDannix bazDanGui;
    //private ExitDialog dialog;
    public void setBazDanGui(BazaDannix bdg){
        this.bazDanGui=bdg;
    }
    private Obrabotka obrab;
    public void setObrab(Obrabotka obr){
        this.obrab=obr;
    }
    public static void oknoprogrammi()throws Exception{
        BazaDannix bazDanGui =new BazaDannix();
        bazDanGui.zagruzkaBazi();
        final ArrayList<Products> bazaInGui= bazDanGui.getEdaBaza();
        Obrabotka obrab = new Obrabotka();
        JFrame glavnoeOkno = new JFrame("Программа подсчета калорий");
        ImageIcon iconProgrami=new ImageIcon("yarrouappCaloriiWithGui/grafics/gui/caloriiIcon.png");
        glavnoeOkno.setIconImage(iconProgrami.getImage());
        glavnoeOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glavnoeOkno.setSize(700,300);

        JPanel panel = new JPanel();
        JLabel opisanieVvoda = new JLabel("искомый продукт");
        JTextField vvod = new JTextField(14);
        JButton poisk = new JButton("поиск",new ImageIcon("yarrouappCaloriiWithGui/grafics/gui/poisk.png"));

        JLabel vivod = new JLabel();
        vivod.setBorder(BorderFactory.createTitledBorder("Результат"));
        panel.add(opisanieVvoda);
        panel.add(vvod);
        panel.add(poisk);

        glavnoeOkno.getContentPane().add(BorderLayout.NORTH, panel);
        glavnoeOkno.getContentPane().add(BorderLayout.CENTER,vivod);
        poisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String zaprosFromGui = vvod.getText();
                obrab.obrabotkaDannix(zaprosFromGui,bazaInGui);
                String rezultat = obrab.getResult();
                vivod.setText(rezultat);

            }
        });
        glavnoeOkno.setVisible(true);
    }

}
