package saga;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ferramentas.Validar;
import ordenacao.OrdemAlfabetica;
import ordenacao.OrdemData;

/**
 * Cliente é uma classe responsável por armazenar nome, cpf, email e localização
 * de um determinado cliente.
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class Cliente implements Comparable<Cliente> {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	private ArrayList<Compra> compras;

	/**
	 * Construtor de Cliente tem como objetivo construir o objeto cliente durante a
	 * execução do código, recebendo como parâmetro cpf, nome, email e localização
	 * de um determinado usuário e inicializando suas respectivas variáveis.
	 * 
	 * @param cpf         cpf do cliente.
	 * @param nome        nome do cliente.
	 * @param email       email do cliente.
	 * @param localizacao localização do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.compras = new ArrayList<>();
	}

	/**
	 * O método setNome(), tem como objetivo receber um stringe renomeiar o nome do
	 * cliente.
	 * 
	 * @param nome nome do cliente.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * O método setEmail(), tem como objetivo receber um string e renomeiar o email
	 * do cliente.
	 * 
	 * @param email email do cliente.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * O método setLocalizacao(), tem como objetivo receber um string e renomeiar a
	 * localização do cliente.
	 * 
	 * @param localizacao localização do cliente.
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * O método getCpf(), tem como objetivo retornar a string de cpf do cliente.
	 * 
	 * @return cpf do cliente.
	 */
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * O método getNome(), tem como objetivo retornar a string do nome do cliente.
	 * 
	 * @return nome do cliente.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O método getEmail(), tem como objetivo retornar a string do email do cliente.
	 * 
	 * @return email do cliente.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * O método getLocalizacao(), tem como objetivo retornar a string de localização
	 * do cliente.
	 * 
	 * @return localização do cliente.
	 */
	public String getLocalizacao() {
		return this.localizacao;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * cliente.
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getLocalizacao() + " - " + getEmail();
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * O método compareTo(), tem como objetivo comparar dois objetos.
	 */
	@Override
	public int compareTo(Cliente o) {
		return getNome().compareTo(o.getNome());
	}

	/**
	 * O método adicionaCompra(), tem como objetivo cadastradar uma compra de um
	 * cliente.
	 * 
	 * @param nomeFornecedor nome do fornecedor.
	 * @param data           data da compra.
	 * @param nomeProduto    nome do produto.
	 * @param descricao      descrição do produto.
	 * @param precoProduto   preço do produto.
	 * @return retorna a nova compra cadastrado do cliente.
	 */
	public Compra adicionaCompra(String nomeFornecedor, String data, String nomeProduto, String descricao,
			double precoProduto) {
		Compra novaCompra = new Compra(data, nomeProduto, descricao, precoProduto, nomeFornecedor);
		this.compras.add(novaCompra);
		return novaCompra;
	}

	/**
	 * O método exibeContasClientes(), tem como objetivo retornar a representação
	 * textual de todas as contas do cliente.
	 * 
	 * @return retorna a representação textual de todas as contas do cliente
	 *         ordenados pela data da compra.
	 */
	public String exibeContasClientes() {
		String listar = "Cliente: " + getNome() + " | ";
		if (this.compras.size() > 0) {
			Collections.sort(compras, new OrdemData());
			Collections.sort(compras, new OrdemAlfabetica());

			String nomeAnterior = "";
			for (int i = 0; i < compras.size(); i++) {
				if (!compras.get(i).getNomeFornecedor().equals(nomeAnterior)) {
					listar += compras.get(i).getNomeFornecedor() + " | ";
					nomeAnterior = compras.get(i).getNomeFornecedor();
				}
				listar += compras.get(i).toString();
				if (i + 1 < compras.size())
					listar += " | ";
			}
			return listar.trim();
		}
		throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
	}

	/**
	 * O método realizaPagamento(), tem como objetivo identificar uma compra e
	 * remover ela do ArrayList de compras.
	 * 
	 * @param nomeFornecedor nome do fornecedor da compra.
	 */
	public void realizaPagamento(String nomeFornecedor) {
		for (int i = 0; i < this.compras.size(); i++) {
			if (compras.get(i).getNomeFornecedor().equals(nomeFornecedor)) {
				this.compras.remove(i);
			}
		}
	}

	/**
	 * 
	 * @return retorna uma lista de compras associada a uma chave em String, que é o
	 *         nome do cliente.
	 */
	public List<Entry<String, Compra>> getListaCompras() {
		List<Entry<String, Compra>> list = new ArrayList<>();
		for (Compra c : compras) {
			Entry<String, Compra> entry = new AbstractMap.SimpleEntry<>(this.nome, c);
			list.add(entry);
		}
		return list;
	}

}
