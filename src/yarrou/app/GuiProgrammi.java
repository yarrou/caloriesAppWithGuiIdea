package yarrou.app;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProgrammi extends JFrame {
    private JButton sozProdCreateButton;
    private JLabel opisanieProductaLabel;
    public JLabel getOpisanieProductaLabel(){
        return opisanieProductaLabel;
    }
    String vivod_v_okno;
    private BazaDannix bazaDannix;
    public void setBazaDannix(BazaDannix bd){
        this.bazaDannix=bd;
    }
    private Obrabotka obrabotka;
    protected JButton poiskButton;
    public JButton getPoiskButton(){
        return poiskButton;
    }
    public GuiProgrammi() throws Exception {
        super("главное окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);




        JTabbedPane panelVkladok = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        JPanel poiskProductovPanel = new JPanel();//вкладка поиска продуктов
        JPanel zaprosPanel=new JPanel();//вкладка ввода запроса
        JLabel iskomiyProductLabel=new JLabel("искомый продукт");
        JTextField vvodTeksta=new JTextField(14);
        JButton poiskButton=new JButton("поиск");

        zaprosPanel.add(iskomiyProductLabel);
        zaprosPanel.add(vvodTeksta);
        zaprosPanel.add(poiskButton);
        poiskProductovPanel.add(zaprosPanel, BorderLayout.NORTH);
        JLabel iconProductLabel=new JLabel();
        iconProductLabel.setPreferredSize(new Dimension(70,70));
        iconProductLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel opisanieProductaLabel=new JLabel();
        opisanieProductaLabel.setPreferredSize(new Dimension(355,70));
        opisanieProductaLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel vivodPanel=new JPanel();
        vivodPanel.setLayout(new FlowLayout());
        vivodPanel.add(iconProductLabel);
        vivodPanel.add(opisanieProductaLabel);
        vivodPanel.setBorder(new TitledBorder("вывод результата"));
        vivodPanel.setPreferredSize(new Dimension(450,200));
        poiskProductovPanel.add(vivodPanel, BorderLayout.CENTER);
        poiskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                opisanieProductaLabel.setText(bazaDannix.getItogZagruzki());
            }
        });



        panelVkladok.add("поиск",poiskProductovPanel);

        JPanel sozdanieProductovPanel=new JPanel();
        //sozdanieProductovPanel.setLayout(new FlowLayout());
        JLabel sozProdNameLabel = new JLabel("название");
        sozProdNameLabel.setLocation(20,7);
        //sozProdNameLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        //sozProdNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JTextField sozProdNameTextfield = new JTextField(14);
        //sozProdNameTextfield.setLocation(70,7);
        JPanel sozProdNamePanel = new JPanel();
        sozProdNamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sozProdNamePanel.setPreferredSize(new Dimension(450,40));
        //sozProdNamePanel.setLayout(null);
        sozProdNamePanel.add(sozProdNameLabel);
        sozProdNamePanel.add(sozProdNameTextfield);
        JLabel sozProdCaloriiLabel = new JLabel("калорийность");
        JTextField sozProdCaloriiTextfield = new JTextField(5);
        JPanel sozProdCaloriiPanel = new JPanel();
        sozProdCaloriiPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sozProdCaloriiPanel.setPreferredSize(new Dimension(450,40));
        sozProdCaloriiPanel.add(sozProdCaloriiLabel);
        sozProdCaloriiPanel.add(sozProdCaloriiTextfield);
        JLabel sozProdBelkiLabel = new JLabel("белки");
        JTextField sozProdBelkiTextfield = new JTextField(5);
        JPanel sozProdBelkiPanel = new JPanel();
        sozProdBelkiPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sozProdBelkiPanel.setPreferredSize(new Dimension(450,40));
        sozProdBelkiPanel.add(sozProdBelkiLabel);
        sozProdBelkiPanel.add(sozProdBelkiTextfield);
        JTextField sozProdJiriTextfield = new JTextField(5);
        JLabel sozProdJiriLabel = new JLabel("жиры");
        JPanel sozProdJiriPanel = new JPanel();
        sozProdJiriPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sozProdJiriPanel.setPreferredSize(new Dimension(450,40));
        sozProdJiriPanel.add(sozProdJiriLabel);
        sozProdJiriPanel.add(sozProdJiriTextfield);
        JLabel sozProdUglevodiLabel = new JLabel("углеводы");
        JTextField sozProdUglevodiTextfield = new JTextField(5);
        JPanel sozProdUglevodiPanel = new JPanel();
        sozProdUglevodiPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sozProdUglevodiPanel.setPreferredSize(new Dimension(450,40));
        sozProdUglevodiPanel.add(sozProdUglevodiLabel);
        sozProdUglevodiPanel.add(sozProdUglevodiTextfield);


        JButton sozProdCreateButton = new JButton("добавить");
        sozProdCreateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(sozProdCreateButton, vivod_v_okno, "Информация", JOptionPane.WARNING_MESSAGE);
            }

        });
        JButton viborImageProd = new JButton("выберите изображение");
        viborImageProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileImageProd = new JFileChooser();
                int ret = fileImageProd.showDialog(null,"выбрать файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    vivod_v_okno=fileImageProd.getName();
                }
            }
        });
        JPanel panelFinal = new JPanel();
        panelFinal.add(viborImageProd);
        panelFinal.add(sozProdCreateButton);

        Box sozProdBox = Box.createVerticalBox();
        sozProdBox.add(sozProdNamePanel);
        sozProdBox.add(sozProdCaloriiPanel);
        sozProdBox.add(sozProdBelkiPanel);
        sozProdBox.add(sozProdJiriPanel);
        sozProdBox.add(sozProdUglevodiPanel);
        sozProdBox.add(panelFinal);


        panelVkladok.add("создание",sozProdBox);
        getContentPane().add(panelVkladok);
        setSize(450,300);
    }
}
