package ordenacao;

import java.util.Comparator;
import java.util.Map.Entry;

import saga.Compra;

public class OrdemCompraFornecedor implements Comparator<Entry<String,Compra>> {

	@Override
	public int compare(Entry<String, Compra> o1, Entry<String, Compra> o2) {
		if(o1.getValue().getNomeFornecedor().equalsIgnoreCase(o2.getValue().getNomeFornecedor())) {
			if(o1.getKey().equalsIgnoreCase(o2.getKey())) {
				if(o1.getValue().getDescricao().equals(o2.getValue().getDescricao())) {
					return new OrdemData().compare(o1.getValue(), o2.getValue());
				}
				return o1.getValue().getDescricao().compareToIgnoreCase(o2.getValue().getDescricao());
			}
			return o1.getKey().compareTo(o2.getKey());
		}
		return o1.getValue().getNomeFornecedor().compareToIgnoreCase(o2.getValue().getNomeFornecedor());
	}

}