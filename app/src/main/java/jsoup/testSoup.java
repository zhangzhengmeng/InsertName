package jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testSoup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String ville = "Grenoble";
			Document doc = Jsoup.connect(
					"http://www.google.fr/movies?hl=fr&near=" + ville + "&q=cinema")
					.get();
			Elements elems = doc.getElementsByClass("theater");
			List<Cinema> cinema = new ArrayList<Cinema>();
			for (Element elem : elems) {
				Elements cine = elem.getElementsByClass("desc");
				Elements films = elem.getElementsByClass("movie");
				Cinema cine_tmp = new Cinema();
				for (Element c : cine) {
					String  name_cine = c.getElementsByClass("name").text();
					String  desc_cine = c.getElementsByClass("info").text();
					cine_tmp.setName(name_cine);
					cine_tmp.setDescription(desc_cine);
				}
				for (Element f : films) {
					String name_film = f.getElementsByClass("name").text();
					String desc_film = f.getElementsByClass("info").text();
					String time_film = f.getElementsByClass("times").text();
					Film movie = new Film(name_film, desc_film, time_film);
//					cine_tmp.addFilm(movie);
				}
				cinema.add(cine_tmp);
				
			}
			for (int i = 0; i < cinema.size(); i++) {
//				System.out.println(cinema.get(i).getName());
//				cinema.get(i).showFilm();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
