package jsoup;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Actions {

    private Exception exception;

    private String url;
	public List<Cinema> getCinemas(String ville) {
		ConnectCinema cc = new ConnectCinema();
        List<Cinema> cinema = cc.launch(ville);
		return cinema;
	}

	public List<Horraire> getCinema(String ville, String film) {
		try {
			Document doc = Jsoup.connect(
					"http://www.google.fr/movies?hl=fr&near=" + ville + "&q="
							+ film).get();
			Elements elems = doc.getElementsByClass("theater");
			List<Horraire> cinemaFilm = new ArrayList<Horraire>();
			for (Element c : elems) {
				String name_cine = c.getElementsByClass("name").text();
				String desc_cine = c.getElementsByClass("address").text();
				String horraire_cine = c.getElementsByClass("times").text();
				Cinema cine = new Cinema(name_cine, desc_cine);
				Horraire cf = new Horraire(cine, horraire_cine, film);
				cinemaFilm.add(cf);
			}
			return cinemaFilm;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Film> getFilms(String ville) {
		try {
			Document doc = Jsoup.connect(
					"http://www.google.fr/movies?hl=fr&near=" + ville + "&sort=1").get();
			Elements elems = doc.getElementsByClass("desc");
			List<Film> film = new ArrayList<Film>();
			for (Element f : elems) {
				Film film_tmp = new Film();
				String name_film = f.select("[itemprop=name]").text();
				String desc_film = f.getElementsByClass("info").text();
				String syn_film = f.getElementsByClass("syn").text();
				film_tmp.setName(name_film);
				film_tmp.setDescription(desc_film);
				film_tmp.setSyn(syn_film);
				film.add(film_tmp);
			}
			return film;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
