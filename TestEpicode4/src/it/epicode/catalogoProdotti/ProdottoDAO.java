package it.epicode.catalogoProdotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

	public static final String GET_PRODOTTO_FROM_FORNITORE = "SELECT a.id as prod_id,a.codice_prodotto,a.nome as prod_name,a.descrizione,a.marca,a.codice_fornitore_fk,a.prezzo,\r\n"
			+ "b.id as forn_id,b.codice_fornitore,b.nome as forn_name,b.indirizzo,b.citta FROM negozio.prodotto a INNER JOIN negozio.fornitore b ON a.codice_fornitore_fk= b.codice_fornitore\r\n"
			+ "WHERE b.id = ?";
	private CreatoreConnessione conn;

	public ProdottoDAO(CreatoreConnessione conn) {
		this.conn = conn;
	}

	public List<Prodotto> getProdottoPerFornitore(Fornitore forn) throws SQLException {
		List<Prodotto> lista = new ArrayList<>();
		try (Connection x = conn.getConnection();
				PreparedStatement psta = x.prepareStatement(GET_PRODOTTO_FROM_FORNITORE);) {
			psta.setLong(1, forn.getId());

			try (ResultSet res = psta.executeQuery();) {
				while (res.next()) {
					lista.add(new Prodotto(res.getLong("prod_id"), res.getString("codice_prodotto"),
							res.getString("prod_name"), res.getString("descrizione"), res.getString("marca"),
							new Fornitore(res.getLong("forn_id"), res.getString("codice_fornitore"),
									res.getString("forn_name"), res.getString("indirizzo"), res.getString("citta")),
							res.getBigDecimal("prezzo")));
				}
			}
		}

		return lista;
	}
}
