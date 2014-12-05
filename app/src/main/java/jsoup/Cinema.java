package jsoup;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

	private String name;
	private String description;

	public Cinema() {
	}
	
	public Cinema(Cinema c) {
		this.name = c.getName();
		this.description = c.getDescription();
	}
	
	public Cinema(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void afficher() {
		System.out.println("  " + name);
		System.out.println("    " + description);
	}
	
//	public void addFilm(Film film) {
//		this.films.add(film);
//	}
//	
//	public void showFilm() {
//		for (int i = 0; i < films.size(); i++) {
//			System.out.println("     " + films.get(i).getName() + "  " + films.get(i).getTime());
//			System.out.println("     ---->" + films.get(i).getDescription());
//		}
//	}
}