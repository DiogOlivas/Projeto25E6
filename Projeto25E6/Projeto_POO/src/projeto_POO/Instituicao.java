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
	
	public void verLeituraInstituicao() {
		for(Edificio e : edificios) {
			e.verLeiturasEdificio();
		}
	}
	public Edificio buscarEdificio(String nomeed) {
		for(Edificio e: edificios) {
			if(e.getNome().equals(nomeed)) {
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


