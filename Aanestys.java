package graafisetOhjelmat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import aanestysSwing.SukupuoliOlio;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Pieni esimerkki äänestys-ohjelmasta.
 * TODO: Poista switch-lause
 * @author veli.tornikoski
 * @version 10.1.2013
 */
public class Aanestys extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JPanel panelAanestys = new JPanel();
    private final JLabel lblKysymys = new JLabel("Oletko?");
    private final JPanel panelValinta = new JPanel();
    private final JLabel lblValitse = new JLabel("Valitse");
    private final JRadioButton rb0 = new JRadioButton("Tytt\u00F6");
    private final JRadioButton rb1 = new JRadioButton("Poika");
    private final JRadioButton rb2 = new JRadioButton("Nainen");
    private final JButton btnAanesta = new JButton("\u00C4\u00E4nest\u00E4");
    private final Component verticalStrut = Box.createVerticalStrut(20);
    private final ButtonGroup groupAanestys = new ButtonGroup();
    private final JRadioButton rdbtnMies = new JRadioButton("Mies");
    
    SukupuoliOlio os = new SukupuoliOlio();

    /**
     * Launch the application.
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Aanestys frame = new Aanestys();
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
    public Aanestys() {
        setTitle("\u00C4\u00E4nestys");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 278, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        panelAanestys.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        contentPane.add(panelAanestys, BorderLayout.CENTER);
        panelAanestys.setLayout(new BoxLayout(panelAanestys, BoxLayout.Y_AXIS));
        lblKysymys.setFont(new Font("Arial", Font.PLAIN, 20));
        
        panelAanestys.add(lblKysymys);
        panelValinta.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
        
        panelAanestys.add(panelValinta);
        panelValinta.setLayout(new BoxLayout(panelValinta, BoxLayout.Y_AXIS));
        
        panelValinta.add(lblValitse);
        groupAanestys.add(rb0);
        rb0.setSelected(true);
        rb0.setMnemonic('T');
        
        panelValinta.add(rb0);
        groupAanestys.add(rb1);
        rb1.setMnemonic('P');
        
        panelValinta.add(rb1);
        groupAanestys.add(rb2);
        rb2.setMnemonic('N');
        
        panelValinta.add(rb2);
        groupAanestys.add(rdbtnMies);
        rdbtnMies.setMnemonic('M');
        
        panelValinta.add(rdbtnMies);
        
        panelAanestys.add(verticalStrut);
        btnAanesta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

                aanesta(os);
            }
        });
        
        panelAanestys.add(btnAanesta);
    }

     //// OMAT KOODIT  /////
    
    /**
     * Metodi äänestystä varten
     * @param os 
     */
    protected void aanesta(@SuppressWarnings("hiding") SukupuoliOlio os) {

        ButtonModel b = groupAanestys.getSelection();
        char nappain = (char)b.getMnemonic();
        String kohde = "";

            switch(nappain) {
            case 'T': kohde = "Tyttö"; os.setTytot(); break;
            case 'P': kohde = "Poika"; os.setPojat(); break;
            case 'N': kohde = "Nainen"; os.setNaiset(); break;
            case 'M': kohde = "Mies"; os.setMiehet(); break;
            default: break;
            }
            JOptionPane.showMessageDialog(null,"Olet siis " + kohde + "\nTilanne:\nTyttöjä: " + os.getTytot() + "\nPoikia: " + os.getPojat() + "\nNaisia: " + os.getNaiset() + "\nMiehiä: " + os.getMiehet());

        
    }
}

//    /**
//     * @param so 
//     * @param kohde on merkkijono
//     * 
//     */
//    public static void kutsu(SukupuoliOlio so, String kohde) {
//        
//        JOptionPane.setMessage("Olet siis " + kohde + "\nTilanne:\nTyttöjä: " + so.getTytot() );
//    }     
//+ "\nPoikia:" + getPojat + "\nNaisia:" + getNaiset + "\nMiehiä" + getMiehet
