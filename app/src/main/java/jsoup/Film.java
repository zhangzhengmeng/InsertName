package jsoup;

public class Film {

	private String name;
	private String description;
	private String syn;
	private String time;

	public Film() {
	}
	
	public Film(String name, String description, String time) {
		this.name = name;
		this.description = description;
		this.time = time;
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
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getSyn() {
		return syn;
	}
	
	public void setSyn(String syn) {
		this.syn = syn;
	}
	
	public void afficher() {
		System.out.println("  " + name);
		System.out.println("    " + description);
		if (syn != null) {
			System.out.println("      " + syn);
		}
	}
}