package projeto_POO;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Leitura {
	private LocalDateTime dataHorario;
	private double valor;
	/**
	 * @param dataHorario
	 * @param valor
	 */
	public Leitura(LocalDateTime dataHorario, double valor) {
		this.dataHorario = dataHorario;
		this.valor = valor;
	}
	
	public void setDataHorario(LocalDateTime dataHorario) {
		this.dataHorario = dataHorario;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String toString() {
		return "Leitura [dataHorario= " + dataHorario + ", valor= " + valor + "]";
	}
	
}
