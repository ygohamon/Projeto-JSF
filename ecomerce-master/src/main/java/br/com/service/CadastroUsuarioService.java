package br.com.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.model.Usuario;
import br.com.repository.Usuarios;
import br.com.util.Transacional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transacional
	public void salvar(Usuario usuario) {
		usuarios.guardar_usuario(usuario);
	}
	
	@Transacional
	public void excluir(Usuario usuario) {
		usuarios.remover_usuario(usuario);;
	}

}