package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import dao.CatalogueImp;
import dao.IDaoCatalogue;

public class AddPresentation extends JFrame {
	
	JLabel lnom=new JLabel("Nom:");
	JLabel lPrix=new JLabel("Prix:");
	JLabel lCategorie=new JLabel("Categorie:");
	JLabel lQuantite=new JLabel("Quantité:");
	
	JTextField tnom=new JTextField(10);
	JTextField tPrix=new JTextField(10);
	JTextField tQuantite=new JTextField(10);
	
	JButton bajouter=new JButton("Ajouter");
	JButton bretour=new JButton("Retour");
	JButton breload=new JButton("Actualiser");
	
	JLabel addCatego=new JLabel("ajouter une catégorie");
	
	JComboBox<String> cb=new JComboBox<String>(new String[] {});;
	
	JPanel p1=new JPanel(new BorderLayout());
	JPanel p2=new JPanel(new BorderLayout());
	JPanel p3=new JPanel(new GridLayout(2, 2));
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	JPanel p6=new JPanel(new GridLayout(1, 1));
	JPanel pnom=new JPanel();
	JPanel pPrix=new JPanel();
	JPanel pCategorie=new JPanel();
	JPanel pQuantite=new JPanel();
	
	IDaoCatalogue gestion = new CatalogueImp();
	
	
	public AddPresentation() {
		
		super("Gestion Produit");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,300);
		setLayout(new GridLayout(2, 1));
		
		pnom.add(lnom);
		pnom.add(tnom);
		
		pPrix.add(lPrix);
		pPrix.add(tPrix);
		
		pCategorie.add(lCategorie);
		pCategorie.add(cb);
		
		pQuantite.add(lQuantite);
		pQuantite.add(tQuantite);
		
	    
	    p3.add(pnom);
	    p3.add(pPrix);
	    p3.add(pQuantite);
	    p3.add(pCategorie);
	    p3.add(addCatego);
	    
	    
		Font font = addCatego.getFont();
	    Map attributes = font.getAttributes();
	    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    addCatego.setFont(font.deriveFont(attributes));
	    
	    p1.add(p3);
	    p4.add(bajouter);
	    p4.add(bretour);
	    p4.add(breload);
	    
	    p1.add(p4,BorderLayout.SOUTH);
	    
	    p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Ajouter Produit"));
	    add(p1);
	    
	    
	    p2.add(p5,BorderLayout.NORTH);
	    
	   add(p4);
	   
	   List<String> list = (List<String>) gestion.getAllCategory();
	   ajouAuCombo(list);
		
	    
	   addCatego.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AddCategory();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addCatego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}


			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
       });
	   
	   bajouter.addActionListener(e->{
	    	
	    	String nom= tnom.getText();
	    	Double prix= Double.parseDouble(tPrix.getText());
	    	int quantite=Integer.parseInt(tQuantite.getText());
	    	String category=(String)cb.getSelectedItem();
	    	
	    
    		int res=JOptionPane.showConfirmDialog(this, 
    				"Nom: "+nom
    				+"\nprix:  "+prix
    				+"\n quantite:   "+quantite
    				+"\n filiere: "+category
    				+"\n\n Voulez vous ajouter cet etudiant?",
    				"Confirmation",JOptionPane.YES_NO_OPTION );				
    				
    				
    		if(res==0) {		
	    		ProduitCate p=new ProduitCate(nom, prix, quantite, category);
	    		gestion.addProduit(p);
    		
    		
	    	}
	    			
	    	
	    });
	   bretour.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new Presentation();
			dispose();
		}
	   });
	   breload.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			 cb.removeAllItems();
			 List<String> list = (List<String>) gestion.getAllCategory();
			 ajouAuCombo(list);
		}
	   });
	  	
		
	}
	private void ajouAuCombo(List<String> list) {
		for (String nom : list) {
			cb.addItem(nom);
		}
	}
	public static void main(String[] args) {
		new AddPresentation();
	}
	
}
