package projeto_POO;
import java.util.ArrayList;

public class Sistema {

	public static double calcularMediaLeituras(Sensor sensor) {
		
	ArrayList<Leitura> leituras = sensor.getLeituras();
	
	if (leituras.isEmpty()) {
		return 0;
	}
		double soma = 0;
		for (Leitura a : leituras) {
			soma += a.getValor();
	}
		return soma / leituras.size();
	}
	}
