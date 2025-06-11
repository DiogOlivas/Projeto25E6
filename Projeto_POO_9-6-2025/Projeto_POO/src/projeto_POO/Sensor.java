package projeto_POO;

import java.util.ArrayList;

public class Sensor {
	private int id;
	private String tipo;
	private ArrayList<Leitura> leituras;
	private String zona;

	public Sensor(int id, String tipo, String zona) {
		this.id = id;
		this.tipo = tipo;
		this.zona = zona;
		leituras = new ArrayList<Leitura>();
	}
	
	
	
	public int getId() {
		return id;
	}
	
	public String getZona() {
		return zona;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setZona(String zona) {
		this.zona = zona;
	}

public void registrarLeitura(Leitura novaLeitura) {
		leituras.add(novaLeitura);
		
	}
	
	public void verLeituras() {
		for (Leitura l : leituras) {
			System.out.println(l.toString());
		}
		
	}
	
	public double verLeiturasSomaSensor() {
		double somaLeitura = 0;
		for(Leitura l : leituras) {
			somaLeitura += l.getValor();
		}
		return somaLeitura;
	}
	
	public void verSomaSensor() {
		
		System.out.println("Total do sensor " + id + ": " + verLeiturasSomaSensor());
	}
	
	
}
