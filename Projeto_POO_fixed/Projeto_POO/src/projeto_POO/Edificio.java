package projeto_POO;
import java.util.ArrayList;

public class Edificio {
	private String nome;
	private ArrayList<Piso> pisos;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(ArrayList<Piso> pisos) {
		this.pisos = pisos;
	}

	public Edificio(String nome) {
		this.nome = nome;
		pisos = new ArrayList<Piso>();
	}
	
	public void verLeiturasEdificio(){
		for(Piso p : pisos) {
			p.verLeituraPisos();
		}
	}
	
	public int buscarPiso(int numPiso) {
		for(Piso i : pisos) {
			if(i.getNumeroPiso() == numPiso) {
				return i.getNumeroPiso();
			}
		}
		return 0;
	}
	public void adicionarPiso(Piso novoPiso) {
		pisos.add(novoPiso);
	}
	public void addZona(int numPiso, Zona zona) {
		for(Piso i: pisos) {
    		if(i.getNumeroPiso() == numPiso) {
    			i.adicionarZona(zona);
    		}
    	}
	}
	
	public Piso existePiso(int numPiso) {
		for(Piso p: pisos) {
    		if(p.getNumeroPiso() == numPiso) {
    			return p;
    		}
    	}
		return null;
	}
}
