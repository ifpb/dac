package br.edu.ifpb.dac.sessionbean;

import br.edu.ifpb.dac.domain.Produto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LoginService {

	public boolean checarCredenciais(String login, String senha) {
		if (login.equals("admin") && senha.equals("123")) {
			return true;
		}
		return false;
	}
}