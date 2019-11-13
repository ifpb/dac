package br.edu.ifpb.dac.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.dac.sessionbean.LoginService;

@ManagedBean
@SessionScoped
public class FormLoginBean {

    @EJB
    private LoginService loginService;

    private String login;
    private String senha;
    
    private String usuarioLogado;
	
	public void logout() {
		this.usuarioLogado = null;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "login.xhtml");
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	

    public String efetuarLogin() {
        boolean usuarioLogado = loginService.checarCredenciais(login, senha);
        if (usuarioLogado) {
//        	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            session.setAttribute("usuarioLogado", login);
        	this.setSenha(null);
        	this.setUsuarioLogado(login);
            return "produtos.xhtml";
        } else {
            FacesMessage message = new FacesMessage("Falha na autenticação", "Login ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "login.xhtml";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
