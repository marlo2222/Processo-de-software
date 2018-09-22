package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.TelaPrincipalProprietario;
import br.com.rango.views.ViewDadosRestaurante;
import br.com.rango.views.ViewNotificacoes;

public class ControllerProprietario {
	public Model model;
	public TelaPrincipalProprietario menuPro = new TelaPrincipalProprietario();
	public ViewNotificacoes notificacoes = new ViewNotificacoes();
	public ViewDadosRestaurante dRestaurante = new ViewDadosRestaurante();
	public ControllerEdicaoRestaurante edicaoRestaurante;

	public ControllerProprietario(Model model) {
		this.model = model;
		this.edicaoRestaurante = new ControllerEdicaoRestaurante(model);
	}

	public void telaProprietario() {
		char opcao;
		do {
			opcao = menuPro.menuPropri();
			switch (opcao) {
			// visualizar restaurantes
			case '1':
				notificacoes.notificacao(model.visualizaRestaurantes());
				break;
			// cadastro restaurante
			case '2':
				if (model.cadastroRestaurante(dRestaurante.nomeRestaurante(), dRestaurante.horarioFuncionamento(),
						dRestaurante.endereco(), dRestaurante.telefoneContato()) == false) {
					notificacoes.notificacao(
							"Nao foi possivel cadastra o restaurante.\n estabelecimento j� cadastrado no sistema");
				} else {
					notificacoes.notificacao("Restaurante cadastrado com sucesso!");
				}
				break;
			// chamada de edicao de restaurante.
			case '3':
				edicaoRestaurante.telaEdicaoRest();
				break;
			default:
				break;
			}

		} while (opcao != '4');
	}

}