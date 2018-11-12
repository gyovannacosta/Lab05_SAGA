package ordenacao;

import java.util.Comparator;
import java.util.Map.Entry;

import saga.Compra;

public class OrdemData implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		
		int valor1 = parse(o1);
		int valor2 = parse(o2);

		return (valor1 - valor2);
	}

	private int parse(Compra c) {
		String[] arr = c.getData().split("-");
		return Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])*30 + Integer.parseInt(arr[2])*365;
	}

}
