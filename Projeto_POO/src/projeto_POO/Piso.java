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
	
	public String buscarZona(String nomeZona) {
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
