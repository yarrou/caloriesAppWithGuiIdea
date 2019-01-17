package yarrou.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitDialog extends JDialog
{
    public ExitDialog(JFrame owner)
    {
        super(owner, "Всего вам хорошего", true);

        // Метка с HTML-форматированием выравнивается по центру.

        add(new JLabel(
                        "ЖРИТЕ МЕНЬШЕ"),
                BorderLayout.CENTER);

        // При активизации кнопки ОК диалогове окно закрывается.

        JButton ok = new JButton("ok");
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });

        // Кнопка ОК помещается в нижнюю часть окна.

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(260, 160);
    }
}