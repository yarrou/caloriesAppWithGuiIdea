package yarrou.app;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiProgrammi extends JFrame {
    private JButton sozProdCreateButton;
    private JLabel opisanieProductaLabel;
    public JLabel getOpisanieProductaLabel(){
        return opisanieProductaLabel;
    }
    String viborFileIcon;
    private DobavlenieNovogoProducta dobNewProdGui;
    public void setDobNewProdGui(DobavlenieNovogoProducta dnpg){
        this.dobNewProdGui=dnpg;
    }
    private BazaDannix bazaDannix;
    public void setBazaDannix(BazaDannix bd){
        this.bazaDannix=bd;
    }
    private Obrabotka obrabotka;

    public void setObrabotka( Obrabotka obrabot) {
        this.obrabotka= obrabot;
    }

    protected JButton poiskButton;
    public JButton getPoiskButton(){
        return poiskButton;
    }
    public GuiProgrammi() throws Exception {
        super("главное окно");
        viborFileIcon="yarrouappCaloriiWithGui/grafics/gui/food.jpg";
        setDefaultCloseOperation(EXIT_ON_CLOSE);




        JTabbedPane panelVkladok = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        JPanel poiskProductovPanel = new JPanel();//вкладка поиска продуктов
        JPanel zaprosPanel=new JPanel();//вкладка ввода запроса
        JLabel iskomiyProductLabel=new JLabel("искомый продукт");
        JTextField vvodTeksta=new JTextField(14);//поле ввода запроса
        JButton poiskButton=new JButton("поиск");//кнопка поиска

        zaprosPanel.add(iskomiyProductLabel);
        zaprosPanel.add(vvodTeksta);
        zaprosPanel.add(poiskButton);
        poiskProductovPanel.add(zaprosPanel, BorderLayout.NORTH);
        JLabel iconProductLabel=new JLabel();//вывод изображения продукта
        iconProductLabel.setPreferredSize(new Dimension(70,70));//размер изображения продукта
        iconProductLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel opisanieProductaLabel=new JLabel();//вывод результата поиска
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
                obrabotka.obrabotkaDannix(vvodTeksta.getText(),bazaDannix.getEdaBaza());
                opisanieProductaLabel.setText(obrabotka.getResult());
                ImageIcon prodIcon = new ImageIcon(obrabotka.getPrIc());
                iconProductLabel.setIcon(prodIcon);

            }
        });



        panelVkladok.add("поиск",poiskProductovPanel);

        JPanel sozdanieProductovPanel=new JPanel();
        //sozdanieProductovPanel.setLayout(new FlowLayout());
        JLabel sozProdNameLabel = new JLabel("название");
        sozProdNameLabel.setLocation(20,7);
        //sozProdNameLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        //sozProdNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JTextField sozProdNameTextfield = new JTextField(14);//ввод названия нового продукта
        //sozProdNameTextfield.setLocation(70,7);
        JPanel sozProdNamePanel = new JPanel();//панель для названия нового продукта
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

        JButton viborImageProd = new JButton("выберите изображение");//кнопка для выбора изображения нового продукта
        viborImageProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileImageProd = new JFileChooser();
                int ret = fileImageProd.showDialog(null,"выбрать файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    String viborIshodnogoFileIcon=fileImageProd.getName();//переменная пути к выбранному файлу
                    viborFileIcon="yarrouappCaloriiWithGui/grafics/products/"+sozProdNameTextfield.getText()+".jpg";//переменная пути к файлу-копии
                    KopirovanieFiles kopiFile=new KopirovanieFiles();//копированин файлов
                    try {
                        kopiFile.kopirovanie(viborIshodnogoFileIcon, viborFileIcon);
                    }
                    catch (IOException e){
                        System.out.println("error");

                    }
                }
            }
        });


        JButton sozProdCreateButton = new JButton("добавить");//кнопка добавления нового продукта
        sozProdCreateButton.addActionListener(new ActionListener() {//метод добавления нового продукта

            public void actionPerformed(ActionEvent event) {
                dobNewProdGui.dobavlyemProduct(sozProdNameTextfield.getText(),sozProdCaloriiTextfield.getText(),sozProdBelkiTextfield.getText(),sozProdJiriTextfield.getText(),sozProdUglevodiTextfield.getText(),viborFileIcon);
                bazaDannix.setEdaBaza(dobNewProdGui.getBazaDannihNew());
                JOptionPane.showMessageDialog(sozProdCreateButton, "продукт успешно добавлен", "Информация", JOptionPane.WARNING_MESSAGE);
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
