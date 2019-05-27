package br.com.agendex.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.EnumPapelUsuario;
import br.com.agendex.entidade.Usuario;
import br.com.agendex.persistencia.UsuarioDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

@Controller("UsuarioControl")
@Scope("conversation")
public class UsuarioControl {

    private Usuario usuario = new Usuario();

    private Usuario usuarioExcluir;

    private List<Usuario> usuarios = new ArrayList<>();

    @Autowired
    private UsuarioDao usuarioDao;

    @PostConstruct
    public void init(){
        listar();
    }

    public void confirmar(){
        try {
            usuarioDao.validar(this.usuario);
            this.usuario.setSenhaNaoCriptografada(this.usuario.getSenha());
            this.usuario.addPapel(EnumPapelUsuario.USUARIO);
            this.usuario.addPapel(EnumPapelUsuario.ADMIN);
            usuarioDao.alterar(this.usuario);
            usuario = new Usuario();
            listar();
            UtilFaces.addMensagemFaces("Usuário Salvo com sucesso!");
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void listar(){
        try {
            usuarios = usuarioDao.listar();
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void excluir(){
        try {
            usuarioDao.excluirPorId(usuarioExcluir.getId());
            listar();
            UtilFaces.addMensagemFaces("Excluído com sucesso!");
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioExcluir() {
        return usuarioExcluir;
    }

    public void setUsuarioExcluir(Usuario usuarioExcluir) {
        this.usuarioExcluir = usuarioExcluir;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
