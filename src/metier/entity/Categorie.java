package metier.entity;

public class Categorie {

		private int code;
		private String nom;
		private static int cpt;
		
		public Categorie(String nom) { 
			this.code = ++cpt;
			this.nom = nom;
		}
		public Categorie() {
			
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
		
}
