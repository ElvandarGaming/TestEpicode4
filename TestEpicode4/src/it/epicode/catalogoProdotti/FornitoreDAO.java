package it.epicode.catalogoProdotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornitoreDAO {
	
	private CreatoreConnessione conn;
	public static final String GET_FORNITORE_BY_ID = "SELECT id,codice_fornitore,nome,indirizzo,citta FROM negozio.fornitore WHERE id = ?";
	public static final String GET_ALL_FORNITORI = "SELECT id,codice_fornitore,nome,indirizzo,citta FROM negozio.fornitore";
	public static final String SAVE_FORNITORE = "INSERT INTO negozio.fornitore (id, codice_fornitore, nome, indirizzo, citta) values (?,?,?,?,?); ";
	public static final String UPDATE_FORNITORE = "UPDATE negozio.fornitore SET codice_fornitore=?, nome=?, indirizzo=?, citta=? WHERE id=?";
	public static final String DELETE_FORNITORE = "DELETE FROM negozio.fornitore WHERE id=?";
	public static final String GET_FORNITORI_BY_CITY = "SELECT id,codice_fornitore,nome,indirizzo,citta FROM negozio.fornitore WHERE citta = ?";

	public FornitoreDAO(CreatoreConnessione conn) {
		this.conn = conn;
	}

	public Fornitore get(long id) throws SQLException {
		Fornitore letto = null;
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(GET_FORNITORE_BY_ID);) {
			psta.setLong(1, id);
			try (ResultSet res = psta.executeQuery();) {
				while (res.next()) {
					letto = new Fornitore(res.getLong("id"), res.getString("codice_fornitore"), res.getString("nome"),
							res.getString("indirizzo"), res.getString("citta"));
				}
			}
		}
		return letto;
	}

	public List<Fornitore> getAll() throws SQLException {
		List<Fornitore> letto = new ArrayList<>();
		try (Connection x = conn.getConnection();
				Statement stat = x.createStatement();
				ResultSet res = stat.executeQuery(GET_ALL_FORNITORI);) {
			while (res.next()) {
				letto.add(new Fornitore(res.getLong("id"), res.getString("codice_fornitore"), res.getString("nome"),
						res.getString("indirizzo"), res.getString("citta")));
			}

		}
		return letto;
	}

	public void save(Fornitore forn) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(SAVE_FORNITORE);) {
			psta.setLong(1, forn.getId());
			psta.setString(2, forn.getCodiceFornitore());
			psta.setString(3, forn.getNome());
			psta.setString(4, forn.getIndirizzo());
			psta.setString(5, forn.getCitta());

			psta.executeUpdate();
		}
	}

	public void update(Fornitore forn) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(UPDATE_FORNITORE);) {
			psta.setString(1, forn.getCodiceFornitore());
			psta.setString(2, forn.getNome());
			psta.setString(3, forn.getIndirizzo());
			psta.setString(4, forn.getCitta());
			psta.setLong(5, forn.getId());

			psta.executeUpdate();
		}
	}

	public void delete(Fornitore forn) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(DELETE_FORNITORE);) {
			psta.setLong(1, forn.getId());

			psta.executeUpdate();
		}
	}
	public void delete(long id) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(DELETE_FORNITORE);) {
			psta.setLong(1, id);

			psta.executeUpdate();
		}
	}

	public List<Fornitore> getFornitoriPerCitta(String citta) throws SQLException {
		List<Fornitore> letto = new ArrayList<>();
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(GET_FORNITORI_BY_CITY);) {
			psta.setString(1, citta);
			try (ResultSet res = psta.executeQuery();) {
				while (res.next()) {
					letto.add(new Fornitore(res.getLong("id"), res.getString("codice_fornitore"), res.getString("nome"),
							res.getString("indirizzo"), res.getString("citta")));
				}
			}

		}
		return letto;
	}
}
