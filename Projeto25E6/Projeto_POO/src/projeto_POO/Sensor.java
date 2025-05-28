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
	public Sensor(int id, int piso, String tipo, String zona, String edificio, String instituicao) {
		this.id = id;
		this.piso = piso;
		this.tipo = tipo;
		leituras = new ArrayList<Leitura>();
		this.zona = zona;
		this.edificio = edificio;
		this.instituicao = instituicao;
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
