package dao;

import java.util.List;

import metier.entity.*;
import presentation.ProduitCate;

public interface IDaoCatalogue {
	boolean addCategory(Categorie c);
	void addProduit(ProduitCate p);
	List<String> getAllCategory();
	List<ProduitCate> getProduitPC(String c);
	List<ProduitCate> getProduitCate(String c);
}
