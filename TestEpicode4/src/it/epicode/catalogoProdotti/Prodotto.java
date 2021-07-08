package it.epicode.catalogoProdotti;

import java.math.BigDecimal;

public class Prodotto {
	private long id;
	private String codiceProdotto;
	private String nome;
	private String descrizione;
	private String marca;
	private Fornitore fornitore;
	private BigDecimal prezzo ;
	
	
	public Prodotto(long id, String codiceProdotto, String nome, String descrizione, String marca, Fornitore fornitore,
			BigDecimal prezzo) {
		this.id = id;
		this.codiceProdotto = codiceProdotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.marca = marca;
		this.fornitore = fornitore;
		this.prezzo = prezzo;
	}

	public long getId() {
		return id;
	}

	public String getCodiceProdotto() {
		return codiceProdotto;
	}


	public String getNome() {
		return nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public String getMarca() {
		return marca;
	}


	public Fornitore getFornitore() {
		return fornitore;
	}


	public BigDecimal getPrezzo() {
		return prezzo;
	}
	
	
	
}
