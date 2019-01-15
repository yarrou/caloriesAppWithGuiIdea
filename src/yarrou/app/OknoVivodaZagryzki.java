package yarrou.app;

import javax.swing.*;

public class OknoVivodaZagryzki extends JFrame {
    private String itogZagruzkiBazi;
    public OknoVivodaZagryzki(String izb){
        super("Загрузка базы данных");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel vivodItogaZagruzki = new JLabel();
        JPanel oknoVivodaZagruzkiPanel=new JPanel();
        oknoVivodaZagruzkiPanel.add(vivodItogaZagruzki);
        getContentPane().add(oknoVivodaZagruzkiPanel);
        setSize(200,200);
    }
}
