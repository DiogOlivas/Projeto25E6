package projeto_POO;
import java.util.ArrayList;

public class Instituicao {
	private String nome;
	private ArrayList<Edificio> edificios;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Edificio> getEdificios() {
		return edificios;
	}

	public void setEdificios(ArrayList<Edificio> edificios) {
		this.edificios = edificios;
	}

	public Instituicao(String nome) {
		this.nome = nome;
		edificios = new ArrayList<Edificio>();
	}
	
	public void adicionarEdificio(Edificio novoEdificio) {
		edificios.add(novoEdificio);
	}
	
	// Métodos para ver as leituras
	
	public void verLeituraInstituicao() {
		for(Edificio e : edificios) {
			e.verLeiturasEdificio();
		}
	}
	
	public void verLeituraInstituicaoAgua() {
		for(Edificio e : edificios) {
			e.verLeiturasEdificioAgua();
		}
	}
	
	public void verLeiturasInstituicaoEnergia() {
		for(Edificio e : edificios) {
			e.verLeiturasEdificioEnergia();
		}
	}
	
	//Metodos para ver as somas dos consumos geral
	
	public double verSomaInstituicoes() {
		
		double soma = 0;
	    for (Edificio e : edificios) {
	        soma += e.verSomaEdificios();
	        }
	    return soma;
	}

	public void verLeituraSomaInstituicoes() {
		
		System.out.println("Total do edifício " + nome + " (água e energia): " + verSomaInstituicoes());
	}
	
	//Metodos para ver as somas dos consumos de água
	
	public double verSomaInsituicaoAgua() {
		double soma = 0;
	    for (Edificio e : edificios) {
	        soma += e.verSomaEdificioAgua();
	    }
	    return soma;
	}
	
	public void verLeituraSomaInstituicaoAgua() {
		
		System.out.println("Total da instituição " + nome + " (água): " + verSomaInsituicaoAgua());
	}
	
	//Metodos para ver as somas dos consumos de energia
	
	public double verSomaInsituicaoEnergia() {
		double soma = 0;
	    for (Edificio e : edificios) {
	        soma += e.verSomaEdificioEnergia();
	    }
	    return soma;
	}
	
	public void verLeituraSomaInstituicaoEnergia() {
		
		System.out.println("Total da instituição " + nome + " (energia): " + verSomaInsituicaoEnergia());
	}
	
	public Edificio buscarEdificio(String nomeed) {
		for(Edificio e: edificios) {
			if(e.getNome().equals(nomeed)) {
				return e;
			}
		}
		return null;
	}
	
	public Edificio existeEdificio(String nomeEdificio) {
		for(Edificio e: edificios) {
    		if(e.getNome().equalsIgnoreCase(nomeEdificio)) {
    			return e;
    		}
    	}
		return null;
	}	
    	
    			
	public void addPiso(String nomeEdi, Piso novoPiso) {
		for(Edificio i: edificios) {
    		if(i.getNome().equals(nomeEdi)) {
    			i.adicionarPiso(novoPiso);
    		}
    	}
	}
	
	
}


