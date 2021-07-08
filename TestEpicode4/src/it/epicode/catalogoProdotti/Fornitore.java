package it.epicode.catalogoProdotti;

public class Fornitore {
	private long id;
	private String codiceFornitore;
	private String nome;
	private String indirizzo;
	private String citta;
	
	public Fornitore(long id, String codiceFornitore, String nome, String indirizzo, String citta) {
		this.id = id;
		this.codiceFornitore = codiceFornitore;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	public long getId() {
		return id;
	}
		
	public String getCodiceFornitore() {
		return codiceFornitore;
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	
	
	
	
}
