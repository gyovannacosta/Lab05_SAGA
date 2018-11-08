package saga;

import ferramentas.Validar;

/**
 * ProdutoCombo é uma classe responsável por armazenar nome, descrição e valor e
 * fator de um determinado combo de produtos.
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class ProdutoCombo extends Produto {
	private double fator;
	private double valorProdutos;

	/**
	 * 
	 * Construtor de ProdutoCombo tem como objetivo construir o objeto combo de
	 * produtos durante a execução do código, recebendo como parâmetro nome,
	 * descrição e valor e fator de determinados produtos e inicializando suas
	 * respectivas variáveis.
	 * 
	 * @param nome      nome do combo.
	 * @param descricao descrição do combo.
	 * @param valor     valor dos produtos.
	 * @param fator     fator responsável pelo cálculo do valor do combo.
	 */
	public ProdutoCombo(String nome, String descricao, double valor, double fator) {
		super(nome, descricao, valor);
		this.fator = fator;
		this.valorProdutos = valor;
		this.valor = this.valor - (this.valor * this.fator);

	}

	/**
	 * O método setPreco(), tem como objetivo receber um double de fator, realizar o
	 * cálculo do novo valor do combo a partir desse fator e substituir o valor do
	 * combo de produtos.
	 */
	@Override
	public void setPreco(Double fator) {
		setFator(fator);
		this.valor = this.valorProdutos - (this.valorProdutos * fator);
	}

	/**
	 * O método setFator(), tem como objetivo receber um double de fator e
	 * substituir o fator atual do combo.
	 * 
	 * @param fator fator responsável pelo cálculo do valor do combo.
	 */
	private void setFator(Double fator) {
		this.fator = fator;
	}

}
