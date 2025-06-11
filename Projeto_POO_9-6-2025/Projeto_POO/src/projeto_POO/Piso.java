package projeto_POO;
import java.util.ArrayList;

public class Piso {
	private int numeroPiso;
	private ArrayList<Zona> zonas;

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<Zona> zonas) {
		this.zonas = zonas;
	}

	public Piso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
		zonas = new ArrayList<Zona>();
	}
	
	public void verLeituraPisos() {
		for(Zona z : zonas) {
			z.verLeiturasZonas();
		}
	}
	
	// Métodos para ver as leituras
	
	public void verLeiturasPisosAgua() {
		
		for(Zona z : zonas) {
			z.verLeiturasZonasAgua();
		}
	}
	
	public void verLeiturasPisosEnergia() {
		
		for(Zona z : zonas) {
			z.verLeiturasZonasEnergia();
		}
	}
	
	//Metodos para ver as somas dos consumos geral
	
	public double verSomaPisos() {
		
		double soma = 0;
	    for (Zona z : zonas) {
	        soma += z.verSomaZonas();
	        }
	    return soma;
	}
	
	public void verLeituraSomaPisos() {
		
		System.out.println("Total do piso " + numeroPiso + " (água e energia): " + verSomaPisos());
	}
	
	//Metodos para ver as somas dos consumos de água
	
	public double verSomaPisoAgua() {
		double soma = 0;
	    for (Zona z : zonas) {
	        soma += z.verSomaZonaAgua();
	    }
	    return soma;
	}
	
	public void verLeituraSomaPisosAgua() {
	    System.out.println("Total do piso " + numeroPiso + " (água): " + verSomaPisoAgua());
	}
	
	//Metodos para ver as somas dos consumos de energia
	
	public double verSomaPisoEnergia() {
		double soma = 0;
	    for (Zona z : zonas) {
	        soma += z.verSomaZonaEnergia();
	    }
	    return soma;
	}
	
	public void verLeituraSomaPisosEnergia() {
	    System.out.println("Total do piso " + numeroPiso + " (energia): " + verSomaPisoEnergia());
	}
	
	
	
	public String buscarEdificio(String nomeZona) {
		for(Zona i: zonas) {
			if(i.getNomeZona().equals(nomeZona)) {
				return i.getNomeZona();
			}
		}
		return null;
	}
	public void adicionarZona(Zona novoZona) {
		zonas.add(novoZona);
	}
	
	public Zona existeZona(String zonaNome) {
		for(Zona z: zonas) {
			if(z.getNomeZona().equals(zonaNome)) {
				return z;
			}
		}
		return null;
	}
}
