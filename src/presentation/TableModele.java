package presentation;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Produit;
import dao.*;
public class TableModele extends AbstractTableModel {
	
	private String titres[]= {"id","Nom","Prix","Quantité","Categorie"};
	private List<ProduitCate> liste;
	IDaoCatalogue action = new CatalogueImp();
	public TableModele(){
		liste=new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titres.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch(c)
		{
		case 0:return liste.get(l).getId();
		case 1:return liste.get(l).getNom();
		case 2:return liste.get(l).getPrix();
		case 3:return liste.get(l).getQuantite();
		case 4:return liste.get(l).getCategory();
		
		}
		return null;
	}
	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	
	public void chargerTable(List<ProduitCate>liste)
	{
		this.liste=liste;
		fireTableDataChanged();
	}

}
