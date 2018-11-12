package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import ferramentas.Saida;
import ferramentas.Validar;
import ordenacao.OrdemCompraData;
import ordenacao.OrdemCompraFornecedor;
import ordenacao.OrdemCompraNome;

/**
 * Controller é a classe responsável por controlar e determinar os métodos de
 * acordo com o que é pedido e parâmetros fornecido pela Facade.
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class Controller {
	private HashMap<String, Cliente> mapaCliente;
	private HashMap<String, Fornecedor> mapaFornecedor;
	private String criterio;

	/**
	 * 
	 * Construtor de Controller tem como objetivo construir o controller e
	 * inicializar os mapa de objetos de Cliente e Fornecedor.
	 * 
	 */
	public Controller() {
		this.mapaCliente = new HashMap<>();
		this.mapaFornecedor = new HashMap<>();
		this.criterio = "";
	}

	/**
	 * O método adicionaCliente(), tem como objetivo receber cpf, nome, email e
	 * localização de um determinado usuario que deseja ser cadastrado como cliente
	 * no sistema, e verificar se as informações são válidas, caso sejam inválidas o
	 * sistema lança uma exceção, caso contrário o cliente é cadastrado.
	 * 
	 * @param cpf         cpf informado pelo usuário.
	 * @param nome        nome informado pelo usuário.
	 * @param email       email informado pelo usuário.
	 * @param localizacao localização informada pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário retorna o cpf logo após o cadastro.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		Validar.validaAdicionaCliente(cpf, nome, email, localizacao);
		if (!existeCliente(cpf)) {
			Cliente novoCliente = new Cliente(cpf, nome, email, localizacao);
			this.mapaCliente.put(cpf, novoCliente);
			return cpf;
		} else {
			throw new IllegalArgumentException(Saida.adicionaClienteExistente());
		}

	}

	/**
	 * O método exibeCliente(), tem como objetivo receber o cpf de um usuário, e
	 * verificar se as informações são válidas, caso sejam inválidas o sistema lança
	 * uma exceção, caso contrário é retornado o toString desse cliente.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário retorna a representação textual do
	 *         cliente.
	 * 
	 */
	public String exibeCliente(String cpf) {
		Validar.validaExibeCliente(cpf);
		if (existeCliente(cpf)) {
			return this.mapaCliente.get(cpf).toString();
		}
		return Validar.exibeClienteInexistente();
	}

	/**
	 * O método exibeClientes(), tem como objetivo retornar a representação textual
	 * de todos os clientes cadastrados no sistema de forma ordenada de acordo com
	 * as letras do alfabeto.
	 * 
	 * @return representação textual de todos os clientes de forma ordenada.
	 */
	public String exibeClientes() {
		ArrayList<Cliente> lista = new ArrayList<>(this.mapaCliente.values());
		Collections.sort(lista);
		String listar = "";
		for (int i = 0; i < lista.size(); i++) {
			listar += lista.get(i).toString();
			if (i < (lista.size() - 1)) {
				listar += " | ";
			}
		}
		return listar.trim();
	}

	/**
	 * O método editaCliente(), tem como objetivo receber o cpf de um usuário, uma
	 * opção para edição de informações de cliente e a informação a ser substituída.
	 * O mesmo verifica se as informações são válidas, caso sejam inválidas o
	 * sistema lança uma exceção, caso contrário é enviada a informação para o
	 * Cliente editar.
	 * 
	 * @param cpf    cpf informado pelo usuário.
	 * @param opcao  opção para edição de informação do cliente.
	 * @param rename informação que substituirá a anterior.
	 */
	public void editaCliente(String cpf, String opcao, String rename) {
		Validar.validaEditaCliente(cpf, opcao, rename);
		if (existeCliente(cpf)) {
			if (opcao.trim().equalsIgnoreCase("nome")) {
				this.mapaCliente.get(cpf).setNome(rename);
			} else if (opcao.trim().equalsIgnoreCase("email")) {
				this.mapaCliente.get(cpf).setEmail(rename);
			} else if (opcao.trim().equalsIgnoreCase("localizacao")) {
				this.mapaCliente.get(cpf).setLocalizacao(rename);
			} else {
				Validar.clienteRenameOpcaoInexistente();
			}
		} else {
			Validar.editaClienteInexistente();
		}

	}

	/**
	 * O método removeCliente(), tem como objetivo receber o cpf de um usuário. O
	 * mesmo verifica se as informações são válidas, caso sejam inválidas o sistema
	 * lança uma exceção, caso contrário é removido o cliente do sistema.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 */
	public void removeCliente(String cpf) {
		Validar.validaRemoveCliente(cpf);
		if (existeCliente(cpf)) {
			this.mapaCliente.remove(cpf);
		} else {
			Validar.exibeClienteNCadastrado();
		}
	}

	/**
	 * O método adicionaFornecedor(), tem como objetivo receber um nome, email e
	 * telefone de um determinado usuario que deseja ser cadastrado como fornecedor
	 * no sistema. O mesmo verifica se as informações são válidas, caso sejam
	 * inválidas o sistema lança uma exceção, caso contrário o fornecedor é
	 * cadastrado no sistema.
	 * 
	 * @param nome     nome informado pelo usuário.
	 * @param email    email informado pelo usuário.
	 * @param telefone telefone informado pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário o fornecedor é cadastrado no
	 *         sistema.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		Validar.validaAdicionaFornecedor(nome, email, telefone);
		if (!existeFornecedor(nome)) {
			Fornecedor novofornecedor = new Fornecedor(nome, email, telefone);
			this.mapaFornecedor.put(nome, novofornecedor);
			return nome;
		} else {
			throw new IllegalArgumentException(Saida.adicionaFornecedorExistente());
		}

	}

	/**
	 * O método exibeFornecedor(), tem como objetivo receber o nome de um usuário,
	 * verificar se o mesmo é cadastrado como fornecedor no sistema, se sim,
	 * retornar o toString desse fornecedor, caso contrário é lançada uma exceção.
	 * 
	 * @param nome nome informado pelo usuário.
	 * @return caso o fornecedor seja cadastrado no sistema retorna a representação
	 *         textual do mesmo, caso contrário é lançado uma exceção.
	 */
	public String exibeFornecedor(String nome) {
		if (existeFornecedor(nome)) {
			return this.mapaFornecedor.get(nome).toString();
		}
		throw new IllegalArgumentException(Saida.exibeFornecedorNCadastrado());
	}

	/**
	 * O método exibeFornecedores(), tem como objetivo retornar a representação
	 * textual de todos os fornecedores cadastrados no sistema de forma ordenada de
	 * acordo com as letras do alfabeto.
	 * 
	 * @return representação textual de todos os fornecedores de forma ordenada.
	 * 
	 */
	public String exibeFornecedores() {
		ArrayList<Fornecedor> lista = new ArrayList<>(this.mapaFornecedor.values());
		Collections.sort(lista);
		String listar = "";
		for (int i = 0; i < lista.size(); i++) {
			listar += lista.get(i).toString();
			if (i < (lista.size() - 1)) {
				listar += " | ";
			}
		}
		return listar.trim();
	}

	/**
	 * O método editaFornecedor(), tem como objetivo receber o nome de um usuário,
	 * uma opção para edição de informações de fornecedor e a informação a ser
	 * substituída. O mesmo verifica se as informações são válidas, caso sejam
	 * inválidas o sistema lança uma exceção, caso contrário a informação é passada
	 * para o fornecedor realização a alteração com a nova informação.
	 * 
	 * 
	 * @param nome   nome informado pelo usuário.
	 * @param opcao  opção para edição de informação do fornecedor.
	 * @param rename informação que substituirá a anterior.
	 */
	public void editaFornecedor(String nome, String opcao, String rename) {
		Validar.validaEditaFornecedor(opcao, rename);
		if (existeFornecedor(nome)) {
			if (opcao.trim().equalsIgnoreCase("nome")) {
				Validar.fornecedorRenameName();
			} else if (opcao.trim().equalsIgnoreCase("email")) {
				this.mapaFornecedor.get(nome).setEmail(rename);
			} else if (opcao.trim().equalsIgnoreCase("telefone")) {
				this.mapaFornecedor.get(nome).setTelefone(rename);
			} else {
				Validar.fornecedorRenameOpcaoInexistente();
			}
		} else {
			throw new IllegalArgumentException(Saida.editaFornecedorNCadastrado());
		}

	}

	/**
	 * O método removeFornecedor(), tem como objetivo receber o nome de um usuário,
	 * verificar se o mesmo é inválido(nulo ou vazio) e corresponde à um fornecedor
	 * cadastrado no sistema, caso seja o mesmo é removido do sistema, caso
	 * contrário é lançado uma exceção referente correspondente a seu erro.
	 * 
	 * @param nome nome informado pelo usuário.
	 */
	public void removeFornecedor(String nome) {
		Validar.validaRemoveFornecedor(nome);
		this.mapaFornecedor.remove(nome);
	}

	/**
	 * O método adicionaProduto(), tem como objetivo receber um nome de um
	 * fornecedor,o nome, decrição e preço de um produto que o usuário deseja
	 * cadastradar aos produtos do fornecedor dentro do sistema. O mesmo verifica se
	 * as informações são válidas, caso sejam inválidas o sistema lança uma exceção,
	 * caso contrário o produto do fornecedor é cadastrado no sistema.
	 * 
	 * 
	 * 
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param valor          valor do produto informado pelo usuário.
	 */
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double valor) {
		Validar.validaAdicionaProduto(nomeFornecedor, nomeProduto, descricao, valor);
		if (existeFornecedor(nomeFornecedor)) {
			this.mapaFornecedor.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao, valor);
		} else {
			Validar.produtoNCadastradoFNE();
		}
	}

	/**
	 * O método exibeProduto(), tem como objetivo receber o nome de um usuário, nome
	 * de um produto e sua descrição, O mesmo verifica se as informações são
	 * válidas, caso sejam inválidas o sistema lança uma exceção, caso contrário o
	 * sistema retorna a representação textual desse produto.
	 * 
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário retorna a representação textual do
	 *         produto.
	 */
	public String exibeProduto(String nomeProduto, String nomeFornecedor, String descricao) {
		Validar.validaExibeProdutoDInvld(nomeProduto, nomeFornecedor, descricao);
		if (existeFornecedor(nomeFornecedor)) {
			return this.mapaFornecedor.get(nomeFornecedor).getProduto(nomeProduto, descricao);
		}
		throw new IllegalAccessError(Saida.exibeProdutoFornecedorInexistente());
	}

	/**
	 * O método exibeProdutosFornecedor(), tem como objetivo receber o nome de um
	 * usuário, verificar se o mesmo é cadastrado como fornecedor no sistema, caso
	 * não seja é lançada um exceção, caso contrário retorna a representação textual
	 * de todos os produtos cadastrados nesse fornecedor.
	 * 
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @return caso o fornecedor seja cadastrado no sistema retorna a representação
	 *         textual de todos os produtos desse mesmo fornecedor, caso contrário é
	 *         lançado uma exceção.
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		if (existeFornecedor(nomeFornecedor)) {
			return this.mapaFornecedor.get(nomeFornecedor).getAllProduto();
		}
		throw new IllegalArgumentException(Saida.editaProdutoFornecedorNCadastrado());
	}

	/**
	 * O método exibeProdutos(), tem como objetivo retornar a representação textual
	 * de todos os produtos de todos os fornecedores cadastrados no sistema de forma
	 * ordenada de acordo com as letras do alfabeto.
	 * 
	 * @return representação textual de todos os produtos de todos os fornecedores
	 *         de forma ordenada.
	 */
	public String exibeProdutos() {
		ArrayList<Fornecedor> lista = new ArrayList<>(this.mapaFornecedor.values());
		Collections.sort(lista);
		String listar = "";
		for (int i = 0; i < lista.size(); i++) {
			listar += lista.get(i).getAllProduto();
			if (i < (lista.size() - 1)) {
				listar += " | ";
			}
		}
		return listar.trim();
	}

	/**
	 * O método editaProduto(), tem como objetivo receber o nome de um usuário, o
	 * nome de um produto, sua descrição e a informação a ser substituída. O mesmo
	 * verifica se as informações são válidas, caso sejam inválidas o sistema lança
	 * uma exceção, caso contrário o produto é editado.
	 * 
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @param rename         informação que irá substituir a anterior.
	 */
	public void editaProduto(String nomeProduto, String descricao, String nomeFornecedor, Double rename) {
		Validar.validaeditaProduto(nomeProduto, descricao, nomeFornecedor, rename);
		if (existeFornecedor(nomeFornecedor)) {
			this.mapaFornecedor.get(nomeFornecedor).setProduto(nomeProduto, descricao, rename);
		} else {
			throw new IllegalArgumentException(Saida.editaProdutoFornecedorInexistente());
		}
	}

	/**
	 * O método removeProduto(), tem como objetivo receber o nome de um usuário, o
	 * nome de um produto e sua descrição. O mesmo verifica se as informações são
	 * válidas, caso sejam inválidas o sistema lança uma exceção, caso contrário o
	 * produto é removido do sistema.
	 * 
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		Validar.validaRemoveProduto(nomeProduto, descricao, nomeFornecedor);
		if (existeFornecedor(nomeFornecedor)) {
			this.mapaFornecedor.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
		} else {
			throw new IllegalArgumentException(Saida.removeProdutoFornecedorInexistente());
		}
	}

	/**
	 * O método existeCliente(), é um método privado responsável por verificar se um
	 * determinado cliente existe no sistema.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 * @return retorna true caso exista, e false caso contrário.
	 */
	private boolean existeCliente(String cpf) {
		return this.mapaCliente.containsKey(cpf);
	}

	/**
	 * O método existeFornecedor(), é um método privado responsável por verificar se
	 * um determinado fornecedor existe no sistema.
	 * 
	 * @param nome nome informado pelo usuário.
	 * @return retorna true caso exista, e false caso contrário.
	 */
	private boolean existeFornecedor(String nome) {
		return this.mapaFornecedor.containsKey(nome);
	}

	/**
	 * O método adicionaCombo(), tem como objetivo receber um nome de um
	 * fornecedor,o nome de um combo, sua descrição decrição, o fator para cálculo
	 * do valor do combo e os produtos que compõem esse combo. O mesmo verifica se
	 * as informações são válidas, caso sejam inválidas o sistema lança uma exceção,
	 * caso contrário o combo do fornecedor é cadastrado no sistema.
	 * 
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @param nomeCombo      nome do combo informado pelo usuário.
	 * @param descricaoCombo descrição do combo informada pelo usuário.
	 * @param fator          valor real informado pelo usuário.
	 * @param produtos       nome e descrição dos produtos informados pelo usuário.
	 */
	public void adicionaCombo(String nomeFornecedor, String nomeCombo, String descricaoCombo, double fator,
			String produtos) {
		Validar.validaAdicionaCombo(nomeFornecedor, nomeCombo, descricaoCombo, fator, produtos);
		if (existeFornecedor(nomeFornecedor)) {
			this.mapaFornecedor.get(nomeFornecedor).adicionaCombo(nomeCombo, descricaoCombo, fator, produtos);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}

	}

	/**
	 * O método editaCombo, tem como objetivo receber o nome de um fornecedor, nome,
	 * descrição e fator de um combo. O mesmo verifica se as informações são
	 * válidas, caso sejam inválidas o sistema lança uma exceção, caso contrário o
	 * combo é editado.
	 * 
	 * @param nomeCombo      nome do combo informado pelo usuário.
	 * @param descricao      descrição do combo informada pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @param fator          valor real informado pelo usuário.
	 */
	public void editaCombo(String nomeCombo, String descricao, String nomeFornecedor, double fator) {
		Validar.validaEditaCombo(nomeCombo, descricao, nomeFornecedor, fator);
		if (existeFornecedor(nomeFornecedor)) {
			this.mapaFornecedor.get(nomeFornecedor).editaCombo(nomeCombo, descricao, fator);
		} else {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
	}

	/**
	 * O método adicionaCompra(), tem como objetivo receber um cpf de um cliente, um
	 * nome de um fornecedor,o nome e decrição de um produto e a data da sua compra.
	 * O mesmo verifica se as informações são válidas, caso sejam inválidas o
	 * sistema lança uma exceção, caso contrário a compra é cadastrada no sistema.
	 * 
	 * @param cpf            cpf informado pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @param data           data da compra informada pelo usuário.
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 */
	public void adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricao) {
		Validar.validaAdicionaCompra(cpf, nomeFornecedor, data, nomeProduto, descricao);
		if (existeCliente(cpf)) {
			if (existeFornecedor(nomeFornecedor)) {
				if (this.mapaFornecedor.get(nomeFornecedor).existeProduto(nomeProduto)
						|| this.mapaFornecedor.get(nomeFornecedor).existeCombo(nomeProduto)) {
					this.mapaFornecedor.get(nomeFornecedor).adicionaCompra(cpf,
							this.mapaCliente.get(cpf).adicionaCompra(nomeFornecedor, data, nomeProduto, descricao,
									this.mapaFornecedor.get(nomeFornecedor).getPrecoProduto(nomeProduto)));

				} else {
					throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
				}

			} else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}

		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}

	/**
	 * O método getDebito(), tem como objetivo receber um nome de um fornecedor e o
	 * cpf de um cliente. O mesmo verifica se as informações são válidas, caso sejam
	 * inválidas o sistema lança uma exceção, caso contrário é retornado o valor
	 * total das compras do cliente com o fornecedor.
	 * 
	 * @param cpf            cpf informado pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário retorna o valor total das compras
	 *         do cliente com o fornecedor.
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		Validar.validaGetDebito(cpf, nomeFornecedor);
		if (existeCliente(cpf)) {
			if (existeFornecedor(nomeFornecedor)) {
				return this.mapaFornecedor.get(nomeFornecedor).getDebito(cpf);

			}
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");

		}
		throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");

	}

	/**
	 * O método exibeContas(), tem como objetivo receber um nome de um fornecedor e
	 * o cpf de um cliente. O mesmo verifica se as informações são válidas, caso
	 * sejam inválidas o sistema lança uma exceção, caso contrário é retornado a
	 * representação textual da conta que o cliente possui com o cliente.
	 * 
	 * @param cpf            cpf informado pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário retorna a representação textual da
	 *         conta que o cliente possui com o fornecedor.
	 * 
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		Validar.validaExibeContas(cpf, nomeFornecedor);
		if (existeCliente(cpf)) {
			if (existeFornecedor(nomeFornecedor)) {
				String listar = "Cliente: " + this.mapaCliente.get(cpf).getNome() + " | ";
				listar += this.mapaFornecedor.get(nomeFornecedor).exibeContas(cpf);
				return listar.trim();
			}
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");

		}
		throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
	}

	/**
	 * O método exibeContasClientes(), tem como objetivo receber um cpf de um
	 * cliente. O mesmo verifica se as informações são válidas, caso sejam inválidas
	 * o sistema lança uma exceção, caso contrário é retornado a representação
	 * textual de todas as contas que o cliente têm cadastradas no sistema.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 * @return caso alguma das informações passadas seja inválida, o controller
	 *         lança uma exceção, caso contrário retorna a representação textual de
	 *         todas as contas que o cliente têm cadastradas no sistema.
	 * 
	 */
	public String exibeContasClientes(String cpf) {
		Validar.validaExibeContasClientes(cpf);
		if (existeCliente(cpf)) {
			return this.mapaCliente.get(cpf).exibeContasClientes();
		}
		throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
	}

	public void realizaPagamento(String cpf, String nomeFornecedor) {
		Validar.validaRealizaPagamento(cpf, nomeFornecedor);
		if (existeCliente(cpf)) {
			if (existeFornecedor(nomeFornecedor)) {
				this.mapaFornecedor.get(nomeFornecedor).realizaPagamento(cpf, nomeFornecedor);
				this.mapaCliente.get(cpf).realizaPagamento(nomeFornecedor);
			} else {
				throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
			}

		} else {
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		}

	}

	public void ordenaPor(String criterio) {
		Validar.validaOrdenaPor(criterio);
		if (criterio.trim().equalsIgnoreCase("cliente") || criterio.trim().equalsIgnoreCase("fornecedor")
				|| criterio.trim().equalsIgnoreCase("data")) {
			this.criterio = criterio;
		} else {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
	}

	public String listarCompras() {
		String result = "";
		
		List<Entry<String,Compra>> list = new ArrayList<>();
		for(Cliente c : mapaCliente.values()) {
			List<Entry<String,Compra>> aux = c.getListaCompras();
			for(Entry<String,Compra> e : aux) {
				list.add(e);
			}
		}
		
		if(criterio.equalsIgnoreCase("cliente")) {
			Collections.sort(list, new OrdemCompraNome());
		}else if(criterio.equalsIgnoreCase("fornecedor")) {
			Collections.sort(list, new OrdemCompraFornecedor());
		}else {
			Collections.sort(list, new OrdemCompraData());
		}
		
		for(int i = 0; i < list.size(); i++) {
			Entry<String,Compra> e = list.get(i);
			if(criterio.equalsIgnoreCase("cliente"))
				result += auxListarCompras(
							e.getKey(),
							e.getValue().getNomeFornecedor(),
							e.getValue().getDescricao(),
							e.getValue().getNormalData()
							);
			
			else if(criterio.equalsIgnoreCase("fornecedor"))
				result += auxListarCompras(
							e.getValue().getNomeFornecedor(),
							e.getKey(),
							e.getValue().getDescricao(),
							e.getValue().getNormalData()
							);
			else
				result += auxListarCompras(
							e.getValue().getNormalData(),
							e.getKey(),
							e.getValue().getNomeFornecedor(),
							e.getValue().getDescricao()
							);
			
			if(i+1 < list.size()) result += " | ";
		}
		
		return result;
	}
	
	private String auxListarCompras(Object a, Object b, Object c, Object d) {
		return a + ", " + b + ", " + c + ", " + d;
	}

}
