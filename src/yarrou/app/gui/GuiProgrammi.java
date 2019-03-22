package yarrou.app.gui;

import yarrou.app.bazaDannich.BazaDannixSave;
import yarrou.app.core.DobavlenieNovogoProducta;
import yarrou.app.core.KopirovanieFiles;
import yarrou.app.core.Obrabotka;
import yarrou.app.core.Products;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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



    public void setBazaProducts(ArrayList<Products> bazaProducts) {
        this.bazaProducts = bazaProducts;
    }
    private ArrayList<Products> bazaProducts;


    private String putBazaSave;
    public String getPutBazaSave() {
        return putBazaSave;
    }

    public void setPutBazaSave(String putBazaSave) {
        this.putBazaSave = putBazaSave;
    }

    public GuiProgrammi() throws Exception {

        super("Калорийность продуктов");
        viborFileIcon="yarrouappCaloriiWithGui/grafics/gui/food.jpg";//картинка по умолчанию для нового продукта
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconProgram = new ImageIcon("yarrouappCaloriiWithGui/grafics/gui/caloriiIcon.png");//иконка программы
        setIconImage(iconProgram.getImage());





        JTabbedPane panelVkladok = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);





        JPanel poiskProductovPanel = new JPanel();//вкладка поиска продуктов
        JPanel zaprosPanel=new JPanel();//вкладка ввода запроса
        JLabel iskomiyProductLabel=new JLabel("искомый продукт");
        JTextField vvodTeksta=new JTextField(14);//поле ввода запроса
        JButton poiskButton=new JButton("поиск",new ImageIcon("yarrouappCaloriiWithGui/grafics/gui/poisk.png"));//кнопка поиска

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

        poiskButton.addActionListener(new ActionListener() {//добавляем метод поиска к кнопке поиска
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Obrabotka obrabotka=new Obrabotka();
                obrabotka.obrabotkaDannix(vvodTeksta.getText(),bazaProducts);
                opisanieProductaLabel.setText(obrabotka.getResult());
                ImageIcon prodIcon = new ImageIcon(obrabotka.getPrIc());
                iconProductLabel.setIcon(prodIcon);

            }
        });








        JPanel sozdanieProductovPanel=new JPanel();
        JLabel sozProdNameLabel = new JLabel("название");
        sozProdNameLabel.setLocation(20,7);
        JTextField sozProdNameTextfield = new JTextField(14);//ввод названия нового продукта
        JPanel sozProdNamePanel = new JPanel();//панель для названия нового продукта
        sozProdNamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sozProdNamePanel.setPreferredSize(new Dimension(450,40));
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
                int ret = fileImageProd.showDialog(null,"выберите изображение");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File fileChooser = fileImageProd.getSelectedFile();
                    //String viborIshodnogoFileIcon=fileChooser.getName();//переменная пути к выбранному файлу
                    //System.out.println(viborIshodnogoFileIcon);
                    viborFileIcon="yarrouappCaloriiWithGui/grafics/products/"+sozProdNameTextfield.getText()+".jpg";//переменная пути к файлу-копии
                    File copyFile= new File(viborFileIcon);
                    System.out.println(viborFileIcon);
                    KopirovanieFiles kopiFile=new KopirovanieFiles();//копированин файлов
                    kopiFile.kopirovanie(fileChooser,copyFile);



                }
            }
        });


        JButton sozProdCreateButton = new JButton("добавить");//кнопка добавления нового продукта
        sozProdCreateButton.addActionListener(new ActionListener() {//метод добавления нового продукта

            public void actionPerformed(ActionEvent event) {
                DobavlenieNovogoProducta.dobavlyemProduct(sozProdNameTextfield.getText(),sozProdCaloriiTextfield.getText(),sozProdBelkiTextfield.getText(),
                        sozProdJiriTextfield.getText(),sozProdUglevodiTextfield.getText(),viborFileIcon);
                BazaDannixSave bazaDannixSave= new BazaDannixSave();
                try {
                    bazaDannixSave.saveBaza(putBazaSave,DobavlenieNovogoProducta.getBazaDannihNew());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (DobavlenieNovogoProducta.getDobavlenieItog()){
                    JOptionPane.showMessageDialog(sozProdCreateButton, "продукт успешно добавлен", "Информация", JOptionPane.WARNING_MESSAGE);
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







        Box obzorVsechProductov = Box.createVerticalBox();
        Box spisokProductovPanel=Box.createVerticalBox();
        JPanel spisokProductovButtonPanel= new JPanel();
        spisokProductovButtonPanel.setPreferredSize(new Dimension(450,40));
        JScrollPane spisokProductovScroll=new JScrollPane(spisokProductovPanel);
        JButton obnovlenie = new JButton("обновить");
        obnovlenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spisokProductovPanel.removeAll();
                int indexSpisok=0;
                System.out.println(bazaProducts.size());
                while (indexSpisok<bazaProducts.size()){
                    System.out.println((bazaProducts.get(indexSpisok)).getName());
                    JLabel spisokProductovLabel = new JLabel((bazaProducts.get(indexSpisok)).getName());
                    spisokProductovLabel.setPreferredSize(new Dimension(400,40));
                    spisokProductovPanel.add(spisokProductovLabel);
                    indexSpisok++;
                }
                spisokProductovScroll.revalidate();
            }
        });
        spisokProductovButtonPanel.add(obnovlenie);
        obzorVsechProductov.add(spisokProductovScroll);
        obzorVsechProductov.add(spisokProductovButtonPanel);



        //добавляем вкладки
        panelVkladok.add("поиск",poiskProductovPanel);
        panelVkladok.add("создание",sozProdBox);
        panelVkladok.add("обзор",obzorVsechProductov);



        getContentPane().add(panelVkladok);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//вычисляем размер экрана
        int sizeWidth = 450;//ширина окна программы
        int sizeHeight = 300;//высота окна программы
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);//присваиваем окну программы размер и положение относительно центра экрана
    }
}
