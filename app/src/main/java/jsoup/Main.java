package jsoup;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Actions a = new Actions();
		String ville = "Grenoble";
		String film = "Hunger Games";
		//List<Horraire> cf = new ArrayList<Horraire>(a.getCinema(ville, film));
		//System.out.println("Hunger Games");
		//for (int i = 0; i < cf.size(); i++) {
		//	cf.get(i).afficher();
		//}
		List<Horraire> cf = new ArrayList<Horraire>(a.getCinema(ville, film));
		for (int i = 0; i < cf.size(); i++) {
			cf.get(i).afficher();
		}
	}

}
