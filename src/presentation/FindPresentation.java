package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.CatalogueImp;
import dao.IDaoCatalogue;

public class FindPresentation extends JFrame{
	
	JLabel slt = new JLabel("Selectionner une catégorie"); 
	JComboBox<String> cb=new JComboBox<String>(new String[] {"All"});
	
	TableModele tm=new TableModele();
	JTable tableau=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableau);
	
	JButton quitter=new JButton("quitter");

	JPanel haut = new JPanel(new FlowLayout());

	JPanel bas = new JPanel();
	
	IDaoCatalogue gestion = new CatalogueImp();
	
	public FindPresentation() {
		this.setTitle("Rechercher produit");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		

		List<String> list = (List<String>) gestion.getAllCategory();
		ajouAuCombo(list);
		
		haut.add(slt);
		haut.add(cb);
		
		bas.add(quitter);
		
		
		add(haut, BorderLayout.NORTH); 
		add(jsp, BorderLayout.CENTER);
		add(bas, BorderLayout.SOUTH);
		
		pack();
		
		List<ProduitCate> liste = gestion.getProduitPC("All");
		tm.chargerTable(liste);
		
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		    	String catl =(String)cb.getSelectedItem();
			    List<ProduitCate> liste = gestion.getProduitPC(catl);
				tm.chargerTable(liste);
				
			}
		});
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
	
	private void ajouAuCombo(List<String> list) {
		for (String nom : list) {
			cb.addItem(nom);
		}
	}
	
	public static void main(String[] args) {
		new FindPresentation();
	}
}
