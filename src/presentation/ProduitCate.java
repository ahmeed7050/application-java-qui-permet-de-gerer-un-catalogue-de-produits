package presentation;

public class ProduitCate {
	private int id;
	private String nom;
	private double prix;
	private int quantite;
	private String category;
	private static int cpt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProduitCate(int id, String nom, double prix, int quantite, String category) {
		this.id = ++cpt;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.category = category;
	}
	public ProduitCate(String nom, double prix, int quantite, String category) {
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.category = category;
	}
	public ProduitCate() {
		
	}
}
