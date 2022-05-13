
/**
* <p>Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII</p>
*
* @version 2014-03-13
*/

import java.awt.*;
import java.awt.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 11.03.2012
 * @author
 */

public class GUI extends Frame {
  // Anfang Attribute
  private TextField tfBez = new TextField();
  private TextField tfOrtkz = new TextField();
  private Label label1 = new Label();
  private Label label2 = new Label();
  private Button button1 = new Button();
  private Button button2 = new Button();
  private Button button4 = new Button();
  private Button button6 = new Button();

  Kennzvw baum = new Kennzvw();
  BaumZeichner zeichner;

  private Button button7 = new Button();
  private TextArea textArea1 = new TextArea("", 1, 1, TextArea.SCROLLBARS_BOTH);
  private Button button8 = new Button();
  // Ende Attribute

  public GUI(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        System.exit(0);
      }
    });
    int frameWidth = 299;
    int frameHeight = 497;
    setSize(frameWidth, frameHeight);
    setLocation(10, 20);
    setResizable(true);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten

    tfBez.setBounds(16, 40, 113, 33);
    cp.add(tfBez);
    tfOrtkz.setBounds(152, 40, 113, 33);
    cp.add(tfOrtkz);
    label1.setBounds(8, 8, 115, 25);
    label1.setText("Bezeichnung");
    cp.add(label1);
    label2.setBounds(152, 8, 107, 25);
    label2.setText("Ortskennzeichen");
    cp.add(label2);
    button1.setBounds(152, 88, 113, 33);
    button1.setLabel("Beispiel");
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button1_ActionPerformed(evt);
      }
    });
    cp.add(button1);
    button2.setBounds(16, 88, 113, 33);
    button2.setLabel("einfügen");
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button2_ActionPerformed(evt);
      }
    });
    cp.add(button2);
    button4.setBounds(16, 184, 113, 33);
    button4.setLabel("löschen");
    button4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button4_ActionPerformed(evt);
      }
    });
    cp.add(button4);
    button6.setBounds(168, 432, 113, 33);
    button6.setLabel("Ende");
    button6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button6_ActionPerformed(evt);
      }
    });
    button6.setBackground(new Color(0xEEEEFF));
    cp.add(button6);
    button7.setBounds(152, 136, 113, 33);
    button7.setLabel("leeren");
    button7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button7_ActionPerformed(evt);
      }
    });
    cp.add(button7);
    textArea1.setBounds(8, 232, 273, 185);
    cp.add(textArea1);
    button8.setBounds(152, 184, 115, 33);
    button8.setLabel("ausgeben");
    button8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button8_ActionPerformed(evt);
      }
    });
    cp.add(button8);
    // Ende Komponenten

    setVisible(true);
    zeichner = new BaumZeichner(600, 400, baum.gibBaum());
  }

  // Anfang Methoden
  public void button1_ActionPerformed(ActionEvent evt) {
    // Beispielbaum erzeugen
    baum = new Kennzvw();
    baum.ergaenze("F 412", "UN");
    baum.ergaenze("SD 478", "DO");
    baum.ergaenze("XD 999", "HA");
    baum.ergaenze("C 1423", "DO");
    baum.ergaenze("AW 78", "UN");
    baum.ergaenze("HG 1123", "UN");
    baum.ergaenze("LP 774", "H");
    baum.ergaenze("JA 0547", "AA");
    zeichner.zeigeBaum(baum.gibBaum());
  }

  public void button2_ActionPerformed(ActionEvent evt) {
    // Kennzeichen einfügen
    baum.ergaenze(tfBez.getText(), tfOrtkz.getText());
    zeichner.markiere(tfBez.getText() + tfOrtkz.getText());
    zeichner.zeigeBaum(baum.gibBaum());
  }

  public void button4_ActionPerformed(ActionEvent evt) {
    // l�schen
    baum.loesche(tfBez.getText(), tfOrtkz.getText());
    zeichner.zeigeBaum();
  }

  public void button6_ActionPerformed(ActionEvent evt) {
    // Ende
    System.exit(0);
  }

  public void button7_ActionPerformed(ActionEvent evt) {
    // Baum leeren
    baum.leereBaum();
    zeichner.zeigeBaum(baum.gibBaum());
  }

  public void button8_ActionPerformed(ActionEvent evt) {
    textArea1.append(baum.toString());
  } // end of button8_ActionPerformed

  // Ende Methoden

  public static void main(String[] args) {
    new GUI("Kennzeichensystem");
  }
}
