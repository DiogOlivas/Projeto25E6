package projeto_POO;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    return "Data/Hora: " + dataHorario.format(formatter) + " | Valor: " + valor;
	}

	
}
