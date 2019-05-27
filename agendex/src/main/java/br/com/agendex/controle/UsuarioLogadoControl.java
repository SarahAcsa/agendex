package br.com.agendex.controle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.Usuario;
import br.com.agendex.persistencia.UsuarioDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

@Controller("UsuarioLogadoControl")
@Scope("session")
public class UsuarioLogadoControl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    private boolean ligarCamera;

    @Autowired
    private UsuarioDao usuarioDao;

    @PostConstruct
    public void init() {
        try {
            HttpServletRequest req = UtilFaces.getRequest();
            String login = req.getUserPrincipal().getName();
            usuario = usuarioDao.consultar(login);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void ligarCamera(){
        this.ligarCamera = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLigarCamera() {
        return ligarCamera;
    }

    public void setLigarCamera(boolean ligarCamera) {
        this.ligarCamera = ligarCamera;
    }

}
