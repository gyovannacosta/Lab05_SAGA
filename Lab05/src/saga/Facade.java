package saga;

import easyaccept.EasyAccept;

/**
 * Estrutura de Facade para ligação das funcionalidades do back-end com as
 * funcionalidades do front-end para funcionamento do sistema
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class Facade {

	/**
	 * Inicialização dos scripts de teste de aceitação.
	 * 
	 * @param args Scripts que serão executados.
	 */
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "acceptionTest/use_case_1.txt", "acceptionTest/use_case_2.txt",
				"acceptionTest/use_case_3.txt", "acceptionTest/use_case_4.txt", "acceptionTest/use_case_5.txt",
				"acceptionTest/use_case_6.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Inicialização do Controller
	 */
	private Controller controller = new Controller();

	/**
	 * O método adicionaCliente() é responsável por informar ao controller, cpf,
	 * nome, email e localização de um usuário que deseja se cadastrar como cliente
	 * no sistema.
	 * 
	 * @param cpf         número de cpf informado pelo usuário.
	 * @param nome        nome informado pelo usuário.
	 * @param email       email informado pelo usuário.
	 * @param localizacao localização do lab em que o usuário se encontra.
	 * @return retorna cpf do usuário.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return controller.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * O método exibeCliente(), tem como objetivo informar ao controller um cpf de
	 * um cliente e receber sua represão textual como retorno.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 * @return representação textual de um cliente cadastrado no sistema.
	 */
	public String exibeCliente(String cpf) {
		return controller.exibeCliente(cpf);
	}

	/**
	 * O método exibeClientes(), tem como objetivo receber do controller a
	 * representação textual de todos os clientes cadastrados no sistema.
	 * 
	 * @return representação textual de todos os clientes do sistema.
	 */
	public String exibeClientes() {
		return controller.exibeClientes();
	}

	/**
	 * O método editaCliente(), tem como objetivo informar um cpf de um cliente e
	 * uma opção para a edição de informações do cliente, além da nova informação
	 * que irá repor a antiga.
	 * 
	 * @param cpf    cpf informado pelo usuário.
	 * @param opcao  opção de edição de informação.
	 * @param rename informação que substituirá a anterior.
	 */
	public void editaCliente(String cpf, String opcao, String rename) {
		controller.editaCliente(cpf, opcao, rename);
	}

	/**
	 * O método removeCliente(), tem como objetivo informar um cpf de um cliente e
	 * deletá-lo do sistema.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 */
	public void removeCliente(String cpf) {
		controller.removeCliente(cpf);
	}

	/**
	 * O método adicionaFornecedor(), é responsável por informar ao controller,
	 * nome, email e telefone de um usuário que deseja se cadastrar como fornecedor
	 * no sistema.
	 * 
	 * @param nome     nome informado pelo usuário.
	 * @param email    email informado pelo usuário.
	 * @param telefone telefone informado pelo usuário.
	 * @return retorna nome do usuário.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controller.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * O método exibeFornecedor(), tem como objetivo informar ao controller um nome
	 * de um fornecedor e receber sua represão textual como retorno.
	 * 
	 * @param nome nome informado pelo usuário.
	 * @return representação textual de um fornecedor cadastrado no sistema.
	 */
	public String exibeFornecedor(String nome) {
		return controller.exibeFornecedor(nome);
	}

	/**
	 * O método exibeFornecedores(), tem como objetivo receber do controller a
	 * representação textual de todos os fornecedores cadastrados no sistema.
	 * 
	 * @return representação textual de todos os fornecedores cadastrados no
	 *         sistema.
	 */
	public String exibeFornecedores() {
		return controller.exibeFornecedores();
	}

	/**
	 * O método editaFornecedor(), tem como objetivo informar um nome de um
	 * fornecedor e uma opção para a edição de informações do fornecedor, além da
	 * nova informação que irá repor a antiga.
	 * 
	 * @param nome   nome informado pelo usuário.
	 * @param opcao  opção de edição de informação.
	 * @param rename informação que substituirá a anterior.
	 */
	public void editaFornecedor(String nome, String opcao, String rename) {
		controller.editaFornecedor(nome, opcao, rename);
	}

	/**
	 * O método removeFornecedor(), tem como objetivo informar um nome de um
	 * fornecedor e deletá-lo do sistema.
	 * 
	 * @param nome nome informado pelo usuário.
	 */
	public void removeFornecedor(String nome) {
		controller.removeFornecedor(nome);
	}

	/**
	 * O método adicionaProduto(), é responsável por informar ao controller, nome de
	 * um fornecedor, nome de um produto, descrição desse produto e valor do mesmo
	 * produto para que o produto e suas informações sejam cadastradas para o
	 * fornecedor.
	 * 
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param valor          valor do produto informado pelo usuário.
	 */
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double valor) {
		controller.adicionaProduto(nomeFornecedor, nomeProduto, descricao, valor);
	}

	/**
	 * O método exibeProduto(), tem como objetivo informar ao controller um nome de
	 * um fornecedor, o nome de um produto e sua descrição e receber sua represão
	 * textual do produto desse fornecedor como retorno.
	 * 
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @return representação textual de um produto de um fornecedor cadastrado no
	 *         sistema.
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return controller.exibeProduto(nomeProduto, nomeFornecedor, descricao);
	}

	/**
	 * O método exibeProdutosFornecedor(), tem como objetivo informar ao controller
	 * um nome de um fornecedor, e receber a representação textual de todos os
	 * produtos desse fornecedor cadastrados no sistema.
	 * 
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @return representação textual de todos os produtos de um fornecedor
	 *         cadastrado no sistema.
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return controller.exibeProdutosFornecedor(nomeFornecedor);
	}

	/**
	 * O método exibeProdutos(), tem como objetivo receber a representação textual
	 * de todos os produtos cadastrados no sistema.
	 * 
	 * @return representação textual de todos os produtos cadastrados no sistema.
	 */
	public String exibeProdutos() {
		return controller.exibeProdutos();
	}

	/**
	 * O método editaProduto(), tem como objetivo informar um nome de um fornecedor,
	 * nome de um produto, sua decrição e uma opção para a edição de informações do
	 * produto desse fornecedor, além da nova informação que irá repor a antiga.
	 * 
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @param rename         informação que substituirá a anterior.
	 */
	public void editaProduto(String nomeProduto, String descricao, String nomeFornecedor, Double rename) {
		controller.editaProduto(nomeProduto, descricao, nomeFornecedor, rename);
	}

	/**
	 * O método removeProduto(), tem como objetivo informar um nome de um
	 * fornecedor, nome de um produto e sua decrição para deletar do sistema o
	 * produto do fornecedor.
	 * 
	 * @param nomeProduto    nome do produto informado pelo usuário.
	 * @param descricao      descrição do produto informada pelo usuário.
	 * @param nomeFornecedor informação que substituirá a anterior.
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		controller.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	/**
	 * O método adicionaCombo(), é responsável por informar ao controller, nome de
	 * um fornecedor, nome de um combo, descrição desse combo, valor do combo, fator
	 * responsável pelo cálculo do preço do combo e os produtos que farão parte do
	 * combo, para que o combo e suas informações sejam cadastradas para o
	 * fornecedor.
	 * 
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @param nomeCombo      nome do combo informado pelo usuário.
	 * @param descricaoCombo descrição do combo informada pelo usuário.
	 * @param fator          número real informado pelo usuário.
	 * @param produtos       nome e descricao dos produtos informados pelo usuário.
	 */
	public void adicionaCombo(String nomeFornecedor, String nomeCombo, String descricaoCombo, double fator,
			String produtos) {
		controller.adicionaCombo(nomeFornecedor, nomeCombo, descricaoCombo, fator, produtos);
	}

	/**
	 * O método editaCombo(), tem como objetivo informar um nome de um combo, sua
	 * decrição, nome do fornecedor, e um novo número real para servir de fator para
	 * cálculo do valor do combo para a edição do fator atual do combo desse
	 * fornecedor.
	 * 
	 * @param nomeCombo      nome do combo informado pelo usuário.
	 * @param descricao      descrição do combo informada pelo usuário.
	 * @param nomeFornecedor nome informado pelo usuário.
	 * @param fator          fator real que substituirá o fator atual do combo.
	 */
	public void editaCombo(String nomeCombo, String descricao, String nomeFornecedor, double fator) {
		controller.editaCombo(nomeCombo, descricao, nomeFornecedor, fator);
	}

	/**
	 * O método adicionaCompra(), é responsável por informar ao controller,cpf de um
	 * usuário, nome de um fornecedor, data, nome de um produto e os sua decrição,
	 * para que a compra e suas informações sejam cadastradas para o cliente e o
	 * fornecedor.
	 * 
	 * @param cpf            cpf informado pelo usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @param data           data da compra informada pelo usuário.
	 * @param nomeProduto    nome da compra informada pelo usuário.
	 * @param descricao      descrição da compra informada pelo usuário.
	 */
	public void adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricao) {
		controller.adicionaCompra(cpf, nomeFornecedor, data, nomeProduto, descricao);
	}

	/**
	 * O método getDebito(), tem como objetivo receber a partir de um cpf de um
	 * cliente e um fornecedor, o débito que esse mesmo cliente têm com o
	 * fornecedor.
	 * 
	 * @param cpf            cpf informado usuário.
	 * @param nomeFornecedor nome do fornecedor informado pelo usuário.
	 * @return total de débito que o cliente tem com o fornecedor.
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		return controller.getDebito(cpf, nomeFornecedor);
	}

	/**
	 * O método exibeContas(), tem como objetivo informar ao controller um cpf de um
	 * cliente e um nome de um fornecedor, e receber a representação textual de
	 * todas as compras que esse cliente tem cadastradas na conta do fornecedor.
	 * 
	 * @param cpf            cpf informado pelo usuário.
	 * @param nomeFornecedor nome de um fornecedor informado pelo usuário.
	 * @return representação textual de todas as compras de um cliente na conta de
	 *         um fornecedor cadastrado no sistema.
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		return controller.exibeContas(cpf, nomeFornecedor);
	}

	/**
	 * * O método exibeContasClientes(), tem como objetivo informar ao controller um
	 * cpf de um cliente e receber a representação textual de todas as compras que
	 * esse cliente tem cadastradas no sistema.
	 * 
	 * @param cpf cpf informado pelo usuário.
	 * @return representação textual de todas as compras de um cliente cadastradas
	 *         no sistema.
	 */
	public String exibeContasClientes(String cpf) {
		return controller.exibeContasClientes(cpf);
	}

	public void realizaPagamento(String cpf, String nomeFornecedor) {
		controller.realizaPagamento(cpf, nomeFornecedor);
	}
	
	public void ordenaPor(String criterio) {
		controller.ordenaPor(criterio);
	}
	
	public String listarCompras() {
		return controller.listarCompras();
	}

}
