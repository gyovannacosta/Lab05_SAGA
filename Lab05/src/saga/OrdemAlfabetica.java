package saga;

import java.util.Comparator;

public class OrdemAlfabetica implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getNomeFornecedor().compareTo(o2.getNomeFornecedor());
	}


}
