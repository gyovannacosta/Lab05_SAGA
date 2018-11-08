package saga;

import ferramentas.Validar;

/**
 * Produto é uma classe responsável por armazenar nome, descrição e valor de um
 * determinado produto.
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class Produto implements Comparable<Produto> {
	protected double valor;
	protected String nome;
	protected String descricao;

	/**
	 * Construtor de Produto tem como objetivo construir o objeto produto durante a
	 * execução do código, recebendo como parâmetro nome, descrição e valor de um
	 * determinado produto e inicializando suas respectivas variáveis.
	 * 
	 * @param nome      nome do produto.
	 * @param descricao descrição do produto.
	 * @param valor     valor do produto.
	 */
	public Produto(String nome, String descricao, double valor) {
		this.valor = valor;
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * O método getPreco(), tem como objetivo retornar o valor do produto.
	 * 
	 * @return preço do produto.
	 */
	public double getPreco() {
		return this.valor;
	}

	/**
	 * O método getNome(), tem como objetivo retornar a string do nome do produto.
	 * 
	 * @return nome do produto.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O método getDescricao(), tem como objetivo retornar a string de descrição do
	 * produto.
	 * 
	 * @return descrição do produto.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * O método setPreco(), tem como objetivo receber um double e substituir o valor
	 * do produto.
	 * 
	 * @param preco do produto.
	 */
	public void setPreco(Double preco) {
		this.valor = preco;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * produto.
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getDescricao() + " - R$" + String.format("%.2f", getPreco());
	}

	/**
	 * O método compareTo(), tem como objetivo comparar dois objetos.
	 * 
	 */
	@Override
	public int compareTo(Produto o) {
		return getNome().compareTo(o.getNome());
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
