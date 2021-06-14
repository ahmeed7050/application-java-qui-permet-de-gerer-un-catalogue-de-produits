package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.entity.Categorie;
import presentation.ProduitCate;

public class CatalogueImp implements IDaoCatalogue {

	@Override
	public boolean addCategory(Categorie c) {
		Connection cx = SingletonConnection.geConnection();
		List<String> categories = getAllCategory();
		for (String nom : categories) {
			if (nom.equals(c.getNom())) {
				return false;
			}
		}
		try {
			PreparedStatement st = cx.prepareStatement("insert into category(nom) value(?)");
			st.setString(1, c.getNom());
			st.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return true;
		
	}

	@Override
	public void addProduit(ProduitCate p) {
		Connection cx = SingletonConnection.geConnection();
		int id = getCatId(p);
		try {
			PreparedStatement st = cx.prepareStatement("insert into produit(code_p, name, prix, quantite) value(?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, p.getNom());
			st.setDouble(3, p.getPrix());
			st.setInt(4, p.getQuantite());
			st.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public int getCatId(ProduitCate p) {
		Connection cx = SingletonConnection.geConnection();
		List<String> categories = getAllCategory();
		for (String nom : categories) {
			if (nom.equals(p.getCategory())) {
				try {
					PreparedStatement ps = cx.prepareStatement("select code from category where nom = ?");
					ps.setString(1, nom);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
						return rs.getInt(1);
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return 0;
	}

	@Override
	public List<String> getAllCategory() {
		Connection cx = SingletonConnection.geConnection();
		List<String> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select nom from category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(rs.getString(1));
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public List<ProduitCate> getProduitPC(String c) {
		Connection cx = SingletonConnection.geConnection();
		List<ProduitCate> liste = new ArrayList<>();
		PreparedStatement ps;
		try {
			if(c.equals("All")) {
				ps = cx.prepareStatement("SELECT p.id, p.name, p.prix, p.quantite, c.nom FROM category c LEFT JOIN produit p ON c.code = p.code_p");
			}else {
				ps = cx.prepareStatement("SELECT p.id, p.name, p.prix, p.quantite, c.nom FROM category c LEFT JOIN produit p ON c.code= p.code_p WHERE c.nom ="+"'"+c+"'");
			}
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProduitCate pc = new ProduitCate();
				pc.setId(rs.getInt(1));
				pc.setNom(rs.getString(2));
				pc.setPrix(rs.getDouble(3));
				pc.setQuantite(rs.getInt(4));
				pc.setCategory(rs.getString(5));
				liste.add(pc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
 
	@Override
	public List<ProduitCate> getProduitCate(String c) {
		Connection cx = SingletonConnection.geConnection();
		List<ProduitCate> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("SELECT p.id, p.name, p.prix, p.quantite, c.nom FROM category c LEFT JOIN produit p ON c.code = p.code_p");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProduitCate pc = new ProduitCate();
				pc.setId(rs.getInt(1));
				pc.setNom(rs.getString(2));
				pc.setPrix(rs.getDouble(3));
				pc.setQuantite(rs.getInt(4));
				pc.setCategory(rs.getString(5));
				liste.add(pc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

}
