package saga;

/**
 * Compra é uma classe responsável por armazenar nome, descrição, data, fator e
 * fornecedor de um produto comprado pelo cliente.
 * 
 * @author Deborah Gyovanna Costa
 *
 */
public class Compra {
	private String nomeFornecedor;
	private String data;
	private String nomeProduto;
	private String descricaoProduto;
	private double valor;

	/**
	 * Construtor de Compra tem como objetivo construir o objeto compra durante a
	 * execução do código, recebendo como parâmetro nome, descrição, data, fator e
	 * fornecedor de um produto comprado pelo cliente e inicializando suas
	 * respectivas variáveis.
	 * 
	 * @param data           data de compra do produto.
	 * @param nomeProduto    nome do produto.
	 * @param descricao      descrição do produto.
	 * @param precoProduto   preço do produto.
	 * @param nomeFornecedor nome do fornecedor do produto.
	 */
	public Compra(String data, String nomeProduto, String descricao, double precoProduto, String nomeFornecedor) {
		this.data = data;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricao;
		this.valor = precoProduto;
		this.nomeFornecedor = nomeFornecedor;

	}

	/**
	 * O método getValor(), tem como objetivo retornar o valor do produto.
	 * 
	 * @return valor do produto.
	 */
	public double getValor() {
		return this.valor;
	}

	/**
	 * O método getNome(), tem como objetivo retornar o nome do produto.
	 * 
	 * @return nome do produto.
	 */
	public String getNome() {
		return this.nomeProduto;
	}

	/**
	 * O método getFornecedor(), tem como objetivo retornar o fornecedor do produto.
	 * 
	 * @return fornecedor do produto.
	 */
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}

	/**
	 * O método getData(), tem como objetivo retornar a data da compra do produto.
	 * 
	 * @return data da compra do produto.
	 */
	public String getData() {
		String[] aux = this.data.split("/");
		return aux[0] + "-" + aux[1] + "-" + aux[2];
	}
	
	public String getDescricao() {
		return this.descricaoProduto;
	}
	
	public String getNormalData() {
		return this.data;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * compra.
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getData();
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricaoProduto == null) ? 0 : descricaoProduto.hashCode());
		result = prime * result + ((nomeFornecedor == null) ? 0 : nomeFornecedor.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Compra other = (Compra) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricaoProduto == null) {
			if (other.descricaoProduto != null)
				return false;
		} else if (!descricaoProduto.equals(other.descricaoProduto))
			return false;
		if (nomeFornecedor == null) {
			if (other.nomeFornecedor != null)
				return false;
		} else if (!nomeFornecedor.equals(other.nomeFornecedor))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

}
