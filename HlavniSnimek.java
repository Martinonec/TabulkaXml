
package net.codejava.xmldatab;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author nitra
 */
public class HlavniSnimek extends javax.swing.JFrame {

    /**
     * Creates new form HlavniSnimek
     */
    public HlavniSnimek() {
     initComponents();
     
        //vyjímka ukazTab() / důvod práce s Xml dokumentem
        try { 
            ukazTab();
        } catch (SAXException | IOException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // metoda která ukáže daný řádek
    public void ukazRadek(){
        int index = Table_Hlavni.getSelectedRow() ;
        
         try {
             //Zadání cesty dokumentu xml
             File cesta = new File("C:\\Programy-java\\XmlDatab\\src\\main\\java\\net\\codejava\\xmldatab/Hodnoty.xml");
             //vytovření třídy pro otevření a další praci s xml 
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
             DocumentBuilder db = dbf.newDocumentBuilder();
             Document docum = db.parse(cesta);
          
             // přiřazení elementů (všech druhu zbozi) do listu
            NodeList nList = docum.getElementsByTagName("zbozi");
                Node nNode = nList.item(index);
                // zajištujě průchod celým dokumentem xml
                
                    Element nElement = (Element) nNode;
        // přiřad´í daný rext do daného textovéhopole
        TextField_ID.setText(nElement.getElementsByTagName("id").item(index).getTextContent());
        TextField_Cena.setText(nElement.getElementsByTagName("cena").item(index).getTextContent());
        TextField_Kus1.setText(nElement.getElementsByTagName("mnozstvi").item(index).getTextContent());
        TextField_Model.setText(nElement.getElementsByTagName("nazev").item(index).getTextContent());
        TextField_Vyrob.setText(nElement.getElementsByTagName("vyrobce").item(index).getTextContent());
        
                
         
        }catch (IOException |SAXException |ParserConfigurationException ex) {
             Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
     // metoda na spojení tabulky a xml a její zobrazení v akci
    private void ukazTab() throws SAXException, IOException {
        
         try {
             //Zadání cesty dokumentu xml
             File cesta = new File("C:\\Programy-java\\XmlDatab\\src\\main\\java\\net\\codejava\\xmldatab/Hodnoty.xml");
             //vytovření třídy pro otevření a další praci s xml 
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
             DocumentBuilder db = dbf.newDocumentBuilder();
             Document docum = db.parse(cesta);
             //kontrolní výstup
            // System.out.println("Kořenový element :" + docum.getDocumentElement().getNodeName());
             // přiřazení elementů (všech druhu zbozi) do listu
            NodeList nList = docum.getElementsByTagName("zbozi");
            //kontrolní výstup
           // System.out.println("---------");
            
            //zpracování Tabule / vytvoření Pole objectu pro následný z zpracování do jednotlivých kolomek
            DefaultTableModel model = (DefaultTableModel) Table_Hlavni.getModel();
            model.setRowCount(0);
            Object[] row = new Object[5];   // 5 kolomek
            
            // cyklus který podle velikosti (veškerého zboží) přiřadí do jednotlivých kolonek údaj
        for (int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                //System.out.println("\nKonkretní element :"+ nNode.getNodeName());
                
                // zajištujě průchod celým dokumentem xml
                if (nNode.getNodeType()== Node.ELEMENT_NODE){
                    Element nElement = (Element) nNode;
                    // kontrolní výstupy
//                    System.out.println("zbozi :" + nElement.getAttribute("zbozi"));
//                    System.out.println("Cena zbozi : "+nElement.getElementsByTagName("cena").item(0).getTextContent());
//                    System.out.println("Nazev produktu: "+nElement.getElementsByTagName("nazev").item(0).getTextContent());
//                    System.out.println("Počet kusů: "+nElement.getElementsByTagName("mnozstvi").item(0).getTextContent());
//                    System.out.println("ID produktu je číslo : " + nElement.getElementsByTagName("id").item(0).getTextContent());
//                    System.out.println("Výrobce je : "+ nElement.getElementsByTagName("vyrobce").item(0).getTextContent());
                    // zde se přidělujou hodnoty do pole Object []
                    row[4] =(nElement.getElementsByTagName("cena").item(0).getTextContent());
                    row[1] =(nElement.getElementsByTagName("vyrobce").item(0).getTextContent());
                    row[3] = (nElement.getElementsByTagName("mnozstvi").item(0).getTextContent());
                    row[0] = (nElement.getElementsByTagName("id").item(0).getTextContent());
                    row[2] = (nElement.getElementsByTagName("nazev").item(0).getTextContent());
                    // přiřazení kolomek do Tabule
                    model.addRow(row);
                    
                }
        }
        
        
        // vyjímky
         }catch (ParserConfigurationException ex) {
             Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HlavniPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextField_ID = new javax.swing.JTextField();
        TextField_Vyrob = new javax.swing.JTextField();
        TextField_Model = new javax.swing.JTextField();
        TextField_Cena = new javax.swing.JTextField();
        TextField_Kus1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Hlavni = new javax.swing.JTable();
        Button_Pridej = new javax.swing.JButton();
        Button_Vymaz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("ID produktu");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Výrobce");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Kusů");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Cena");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Název / Model");

        TextField_ID.setText("Id produktu");
        TextField_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_IDActionPerformed(evt);
            }
        });

        TextField_Vyrob.setText("vyrobce");

        TextField_Model.setText("model a druh");

        TextField_Cena.setText("cena nákupní");
        TextField_Cena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CenaActionPerformed(evt);
            }
        });

        TextField_Kus1.setText("mnozstvi");

        Table_Hlavni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Výrobce", "Název/Model", "Kusy", "Cena"
            }
        ));
        Table_Hlavni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_HlavniMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Hlavni);

        Button_Pridej.setBackground(new java.awt.Color(51, 255, 51));
        Button_Pridej.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Button_Pridej.setForeground(new java.awt.Color(0, 0, 0));
        Button_Pridej.setText("Přidej nový produkt");
        Button_Pridej.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_PridejMouseClicked(evt);
            }
        });

        Button_Vymaz.setBackground(new java.awt.Color(255, 51, 51));
        Button_Vymaz.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Button_Vymaz.setForeground(new java.awt.Color(0, 0, 0));
        Button_Vymaz.setText("Smaž produkt");
        Button_Vymaz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_VymazMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HlavniPanelLayout = new javax.swing.GroupLayout(HlavniPanel);
        HlavniPanel.setLayout(HlavniPanelLayout);
        HlavniPanelLayout.setHorizontalGroup(
            HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HlavniPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Vyrob, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Model, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Kus1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Cena, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(HlavniPanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(Button_Pridej, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_Vymaz, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        HlavniPanelLayout.setVerticalGroup(
            HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HlavniPanelLayout.createSequentialGroup()
                .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HlavniPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextField_ID)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_Vyrob, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_Model, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_Kus1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextField_Cena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(HlavniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Pridej, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Vymaz, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HlavniPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HlavniPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_IDActionPerformed

    private void Button_PridejMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_PridejMouseClicked
        // předání obsahu napsaného TextFieldu do řetězce
        String cenaS = TextField_Cena.getText();
        String nazevS = TextField_Model.getText();
        String vyrobceS = TextField_Vyrob.getText();
        String idS = TextField_ID.getText();
        String mnozstviS = TextField_Kus1.getText();
        // způsob zapisování do Xml dokumentu
        try {
            File cestaXml = new File("C:\\Programy-java\\XmlDatab\\src\\main\\java\\net\\codejava\\xmldatab/Hodnoty.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document docum = db.parse(cestaXml);
            
          
            Element root = docum.getDocumentElement();
            Element zbozi = docum.createElement("zbozi");
            root.appendChild(zbozi);
        
        for (int i = 1; i <= 3; i++) {
            //vytvoří element 
            Element id = docum.createElement("id");
            Element nazev = docum.createElement("nazev");
            Element cena = docum.createElement("cena");
            Element vyrobce = docum.createElement("vyrobce");
            Element mnoz = docum.createElement("mnozstvi");
            //přídá do daného elementu text z textového pole
            id.appendChild(docum.createTextNode(idS));
            nazev.appendChild(docum.createTextNode(nazevS));
            cena.appendChild(docum.createTextNode(cenaS));
            vyrobce.appendChild(docum.createTextNode(vyrobceS));
            mnoz.appendChild(docum.createTextNode(mnozstviS));
           // přidá to vše do zbozi
            zbozi.appendChild(id);
            zbozi.appendChild(nazev);
            zbozi.appendChild(cena);
            zbozi.appendChild(vyrobce);
            zbozi.appendChild(mnoz);
            
        }
        // uložení změnu dokumentu
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource domSource = new DOMSource(docum);
        StreamResult streamResult = new StreamResult((cestaXml));
        transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ukaž obsah v tabuly
    try { 
            ukazTab();
        } catch (SAXException | IOException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_Button_PridejMouseClicked

    private void Button_VymazMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_VymazMouseClicked
        // vymazání vybraného typu zbozi
        //cesta
        File cesta = new File("C:\\Programy-java\\XmlDatab\\src\\main\\java\\net\\codejava\\xmldatab/Hodnoty.xml");
        // Dom tvořítka
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document docum = db.parse(cesta);
        
        // určený řádek
        int index = Table_Hlavni.getSelectedRow();
        //zkušební výstup
        System.out.println(index);
        
        // je třeba podle určeného řádku (indexem) zvolit daný zboží v xml dokumentu
        
        // rozhraní NodeList přebírá elementy 
        NodeList list = docum.getElementsByTagName("zbozi");
        // přiřadíme kopnkretní zboží podle indexu 
        Node jedine = list.item(index);
     
        // 
           Element nElement = (Element) jedine;
                    // kontrolní výstupy
//                    System.out.println("zbozi :" + nElement.getAttribute("zbozi"));
//                    System.out.println("Cena zbozi : "+nElement.getElementsByTagName("cena").item(0).getTextContent());
//                    System.out.println("Nazev produktu: "+nElement.getElementsByTagName("nazev").item(0).getTextContent());
//                    System.out.println("Počet kusů: "+nElement.getElementsByTagName("mnozstvi").item(0).getTextContent());
//                    System.out.println("ID produktu je číslo : " + nElement.getElementsByTagName("id").item(0).getTextContent());
//                    System.out.println("Výrobce je : "+ nElement.getElementsByTagName("vyrobce").item(0).getTextContent());
        
         
         // vymazání podle indexu
         docum.getDocumentElement().removeChild(jedine);
         // uložení změnu dokumentu
         TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource domSource = new DOMSource(docum);
        StreamResult streamResult = new StreamResult((cesta));
        transformer.transform(domSource, streamResult);
         
        // aktulizace tabulky
        ukazTab();
        
        }catch (SAXException e ) {Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE,null, e);}
        catch (IOException e) {Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE,null,e);}
        catch (ParserConfigurationException e ){Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE,null,e);} catch (TransformerConfigurationException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_Button_VymazMouseClicked

    private void Table_HlavniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_HlavniMouseClicked
        ukazRadek();
    }//GEN-LAST:event_Table_HlavniMouseClicked

    private void TextField_CenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_CenaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new HlavniSnimek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Pridej;
    private javax.swing.JButton Button_Vymaz;
    private javax.swing.JPanel HlavniPanel;
    private javax.swing.JTable Table_Hlavni;
    private javax.swing.JTextField TextField_Cena;
    private javax.swing.JTextField TextField_ID;
    private javax.swing.JTextField TextField_Kus1;
    private javax.swing.JTextField TextField_Model;
    private javax.swing.JTextField TextField_Vyrob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
