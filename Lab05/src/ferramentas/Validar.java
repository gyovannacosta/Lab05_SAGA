package ferramentas;

/**
 * A classe Validar tem como objetivo verificar se alguma entrada informada pelo
 * usuário foi inválida e lançar uma exceção caso isso aconteça.
 * 
 * @author Deborah Gyovanna Soares Costa
 *
 */
public class Validar {

	public static String exibeClienteInexistente() {
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}

	public static String editaClienteInexistente() {
		throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
	}

	public static void clienteRenameOpcaoInexistente() {
		throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
	}

	public static String fornecedorRenameName() {
		throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
	}

	public static void fornecedorRenameOpcaoInexistente() {
		throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
	}

	public static void produtoNCadastradoFNE() {
		throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
	}

	public static void produtoExite() {
		throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
	}

	public static void produtoExibeFNE() {
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}

	public static void exibeClienteNCadastrado() {
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}

	public static void validaEditaCombo(String nomeCombo, String descricao, String nomeFornecedor, double fator) {
		if (isNulo(nomeCombo))
			throw new NullPointerException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");

		if (isVazio(nomeCombo))
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");

		if (fator <= 0 || fator >= 1)
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");

	}

	public static void validaAdicionaCombo(String nomeFornecedor, String nomeCombo, String descricao, double fator,
			String produtos) {
		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");

		if (isNulo(nomeCombo))
			throw new NullPointerException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");

		if (isVazio(nomeCombo))
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");

		if (isNulo(produtos))
			throw new NullPointerException("Erro no cadastro de combo: combo deve ter produtos.");

		if (isVazio(produtos))
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");

		if (fator <= 0 || fator >= 1)
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");

	}

	public static void validaRemoveProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		if (isNulo(nomeProduto))
			throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");

		if (isVazio(nomeProduto))
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");

	}

	public static void validaeditaProduto(String nomeProduto, String descricao, String nomeFornecedor, Double preco) {
		if (isNulo(nomeProduto))
			throw new NullPointerException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");

		if (isVazio(nomeProduto))
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (preco <= 0)
			throw new NumberFormatException("Erro na edicao de produto: preco invalido.");

	}

	public static void validaExibeProdutoDInvld(String nomeProduto, String nomeFornecedor, String descricao) {
		if (isNulo(nomeProduto))
			throw new NullPointerException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");

		if (isVazio(nomeProduto))
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

	}

	public static void validaAdicionaProduto(String nomeFornecedor, String nomeProduto, String descricao,
			double valor) {
		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");

		if (isNulo(nomeProduto))
			throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");

		if (isVazio(nomeProduto))
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

		if (valor <= 0)
			throw new NumberFormatException("Erro no cadastro de produto: preco invalido.");

	}

	public static void validaRemoveFornecedor(String nome) {
		if (isNulo(nome))
			throw new NullPointerException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");

		if (isVazio(nome))
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");

	}

	public static void validaEditaFornecedor(String opcao, String rename) {
		if (isNulo(opcao))
			throw new NullPointerException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");

		if (isVazio(opcao))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");

		if (isNulo(rename))
			throw new NullPointerException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

		if (isVazio(rename))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

	}

	public static void validaAdicionaFornecedor(String nome, String email, String telefone) {
		if (isNulo(nome))
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");

		if (isVazio(nome))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");

		if (isNulo(email))
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");

		if (isVazio(email))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");

		if (isNulo(telefone))
			throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

		if (isVazio(telefone))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

	}

	public static void validaRemoveCliente(String cpf) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro na remocao do cliente: cpf não pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf não pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro na remocão do cliente: cpf inválido.");

	}

	public static void validaEditaCliente(String cpf, String opcao, String rename) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro na edicao do cliente: cpf não pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf não pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf inválido.");

		if (isNulo(opcao))
			throw new NullPointerException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");

		if (isVazio(opcao))
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");

		if (isNulo(rename))
			throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

		if (isVazio(rename))
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

	}

	public static void validaExibeCliente(String cpf) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro na exibicao do cliente: cpf não pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf não pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf inválido.");

	}

	public static void validaAdicionaCliente(String cpf, String nome, String email, String localizacao) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");

		if (isNulo(nome))
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");

		if (isVazio(nome))
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");

		if (isNulo(email))
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");

		if (isVazio(email))
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");

		if (isNulo(localizacao))
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

		if (isVazio(localizacao))
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

	}

	public static void validaAdicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto,
			String descricao) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");

		if (isNulo(data))
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");

		if (isVazio(data))
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");

		if (data.length() != 10)
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");

		if (isNulo(nomeProduto))
			throw new NullPointerException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		if (isVazio(nomeProduto))
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		if (isNulo(descricao))
			throw new NullPointerException(
					"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");

		if (isVazio(descricao))
			throw new NullPointerException(
					"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
	}

	private static boolean isNulo(String valor) {
		return valor.trim() == null;
	}

	private static boolean isVazio(String valor) {
		return valor.trim().equals("");
	}

	public static void validaGetDebito(String cpf, String nomeFornecedor) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

	}

	public static void validaExibeContas(String cpf, String nomeFornecedor) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

	}

	public static void validaExibeContasClientes(String cpf) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");

	}

	public static void validaRealizaPagamento(String cpf, String nomeFornecedor) {
		if (isNulo(cpf))
			throw new NullPointerException("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");

		if (isVazio(cpf))
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf invalido.");

		if (isNulo(nomeFornecedor))
			throw new NullPointerException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");

		if (isVazio(nomeFornecedor))
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");

	}

	public static void validaOrdenaPor(String criterio) {
		if (isNulo(criterio)) {
			throw new NullPointerException("Opcao invalida: criterio nao pode ser vazio ou nulo.");
		}
		if (isVazio(criterio)) {
			throw new IllegalArgumentException("Opcao invalida: criterio nao pode ser vazio ou nulo.");
		}

	}
}
