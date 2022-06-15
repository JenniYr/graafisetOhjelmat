package graafisetOhjelmat;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import fi.jyu.mit.ohj2.Mjonot;

/**
*
* @author jenni yrjänä
* @version 11 Mar 2019
*/
public class HuoneenAla extends JFrame {

    /**
     * Graafinen ohjelma, joka laskee annetuista luvuista huoneen alan ja tilavuuden
     * Apuna käytetty aliohjelmia mittakaava-ohjelmasta
     * Tulos ilmoitetaan cm2 ja cm3, joka ei käytettävyyden kannalta ole ehkä järkevin mahdollinen
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JLabel lblHuoneenPituus = new JLabel("Huoneen pituus");
    private final JLabel lblHuoneenLeveys = new JLabel("Huoneen leveys");
    private final static JTextField textFieldHuoneenPituus = new JTextField();
    private final static JTextField textFieldHuoneenLeveys = new JTextField();
    private final JLabel lblHuoneenPintaalaOn = new JLabel("Huoneen pinta-ala on");
    private final static JTextField textFieldHuoneenAla = new JTextField();
    private final JLabel lblHuoneenPituusCm = new JLabel("cm");
    private final JLabel lblHuoneenLeveysCm = new JLabel("cm");
    private final JLabel lblCm = new JLabel("cm2");
    private final JLabel label = new JLabel(" ");
    private final JLabel lblHuoneenKorkeus = new JLabel("Huoneen Korkeus");
    private final static JTextField textFieldHuoneenKorkeus = new JTextField();
    private final JLabel lblCm_1 = new JLabel("cm");
    private final JLabel lblHuoneenTilavuus = new JLabel("Huoneen tilavuus on");
    private final static JTextField textFieldHuoneenTilavuus = new JTextField();
    private final JLabel lblHuoneenTilavuusCm = new JLabel("cm3");
    private final JLabel lblMadeByJenni = new JLabel("Made by Jenni Y");
    private final JLabel label_1 = new JLabel(" ");
    private final JLabel label_2 = new JLabel(" ");

    /**
     * Launch the application.
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HuoneenAla frame = new HuoneenAla();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public HuoneenAla() {
        setTitle("Huoneen pinta-ala ja tilavuus");
        textFieldHuoneenTilavuus.setColumns(10);
        textFieldHuoneenKorkeus.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                laskeTilavuus();
            }
        });
        textFieldHuoneenKorkeus.setColumns(10);
        textFieldHuoneenLeveys.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                laskeAla();
                laskeTilavuus();
            }
        });
        textFieldHuoneenLeveys.setColumns(10);
        textFieldHuoneenPituus.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                laskeAla();
                laskeTilavuus();
            }
        });
        textFieldHuoneenPituus.setColumns(10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 652, 463);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);
        
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 2;
        gbc_label_2.gridy = 2;
        contentPane.add(label_2, gbc_label_2);
        
        GridBagConstraints gbc_lblHuoneenPituus = new GridBagConstraints();
        gbc_lblHuoneenPituus.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenPituus.gridx = 2;
        gbc_lblHuoneenPituus.gridy = 3;
        contentPane.add(lblHuoneenPituus, gbc_lblHuoneenPituus);
        
        GridBagConstraints gbc_textFieldHuoneenPituus = new GridBagConstraints();
        gbc_textFieldHuoneenPituus.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldHuoneenPituus.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHuoneenPituus.gridx = 4;
        gbc_textFieldHuoneenPituus.gridy = 3;
        contentPane.add(textFieldHuoneenPituus, gbc_textFieldHuoneenPituus);
        
        GridBagConstraints gbc_lblHuoneenPituusCm = new GridBagConstraints();
        gbc_lblHuoneenPituusCm.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenPituusCm.gridx = 5;
        gbc_lblHuoneenPituusCm.gridy = 3;
        contentPane.add(lblHuoneenPituusCm, gbc_lblHuoneenPituusCm);
        
        GridBagConstraints gbc_lblHuoneenLeveys = new GridBagConstraints();
        gbc_lblHuoneenLeveys.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenLeveys.gridx = 2;
        gbc_lblHuoneenLeveys.gridy = 5;
        contentPane.add(lblHuoneenLeveys, gbc_lblHuoneenLeveys);
        
        GridBagConstraints gbc_textFieldHuoneenLeveys = new GridBagConstraints();
        gbc_textFieldHuoneenLeveys.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldHuoneenLeveys.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHuoneenLeveys.gridx = 4;
        gbc_textFieldHuoneenLeveys.gridy = 5;
        contentPane.add(textFieldHuoneenLeveys, gbc_textFieldHuoneenLeveys);
        
        GridBagConstraints gbc_lblHuoneenLeveysCm = new GridBagConstraints();
        gbc_lblHuoneenLeveysCm.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenLeveysCm.gridx = 5;
        gbc_lblHuoneenLeveysCm.gridy = 5;
        contentPane.add(lblHuoneenLeveysCm, gbc_lblHuoneenLeveysCm);
        
        GridBagConstraints gbc_lblHuoneenKorkeus = new GridBagConstraints();
        gbc_lblHuoneenKorkeus.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenKorkeus.gridx = 2;
        gbc_lblHuoneenKorkeus.gridy = 7;
        contentPane.add(lblHuoneenKorkeus, gbc_lblHuoneenKorkeus);
        
        GridBagConstraints gbc_textFieldHuoneenKorkeus = new GridBagConstraints();
        gbc_textFieldHuoneenKorkeus.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldHuoneenKorkeus.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHuoneenKorkeus.gridx = 4;
        gbc_textFieldHuoneenKorkeus.gridy = 7;
        contentPane.add(textFieldHuoneenKorkeus, gbc_textFieldHuoneenKorkeus);
        
        GridBagConstraints gbc_lblCm_1 = new GridBagConstraints();
        gbc_lblCm_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblCm_1.gridx = 5;
        gbc_lblCm_1.gridy = 7;
        contentPane.add(lblCm_1, gbc_lblCm_1);
        
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 4;
        gbc_label_1.gridy = 8;
        contentPane.add(label_1, gbc_label_1);
        
        GridBagConstraints gbc_lblHuoneenPintaalaOn = new GridBagConstraints();
        gbc_lblHuoneenPintaalaOn.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenPintaalaOn.gridx = 2;
        gbc_lblHuoneenPintaalaOn.gridy = 9;
        contentPane.add(lblHuoneenPintaalaOn, gbc_lblHuoneenPintaalaOn);
        textFieldHuoneenAla.setColumns(10);
        
        GridBagConstraints gbc_textFieldHuoneenAla = new GridBagConstraints();
        gbc_textFieldHuoneenAla.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldHuoneenAla.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHuoneenAla.gridx = 4;
        gbc_textFieldHuoneenAla.gridy = 9;
        contentPane.add(textFieldHuoneenAla, gbc_textFieldHuoneenAla);
        
        GridBagConstraints gbc_lblCm = new GridBagConstraints();
        gbc_lblCm.insets = new Insets(0, 0, 5, 5);
        gbc_lblCm.gridx = 5;
        gbc_lblCm.gridy = 9;
        contentPane.add(lblCm, gbc_lblCm);
        
        GridBagConstraints gbc_lblHuoneenTilavuus = new GridBagConstraints();
        gbc_lblHuoneenTilavuus.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenTilavuus.gridx = 2;
        gbc_lblHuoneenTilavuus.gridy = 11;
        contentPane.add(lblHuoneenTilavuus, gbc_lblHuoneenTilavuus);
        
        GridBagConstraints gbc_textFieldHuoneenTilavuus = new GridBagConstraints();
        gbc_textFieldHuoneenTilavuus.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldHuoneenTilavuus.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHuoneenTilavuus.gridx = 4;
        gbc_textFieldHuoneenTilavuus.gridy = 11;
        contentPane.add(textFieldHuoneenTilavuus, gbc_textFieldHuoneenTilavuus);
        
        GridBagConstraints gbc_lblHuoneenTilavuusCm = new GridBagConstraints();
        gbc_lblHuoneenTilavuusCm.insets = new Insets(0, 0, 5, 5);
        gbc_lblHuoneenTilavuusCm.gridx = 5;
        gbc_lblHuoneenTilavuusCm.gridy = 11;
        contentPane.add(lblHuoneenTilavuusCm, gbc_lblHuoneenTilavuusCm);
        
        GridBagConstraints gbc_lblMadeByJenni = new GridBagConstraints();
        gbc_lblMadeByJenni.insets = new Insets(0, 0, 0, 5);
        gbc_lblMadeByJenni.gridx = 4;
        gbc_lblMadeByJenni.gridy = 13;
        contentPane.add(lblMadeByJenni, gbc_lblMadeByJenni);
    }
    
    ///////////////////////////// OMAT ALIOHJELMAT ///////////////////////////////////////////////
    
    /**
     * @param text 
     * @param oletus
     * @return palauttaa erotellun luvun
     */
    public static double haeLuku(JTextField text,double oletus) {
        
    double luku = Mjonot.erotaDouble(text.getText(), oletus);
    return luku;
}
    
    /**
     * Laittaa tekstikenttään tuloksen
     * @param text kenttä johon luku laitetaan
     * @param luku joka laitetaan kenttään
     */
    public static void laitaTulos(JTextField text, double luku) {
        String tulos = String.format("%5.2f",luku);
        tulos = tulos.replace(',', '.');
        text.setText(tulos);
    }
    
    /**
     * aliohjelma, joka hakee huoneen pituuden ja leveyden, laskee alan ja kutsuu laitaTulos aliohjelmaa asettamaan
     * tuloksen sille varatulle paikalle
     */
    public static void laskeAla() {
        
        double huoneenPituus = haeLuku(textFieldHuoneenPituus, 0);
        double huoneenLeveys = haeLuku(textFieldHuoneenLeveys, 0);
        double huoneenAla =  huoneenPituus * huoneenLeveys;
        laitaTulos(textFieldHuoneenAla, huoneenAla);
    }
    
    /**
     * aliohjelma, joks hakee huoneen pituuden ja leveyden sekä korkeuden ja laskee näistä tilavuuden
     * kutsuu lopuksi aliohjelmaa, joka asettaa tekstin sille varatulle paikalle
     */
    public static void laskeTilavuus() {
        double huoneenPituus = haeLuku(textFieldHuoneenPituus, 0);
        double huoneenLeveys = haeLuku(textFieldHuoneenLeveys, 0);
        double huoneenKorkeus = haeLuku(textFieldHuoneenKorkeus, 0);
        
        double huoneenTilavuus = huoneenPituus * huoneenLeveys* huoneenKorkeus;
        
        laitaTulos(textFieldHuoneenTilavuus, huoneenTilavuus);
    }
}
