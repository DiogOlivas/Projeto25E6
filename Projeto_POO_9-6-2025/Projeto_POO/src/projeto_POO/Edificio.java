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
	
	// Métodos para ver as leituras
	
	public void verLeiturasEdificio(){
		for(Piso p : pisos) {
			p.verLeituraPisos();
		}
	}
	
	public void verLeiturasEdificioAgua() {
		for(Piso p : pisos) {
			p.verLeiturasPisosAgua();
		}
	}
	
	public void verLeiturasEdificioEnergia() {
		for(Piso p : pisos) {
			p.verLeiturasPisosEnergia();
		}
	}
	
	//Metodos para ver as somas dos consumos geral
	
	public double verSomaEdificios() {
		
		double soma = 0;
	    for (Piso p : pisos) {
	        soma += p.verSomaPisos();
	        }
	    return soma;
	}

	public void verLeituraSomaEdificios() {
		
		System.out.println("Total do edifício " + nome + " (água e energia): " + verSomaEdificios());
	}
	
	//Metodos para ver as somas dos consumos de água
	
	public double verSomaEdificioAgua() {
		double soma = 0;
	    for (Piso p : pisos) {
	        soma += p.verSomaPisoAgua();
	    }
	    return soma;
	}
	
	public void verLeituraSomaEdificioAgua(){
		
		System.out.println("Total do edifício " + nome + " (água): " + verSomaEdificioAgua());
	}
	
	//Metodos para ver as somas dos consumos de energia
	
	public double verSomaEdificioEnergia() {
		double soma = 0;
	    for (Piso p : pisos) {
	        soma += p.verSomaPisoEnergia();
	    }
	    return soma;
	}
	
	public void verLeituraSomaEdificioEnergia() {
		
		System.out.println("Total do edifício " + nome + " (energia): " + verSomaEdificioEnergia());
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
