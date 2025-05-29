package projeto_POO;

import java.util.ArrayList;

public class Sensor {
	private int id;
	private int piso;
	private String tipo;
	private ArrayList<Leitura> leituras;
	private String zona;
	private String edificio;
	private String instituicao;
	/**
	 * @param nome
	 * @param piso
	 * @param tipo
	 * @param leituras
	 * @param zona
	 */
	public Sensor(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
		leituras = new ArrayList<Leitura>();
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

public void registrarLeitura(Leitura novaLeitura) {
		leituras.add(novaLeitura);
		
	}
	
	public void verLeituras() {
		for (Leitura l : leituras) {
			System.out.println(l.toString());
		}
		
	}
	
	
}
