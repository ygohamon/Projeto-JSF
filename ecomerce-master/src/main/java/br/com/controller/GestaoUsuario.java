package br.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.model.Usuario;
import br.com.repository.Usuarios;
import br.com.service.CadastroUsuarioService;
import br.com.util.FacesMessages;

public class GestaoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	@Inject
	private CadastroUsuarioService cadastroUsuario;
	
	@Inject
	private FacesMessages messages;
	
	private List<Usuario> todosUsuarios;
	private Usuario usuario = new Usuario();
	
	public void prepararNovoCadastro() {
		usuario = new Usuario();
	}
	
	public void salvar() {
		cadastroUsuario.salvar(usuario);
		consultar();
		
		messages.info("Empresa salva com sucesso!");
	}
	
	public void consultar() {
		todosUsuarios = usuarios.todos_usuarios();
	}

	public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void deletar() {
		cadastroUsuario.excluir(this.usuario);
		consultar();
	}
	
	public void editar() {
		usuario = this.usuarios.porId(this.usuario.getId());
		this.cadastroUsuario.salvar(this.usuario);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
