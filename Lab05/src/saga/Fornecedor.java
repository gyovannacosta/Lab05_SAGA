package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import ferramentas.Saida;
import ferramentas.Validar;

/**
 * Fornecedor é uma classe responsável por armazenar nome, email e telefone de
 * um determinado fornecedor.
 * 
 * @author Deborah Gyovanna Soares Costa.
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {
	private String nome;
	private String email;
	private String telefone;
	private HashSet<Produto> produtos;
	private HashMap<String, Conta> mapaContas;

	/**
	 * Construtor de Fornecedor tem como objetivo construir o objeto fornecedor
	 * durante a execução do código, recebendo como parâmetro nome, email e telefone
	 * de um determinado usuário e inicializando suas respectivas variáveis.
	 * 
	 * @param nome     nome do fornecedor.
	 * @param email    email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashSet<>();
		this.mapaContas = new HashMap<>();
	}

	/**
	 * O método setEmail(), tem como objetivo receber um string e renomeiar o email
	 * do fornecedor,
	 * 
	 * @param email do fornecedor.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * O método setTelefone(), tem como objetivo receber um string, e renomeiar o
	 * telefone do fornecedor.
	 * 
	 * @param telefone telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * O método getNome(), tem como objetivo retornar a string do nome do
	 * fornecedor.
	 * 
	 * @return nome do fornecedor.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O método getEmail(), tem como objetivo retornar a string do email do
	 * fornecedor.
	 * 
	 * @return email do fornecedor.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * O método getTelefone(), tem como objetivo retornar a string do telefone do
	 * fornecedor.
	 * 
	 * @return telefone do fornecedor.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * O método cadastraProduto(), tem como objetivo receber o nome, descrição e
	 * valor de um produto, verificar se o fornecedor já possui esse produto, caso
	 * sim é lançado uma exceção, caso contrário o produto é cadastrado.
	 * 
	 * @param nomeProduto nome do produto.
	 * @param descricao   descrição do produto.
	 * @param valor       valor do produto.
	 */
	public void cadastraProduto(String nomeProduto, String descricao, double valor) {
		if (!existeProduto(nomeProduto)) {
			Produto novoProduto = new Produto(nomeProduto, descricao, valor);
			this.produtos.add(novoProduto);
		} else {
			Validar.produtoExite();

		}
	}

	/**
	 * O método getProduto(), tem como objetivo receber o nome e a descrição de um
	 * produto, e retornar a representação textual desse produto.
	 * 
	 * @param nomeProduto nome do produto.
	 * @param descricao   descrição do produto
	 * @return retorna a representação textual do produto.
	 */
	public String getProduto(String nomeProduto, String descricao) {
		String recebe = "";
		if (existeProduto(nomeProduto)) {
			for (Produto produto : produtos) {
				if (produto.getNome().equals(nomeProduto)) {
					recebe += produto.toString();
				}
			}
			return recebe;
		}
		throw new IllegalArgumentException(Saida.exibeProdutoInexistente());
	}

	/**
	 * O método getAllProduto(), tem como objetivo retornar a representação textual
	 * de todos os produtos que o fornecedor possui.
	 * 
	 * @return representação textual de todos os produtos.
	 */
	public String getAllProduto() {
		ArrayList<Produto> lista = new ArrayList<>(this.produtos);
		Collections.sort(lista);
		String listar = "";
		for (int i = 0; i < lista.size(); i++) {
			listar += getNome() + " - " + lista.get(i).toString();
			if (i < (lista.size() - 1)) {
				listar += " | ";
			}
		}
		return listar.trim();
	}

	/**
	 * O método setProduto, tem como objetivo receber como parâmetro o nome,
	 * descrição e a informação que substituirá a anterior produto.
	 * 
	 * @param nomeProduto nome do produto.
	 * @param descricao   descrição do produto.
	 * @param rename      informação que substituirá a anterior.
	 */
	public void setProduto(String nomeProduto, String descricao, Double rename) {
		if (existeProduto(nomeProduto)) {
			for (Produto produto : produtos) {
				if (produto.getNome().equals(nomeProduto)) {
					produto.setPreco(rename);
				}
			}
		} else {
			throw new IllegalArgumentException(Saida.editaProdutoNCadastrado());
		}
	}

	/**
	 * O método removeProduto(), tem como objetivo remover um determinado produto do
	 * fornecedor.
	 * 
	 * @param nomeProduto nome do produto.
	 * @param descricao   descrição do produto.
	 */
	public void removeProduto(String nomeProduto, String descricao) {
		if (existeProduto(nomeProduto)) {
			Produto remover = null;
			for (Produto produto : produtos) {
				if (produto.getNome().equals(nomeProduto)) {
					remover = produto;
				}
			}
			produtos.remove(remover);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
	}

	/**
	 * O método existeProduto(), é um método responsável por verificar se um
	 * determinado produto existe para esse fornecedor.
	 * 
	 * @param nomeProduto nome do produto.
	 * @return retorna true caso ele exista, e false caso contrário.
	 */
	public boolean existeProduto(String nomeProduto) {
		for (Produto produto : this.produtos) {
			if (produto.getNome().equals(nomeProduto)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * fornecedor.
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getEmail() + " - " + getTelefone();
	}

	/**
	 * O método compareTo(), tem como objetivo comparar dois objetos.
	 */
	@Override
	public int compareTo(Fornecedor o) {
		return getNome().compareTo(o.getNome());
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	/**
	 * O método adicionaCombo(), tem como realizar o cadastro de um combo de
	 * produtos do fornecedor.
	 * 
	 * @param nomeCombo      nome do Combo.
	 * @param descricaoCombo descrição do Combo.
	 * @param fator          fator responsável pelo cálculo de valor do combo.
	 * @param produtos       produtos que compõem o combo.
	 */
	public void adicionaCombo(String nomeCombo, String descricaoCombo, double fator, String produtos) {
		if (!existeCombo(nomeCombo)) {
			String prodCombo[] = new String[2];
			double valor = 0.0;
			prodCombo = produtos.split(", ");
			prodCombo[0] = prodCombo[0].split(" - ")[0];
			prodCombo[1] = prodCombo[1].split(" - ")[0];
			isCombo(prodCombo[0]);
			isCombo(prodCombo[1]);
			if (existeProduto(prodCombo[0]) && existeProduto(prodCombo[1])) {
				for (Produto prod1 : this.produtos) {
					if (prod1.getNome().equals(prodCombo[0])) {
						valor += prod1.getPreco();
					}
				}
				for (Produto prod2 : this.produtos) {
					if (prod2.getNome().equals(prodCombo[1])) {
						valor += prod2.getPreco();
					}
				}

				ProdutoCombo novoCombo = new ProdutoCombo(nomeCombo, descricaoCombo, valor, fator);
				this.produtos.add(novoCombo);
			} else {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
	}

	/**
	 * O método isCombo(), é um método privado responsável por verificar se um
	 * determinado produto é combo, caso seja lança uma exceção.
	 * 
	 * @param nome nome do produto.
	 */
	private void isCombo(String nome) {
		for (Produto produto : produtos) {
			if (produto.getNome().equals(nome) && produto instanceof ProdutoCombo) {
				throw new IllegalArgumentException(
						"Erro no cadastro de combo: um combo n�o pode possuir combos na lista de produtos.");
			}
		}
	}

	/**
	 * 
	 * O método existeCombo(), é um método responsável por verificar se um
	 * determinado combo existe para esse fornecedor.
	 * 
	 * @param nomeCombo nome do produto.
	 * @return retorna true caso ele exista, e false caso contrário.
	 */
	public boolean existeCombo(String nomeCombo) {
		for (Produto produto : produtos) {
			if (produto.getNome().equals(nomeCombo) && produto instanceof ProdutoCombo) {
				return true;
			}
		}

		return false;
	}

	/**
	 * O método editaCombo(), é reponsável pela edição do fator de um combo.
	 * 
	 * @param nomeCombo nome do combo.
	 * @param descricao descrição do combo.
	 * @param fator     valor real responsável pelo cálculo do valor do combo.
	 */
	public void editaCombo(String nomeCombo, String descricao, double fator) {
		if (existeCombo(nomeCombo)) {
			for (Produto produto : produtos) {
				if (produto.getNome().equals(nomeCombo) && produto instanceof ProdutoCombo) {
					produto.setPreco(fator);
				}
			}
		} else {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}

	}

	/**
	 * O método getPrecoProduto(), tem como objetivo retornar o valor de um produto.
	 * 
	 * @param nomeProduto nome de um produto.
	 * @return valor do produto.
	 */
	public double getPrecoProduto(String nomeProduto) {
		double valor = 0.0;
		for (Produto produto : produtos) {
			if (produto.getNome().equals(nomeProduto)) {
				valor = produto.getPreco();
			}
		}
		return valor;
	}

	/**
	 * O método adicionaCompra(), tem como objetivo adicionar uma compra à uma cota
	 * do cliente com o fornecedor.
	 * 
	 * @param cpf        cpf do cliente.
	 * @param novaCompra compra realizada pelo cliente.
	 */
	public void adicionaCompra(String cpf, Compra novaCompra) {
		if (existeConta(cpf)) {
			this.mapaContas.get(cpf).adicionaCompra(novaCompra);
		} else {
			Conta novaConta = new Conta(cpf, novaCompra);
			this.mapaContas.put(cpf, novaConta);
		}
	}

	/**
	 * O método existeConta(), é um método privado responsável por verificar se
	 * existe uma determinada conta de um cliente cadastrada com o fornecedor.
	 * 
	 * @param cpf cpf do cliente.
	 * @return true caso a conta exista, false caso contrário.
	 */
	private boolean existeConta(String cpf) {
		return this.mapaContas.containsKey(cpf);
	}

	/**
	 * O método getDebito(), é responsável por retornar o débito total de uma conta
	 * de um cliente com o fornecedor.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna o débito total de uma conta de um cliente com o fornecedor.
	 */
	public String getDebito(String cpf) {
		if (existeConta(cpf)) {
			return this.mapaContas.get(cpf).getDebito();
		}
		throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
	}

	/**
	 * O método exibeContas(), é responsável por retornar a representação textual de
	 * todas as contas de um determinado cliente com o fornecedor.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna a representação textual de todas as contas de um determinado
	 *         cliente com o fornecedor cadastradas no sistema.
	 */
	public String exibeContas(String cpf) {
		if (existeConta(cpf)) {
			String listar = this.nome + " | ";
			listar += this.mapaContas.get(cpf).toString();
			return listar.trim();
		}
		throw new IllegalArgumentException(
				"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
	}

	public void realizaPagamento(String cpf, String nomeFornecedor) {
		if (existeConta(cpf)) {
			this.mapaContas.remove(cpf);
		} else {
			throw new IllegalArgumentException(
					"Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
	}

}
