package jsoup;

public class Horraire extends Cinema{

	private String horraire;
	private String nomFilm;
	
	public Horraire(Cinema cine, String horraire, String nomFilm) {
		super(cine);
		this.horraire = horraire;
		this.nomFilm = nomFilm;
	}

	public String getHorraire() {
		return horraire;
	}

	public void setHorraire(String horraire) {
		this.horraire = horraire;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	
	public void afficher() {
		System.out.println("  " + super.getName());
		System.out.println("    " + super.getDescription());
		System.out.println("      " + horraire);
	}

}
