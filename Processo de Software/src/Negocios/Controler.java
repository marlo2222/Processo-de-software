package Negocios;

import Viem.*;

public class Controler {
	public Model model;
	public PreTela preTela;
	public ViemNotificacoes notificacoes = new ViemNotificacoes();
	public ViemDadoscadastro dados = new ViemDadoscadastro();
	public ViemDadosRestaurante dRestaurante = new ViemDadosRestaurante();
	public PreTelaProprietario telaPro = new PreTelaProprietario();
	public ViemPropritario menuPro = new ViemPropritario();

	public Controler(Model model, PreTela preTela) {
		this.model = model;
		this.preTela = preTela;
	}

	public Controler() {
		super();
	}

	public void acaoTelaInicial() {
		char opcao;
		do {
			opcao = preTela.telaInicial();
			switch (opcao) {
			// logar
			case '1':
				if (model.logar(dados.cnpj(), dados.senha()) == false) {
					notificacoes.msgUsuarioInvalido();
				} else {
					telaProprietario();
				}
				break;
			// cadastra
			case '2':

				break;
			// cadastra restaurante
			case '3':
				telaProprietarioLogin();
			default:
				break;
			}
		} while (opcao != '4');
	}

	public void telaProprietarioLogin() {
		char opcao;
		do {
			opcao = telaPro.menuLogin();
			switch (opcao) {
			//logar proprietario
			case '1':
				if (model.logar(dados.cnpj(), dados.senha()) == false) {
					notificacoes.msgUsuarioInvalido();
				} else {
					telaProprietario();
				}
				break;
				//cadastra proprietario
			case '2':
				if (model.cadastraProprieatrio(dados.nome(), dados.email(), dados.cnpj(), dados.telefone()) == true) {
					notificacoes.mgsUsuarioCadastrado();
					telaProprietario();
				} else
					notificacoes.mgsUsuarioExistente();
				break;
			default:
				break;
			}

		} while (opcao != '3');
	}

	public void telaProprietario() {
		char opcao;
		do {
			opcao = menuPro.menuPropri();
			switch (opcao) {
			//visualizar lista
			case '1':
				notificacoes.Listausuarios(model.visualizaRestaurantes());
				break;
				//cadastro restaurante
			case '2':
				if(model.cadastroRestaurante(dRestaurante.nomeRestaurante(),dRestaurante.horarioFuncionamento(),dRestaurante.endereco(),dRestaurante.telefoneContato())==false) {
				notificacoes.msgRestauranteCad();}
				break;
			case '3':
				//n�o � aqui, remaneja essa chamada ao usuario
				notificacoes.ListaRestaurantes(model.listaRest());
				break;

			default:
				break;
			}

		} while (opcao != '4');
	}

	public int definirSenha() {
		return dados.senha();
	}
}
