package it.epicode.catalogoProdotti;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

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
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4", "negozio", "postgres",
				"sax");
		FornitoreDAO t = new FornitoreDAO(portal);
		Fornitore marchi = new Fornitore(1, "X123", "Marchi", "Via verdi,3", "Verona");
		try {
			t.delete(marchi);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Inserito Marchi");
		
	}
	
	@Test
	void inserimentoFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4", "negozio", "postgres",
				"sax");
		FornitoreDAO t = new FornitoreDAO(portal);
		Fornitore marchi = new Fornitore(1, "X123", "Marchi", "Via verdi,3", "Verona");
		try {
			
			t.save(marchi);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato Marchi");
	}
	
	
	
	@Test
	void eliminazioneFornitoreById() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4", "negozio", "postgres",
				"sax");
		FornitoreDAO t = new FornitoreDAO(portal);
		
		try {
			t.delete(5);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato fornitore con id 5");
	}

}
