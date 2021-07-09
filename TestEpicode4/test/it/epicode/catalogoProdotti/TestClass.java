package it.epicode.catalogoProdotti;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClass {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("avvio");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("arresto");
	}

	@Test
	void eliminazioneFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);
		Fornitore marchi2 = new Fornitore(2, "X123", "Marchi", "Via verdi,3", "Verona");
		try {
			t.delete(marchi2);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Inserito Marchi");

	}

	@Test
	void inserimentoFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);
		// Fornitore marchi = new Fornitore(1, "X123", "Marchi", "Via verdi,3",
		// "Verona");
		Fornitore marchi2 = new Fornitore(2, "X143", "Marchi", "Via verdi,3", "Verona");
		//Fornitore rogi = new Fornitore(3, "y163", "Rogi", "Via lincoln,46", "Padova");
		try {

			t.save(marchi2);
			//t.save(rogi);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato Marchi");
	}

	@Test
	void getFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			Fornitore ciccio = t.get(1);
			System.out.println(ciccio.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Fornitore restituito");
	}

	@Test
	void eliminazioneFornitoreById() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			t.delete(5);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato fornitore con id 5");
	}

	@Test
	void getAllFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			List<Fornitore> ciccio = t.getAll();
			ciccio.forEach(f -> System.out.println(f.getNome()));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista Fornitore restituito");
	}

	@Test
	void updateFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);
		//Fornitore marchi2 = new Fornitore(2, "X143", "Marchi", "Via verdi,3", "Verona");
		Fornitore rogi = new Fornitore(3, "Y666", "Rogi", "Via lincoln,46", "Padova");
		try {

			t.update(rogi);
			Fornitore upd = t.get(rogi.getId());
			System.out.println(upd.getCodiceFornitore());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato Marchi");
	}

	@Test
	void getCittaFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			List<Fornitore> ciccio = t.getFornitoriPerCitta("Padova");
			ciccio.forEach(f -> System.out.println(f.getNome()));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista Fornitore per citta restituito");
	}

	@Test
	void prodottiDaFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "sax");
		ProdottoDAO t = new ProdottoDAO(portal);
		Fornitore rogi = new Fornitore(3, "Y666", "Rogi", "Via lincoln,46", "Padova");
		try {
			List<Prodotto> list = t.getProdottoPerFornitore(rogi);
			list.forEach(f -> System.out.println(f.getNome()));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista prodotti per fornitore restituita");
	}

}
