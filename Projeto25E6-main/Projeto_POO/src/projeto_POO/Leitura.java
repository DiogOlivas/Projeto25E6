package projeto_POO;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Leitura {
	private LocalDateTime dataHorario;
	private double valor;
	
	public Leitura(double valor) {
		this.dataHorario = LocalDateTime.now();
		this.valor = valor;
	}
	
	public void setDataHorario(LocalDateTime dataHorario) {
		this.dataHorario = dataHorario;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}

	public String toString() {
		return "Leitura [dataHorario= " + dataHorario + ", valor= " + valor + "]";
	}
	
}
