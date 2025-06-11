package projeto_POO;
import java.util.ArrayList;

public class Zona {
	private String nomeZona;
	private ArrayList<Sensor> sensores;
	
	public String getNomeZona() {
		return nomeZona;
	}

	public void setNomeZona(String nomeZona) {
		this.nomeZona = nomeZona;
	}

	public ArrayList<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}

	public Zona(String nomeZona) {
		this.nomeZona = nomeZona;
		sensores = new ArrayList<Sensor>();
	}
	
	public void addSensor(Sensor novoSensor) {
		sensores.add(novoSensor);
	}
	
	 public void removerSensor(Sensor s) {
	        sensores.remove(s);
	    }
	 
	 // Métodos para ver as leituras
	
	public void verLeiturasZonas() {

		for (Sensor s : sensores) {
			s.verLeituras();
		}
	}
	
	public void verLeiturasZonasAgua() {
		
		for(Sensor s : sensores) {
			if(s.getTipo().equals("agua")) {
				s.verLeituras();
			}
		}
	}
	
	public void verLeiturasZonasEnergia() {
		
		for(Sensor s : sensores) {
			if(s.getTipo().equals("energia")) {
				s.verLeituras();
			}
		}
	}
	
	//Metodos para ver as somas dos consumos geral
	
	public double verSomaZonas() {
		
		double soma = 0;
	    for (Sensor s : sensores) {
	        soma += s.verLeiturasSomaSensor();
	        }
	    return soma;
	}
	
	public void verLeiturasSomaZonas() {
		
		System.out.println("Total da zona " + nomeZona + " (água e energia): " + verSomaZonas());
	}
	
	//Métodos para ver a soma do consumo de água
	
	public double verSomaZonaAgua() {
	    double soma = 0;
	    for (Sensor s : sensores) {
	        if (s.getTipo().equalsIgnoreCase("agua")) {
	            soma += s.verLeiturasSomaSensor();
	        }
	    }
	    return soma;
	}
	
	public void verLeiturasSomaZonaAgua() {
	    System.out.println("Total da zona " + nomeZona + " (água): " + verSomaZonaAgua());
	}
	
	//Métodos para ver a soma do consumo de energia
	
	public double verSomaZonaEnergia() {
	    double soma = 0;
	    for (Sensor s : sensores) {
	        if (s.getTipo().equalsIgnoreCase("energia")) {
	            soma += s.verLeiturasSomaSensor();
	        }
	    }
	    return soma;
	}
	
	public void verLeiturasSomaZonaEnergia() {
	    System.out.println("Total da zona " + nomeZona + " (energia): " + verSomaZonaEnergia());
	}
	
	public Sensor existeSensor(int idSensor) {
		for(Sensor s: sensores) {
			if(s.getId() == idSensor) {
				return s;
			}
		}
		return null;
	}
	
}
