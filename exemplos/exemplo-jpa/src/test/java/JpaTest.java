
import java.util.Date;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.edu.ifpb.entidades.Evento;
import br.com.edu.ifpb.entidades.Evento.TipoEvento;
import br.com.edu.ifpb.entidades.Pessoa;
import br.edu.com.ifpb.dao.EventoDAO;
import br.edu.com.ifpb.dao.PessoaDAO;

@RunWith(Arquillian.class)
public class JpaTest {

	@Inject
	PessoaDAO pessoaDao;
	
	@Inject
	EventoDAO eventoDAO;

	@Deployment
	public static JavaArchive criarArquivoTeste() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(PessoaDAO.class.getPackage())
				.addPackage(Pessoa.class.getPackage())
				.addAsResource("META-INF/persistence.xml");
	}

	@Test
	@InSequence(1)
	public void testeSalvarPessoa() {
		Pessoa p1 = new Pessoa();
		p1.setIdade(2);
		p1.setNome("Murilo");
		pessoaDao.salvar(p1);

		Pessoa p2 = new Pessoa();
		p2.setIdade(1);
		p2.setNome("Marina");
		pessoaDao.salvar(p2);
	}
	
	@Test
	@InSequence(2)
	public void testeSalvarEvento() {
		Evento e1 = new Evento();
		e1.setNome("Sertão Comp");
		e1.setDescricao("Sertão Comp");
		e1.setInscricao(50.00f);
		e1.setTipo(TipoEvento.CONGRESSO);
		e1.setData(new Date());
	}

}
