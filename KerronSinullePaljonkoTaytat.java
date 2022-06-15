package graafisetOhjelmat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fi.jyu.mit.ohj2.Mjonot;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* Graafinen ohjelma joka kysyy k‰ytt‰j‰n syntym‰vuotta ja laskee sen perusteella kuinka paljon
* h‰n t‰ytt‰‰ vuonna 2019
* Ohjelma ei osaa hakea automaattisesti t‰m‰nhetkist‰ vuotta.
* Aliohjelmien toiminta ei ole mitenk‰‰n erinomainen, mutta sainpahan tehty‰ kopioimatta liialti huoneenAla teht‰v‰st‰
* @author jenni yrjana
* @version 19 Mar 2019
*/
public class KerronSinullePaljonkoTaytat extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JLabel lblKerroSyntymavuosi = new JLabel("Kirjoita t\u00E4h\u00E4n syntym\u00E4vuotesi (vvvv)");
    private static final JTextField textFieldSyntymavuosi = new JTextField();
    private final JLabel labelFill1 = new JLabel(" ");
    private final JLabel lblTaytatTanaVuonna = new JLabel("T\u00E4yt\u00E4t t\u00E4n\u00E4 vuonna");
    private static final JTextField textFieldVastaus = new JTextField();
    private final JLabel lblVuotta = new JLabel("vuotta");
    private final JButton btnLaske = new JButton("Laske!");

    /**
     * Launch the application.
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    KerronSinullePaljonkoTaytat frame = new KerronSinullePaljonkoTaytat();
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
    public KerronSinullePaljonkoTaytat() {
        textFieldVastaus.setColumns(10);
        textFieldSyntymavuosi.setColumns(10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 489, 448);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        GridBagConstraints gbc_lblKerroSyntymavuosi = new GridBagConstraints();
        gbc_lblKerroSyntymavuosi.insets = new Insets(0, 0, 5, 5);
        gbc_lblKerroSyntymavuosi.anchor = GridBagConstraints.EAST;
        gbc_lblKerroSyntymavuosi.gridx = 1;
        gbc_lblKerroSyntymavuosi.gridy = 1;
        contentPane.add(lblKerroSyntymavuosi, gbc_lblKerroSyntymavuosi);
        
        GridBagConstraints gbc_textFieldSyntymavuosi = new GridBagConstraints();
        gbc_textFieldSyntymavuosi.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldSyntymavuosi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSyntymavuosi.gridx = 2;
        gbc_textFieldSyntymavuosi.gridy = 1;
        contentPane.add(textFieldSyntymavuosi, gbc_textFieldSyntymavuosi);
        
        GridBagConstraints gbc_labelFill1 = new GridBagConstraints();
        gbc_labelFill1.insets = new Insets(0, 0, 5, 0);
        gbc_labelFill1.gridx = 4;
        gbc_labelFill1.gridy = 1;
        contentPane.add(labelFill1, gbc_labelFill1);
        
        GridBagConstraints gbc_lblTaytatTanaVuonna = new GridBagConstraints();
        gbc_lblTaytatTanaVuonna.anchor = GridBagConstraints.EAST;
        gbc_lblTaytatTanaVuonna.insets = new Insets(0, 0, 5, 5);
        gbc_lblTaytatTanaVuonna.gridx = 1;
        gbc_lblTaytatTanaVuonna.gridy = 3;
        contentPane.add(lblTaytatTanaVuonna, gbc_lblTaytatTanaVuonna);
        
        GridBagConstraints gbc_textFieldVastaus = new GridBagConstraints();
        gbc_textFieldVastaus.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldVastaus.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVastaus.gridx = 2;
        gbc_textFieldVastaus.gridy = 3;
        contentPane.add(textFieldVastaus, gbc_textFieldVastaus);
        
        GridBagConstraints gbc_lblVuotta = new GridBagConstraints();
        gbc_lblVuotta.insets = new Insets(0, 0, 5, 5);
        gbc_lblVuotta.gridx = 3;
        gbc_lblVuotta.gridy = 3;
        contentPane.add(lblVuotta, gbc_lblVuotta);
        
        GridBagConstraints gbc_btnLaske = new GridBagConstraints();
        gbc_btnLaske.insets = new Insets(0, 0, 0, 5);
        gbc_btnLaske.gridx = 2;
        gbc_btnLaske.gridy = 11;
        btnLaske.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                laske();
            }
        });
        contentPane.add(btnLaske, gbc_btnLaske);
    }


//////////////////////////Omat aliohjelmat////////////////////////////////
    /**
     * Aliohjelma, joka v‰hent‰‰ saamansa luvut toisistaan.
     * @param tamavuosi lukujosta v‰hennet‰‰n
     * @param syntymavuosi luku joka v‰hennet‰‰n
     * @return palauttaa lasketun i‰n formatoituna 
     */
    
    public static String laskeIka(int tamavuosi, int syntymavuosi) {
        double ika = tamavuosi - syntymavuosi;
        String tulos = String.format("%1.0f",ika);
        return tulos;
    }
    
    
    /**
     *  Aliohjelma joka laskee i‰n ja laittaapi sen sitten n‰kyville
     */
    
    public static void laske() {
        String syntymavuosi = textFieldSyntymavuosi.getText();
        int sv = Mjonot.erotaInt(syntymavuosi, 0);
        int tamavuosi = 2019;
        String ika = laskeIka(tamavuosi, sv);
        textFieldVastaus.setText(ika);
        
    }
}
