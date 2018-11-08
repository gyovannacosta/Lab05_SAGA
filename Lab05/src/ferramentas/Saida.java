package ferramentas;

/**
 * A classe Saida tem como objetivo auxiliar as classes restantes do sistema
 * fornecendo as saídas para as exceções.
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class Saida {

	public static String adicionaClienteExistente() {
		return "Erro no cadastro do cliente: cliente ja existe.";
	}

	public static String exibeFornecedorNCadastrado() {
		return "Erro na exibicao do fornecedor: fornecedor nao existe.";
	}
	
	public static String editaFornecedorNCadastrado() {
		return "Erro na edicao do fornecedor: fornecedor nao existe.";
	}
	
	public static String editaProdutoFornecedorNCadastrado() {
		return "Erro na exibicao dos produtos: fornecedor nao existe.";
	}

	public static String editaProdutoNCadastrado() {
		return "Erro na edicao do produto: produto nao existe.";
	}

	public static String adicionaFornecedorExistente() {
		return "Erro no cadastro de fornecedor: fornecedor ja existe.";
	}

	public static String exibeProdutoFornecedorInexistente() {
		return "Erro na exibicao de produto: fornecedor nao existe.";
	}

	public static String exibeProdutoInexistente() {
		return "Erro na exibicao de produto: produto nao existe.";
	}

	public static String editaProdutoFornecedorInexistente() {
		return "Erro na edicao de produto: fornecedor nao existe.";
	}

	public static String removeProdutoFornecedorInexistente() {
		return "Erro na remocao de produto: fornecedor nao existe.";
	}

}
