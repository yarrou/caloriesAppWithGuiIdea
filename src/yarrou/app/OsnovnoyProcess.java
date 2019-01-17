package yarrou.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsnovnoyProcess {
    private GuiProgrammi glavnoeOkno;
    public  void osnProc () throws Exception{
        GuiProgrammi glavnoeOkno=new GuiProgrammi();
        glavnoeOkno.setVisible(true);
        JLabel opOpisanieProductaLabel =glavnoeOkno.getOpisanieProductaLabel();
        JButton opPoiskButton = glavnoeOkno.getPoiskButton();
        opPoiskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                opOpisanieProductaLabel.setText("привет");
            }
        });
    }
}
