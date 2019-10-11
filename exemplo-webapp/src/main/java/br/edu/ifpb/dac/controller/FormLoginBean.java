package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.sessionbean.LoginService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class FormLoginBean {

    @EJB
    private LoginService loginService;

    private String login;
    private String senha;

    public String efetuarLogin() {
        boolean usuarioLogado = loginService.checarCredenciais(login, senha);
        if (usuarioLogado) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", login);
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
