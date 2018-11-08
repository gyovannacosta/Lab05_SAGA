package saga;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Conta é uma classe responsável por armazenar cpf e compra realizada pelo
 * cliente no fornecedor do produto comprado pelo cliente.
 * 
 * @author Deborah Gyovanna Costa
 *
 */
public class Conta {
	private String cpfCliente;
	private ArrayList<Compra> compras;

	/**
	 * Construtor de Conta tem como objetivo construir o objeto conta durante a
	 * execução do código, recebendo como parâmetro cpf de um cliente e uma compra
	 * realizada pelo cliente de um produto do fornecedor.
	 * 
	 * @param cpf        cpf do cliente.
	 * @param novaCompra compra do cliente.
	 */
	public Conta(String cpf, Compra novaCompra) {
		this.cpfCliente = cpf;
		this.compras = new ArrayList<>();
		adicionaCompra(novaCompra);

	}

	/**
	 * O método adicionaCompra(), é responsável por adicionar novas compras do
	 * cliente à conta do fornecedor dos produtos.
	 * 
	 * @param novaCompra nova compra do cliente.
	 */
	public void adicionaCompra(Compra novaCompra) {
		this.compras.add(novaCompra);
	}

	/**
	 * O método getDebito(), tem como objetivo retornar o valor total das compras
	 * realizada pelo cliente.
	 * 
	 * @return valor total das compras realizadas pelo cliente.
	 */
	public String getDebito() {
		double debito = 0.00;
		for (Compra compra : compras) {
			debito += compra.getValor();
		}
		String[] aux = String.format("%.2f", debito).split(",");
		String result = aux[0] + "." + aux[1];

		return result;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * conta.
	 */
	@Override
	public String toString() {
		String listar = "";
		for (int i = 0; i < this.compras.size(); i++) {
			listar += this.compras.get(i).getNome() + " - " + this.compras.get(i).getData();
			if (i < (this.compras.size() - 1)) {
				listar += " | ";
			}
		}
		return listar.trim();
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
		result = prime * result + ((cpfCliente == null) ? 0 : cpfCliente.hashCode());
		return result;
	}

	/**
	 * O método equals(), tem como objetivo comparar se um objeto é igual a outro.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		if (cpfCliente == null) {
			if (other.cpfCliente != null)
				return false;
		} else if (!cpfCliente.equals(other.cpfCliente))
			return false;
		return true;
	}

}
