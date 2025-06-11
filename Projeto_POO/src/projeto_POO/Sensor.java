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
			System.out.println();
		}
		
	}
	    ArrayList<Leitura> leituras = sensor.getLeituras();
	    double soma = 0;
	    int count = 0;

	    for (Leitura l : leituras) {
	        String tipo = sensor.getTipo(); // tipo está no sensor
	        if (tipoLeitura == 1 && tipo.equalsIgnoreCase("água")) {
	            soma += l.getValor();
	            count++;
	        } else if (tipoLeitura == 2 && tipo.equalsIgnoreCase("energia")) {
	            soma += l.getValor();
	            count++;
	        } else if (tipoLeitura == 3) {
	            soma += l.getValor();
	            count++;
	        }
	    }

	    return soma / count;
	}
	
	public double verLeiturasSoma() {
		double somaLeitura = 0;
		for(Leitura l : leituras) {
			somaLeitura += l.getValor();
		}
		return somaLeitura;
	}
	
	
}
