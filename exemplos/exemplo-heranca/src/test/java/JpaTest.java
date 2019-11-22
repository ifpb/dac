
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.edu.ifpb.entidades.Email;
import br.com.edu.ifpb.entidades.Endereco;
import br.com.edu.ifpb.entidades.Funcionario;
import br.com.edu.ifpb.entidades.Pessoa;
import br.com.edu.ifpb.entidades.PessoaFisica.Genero;
import br.com.edu.ifpb.entidades.Telefone;
import br.edu.com.ifpb.dao.PessoaDAO;
import br.edu.ifpb.services.CadastroFuncionarioException;
import br.edu.ifpb.services.FuncionarioService;

@RunWith(Arquillian.class)
public class JpaTest {

	@Inject
	PessoaDAO pessoaDao;
	
	@Inject
	FuncionarioService funcionarioService;
	
	@PersistenceContext(unitName = "dac")
	EntityManager em;
	
	@Deployment
	public static JavaArchive criarArquivoTeste() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(PessoaDAO.class.getPackage())
				.addPackage(Pessoa.class.getPackage())
				.addAsResource("META-INF/persistence.xml");
	}

	@Test
	@Ignore
	public void testeSalvarFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Diego");
		funcionario.setDataAdmissao(new Date());
		funcionario.setDataNascimento(new Date());
		
		Email email1 = new Email("institucional", "diego.pessoa@ifpb.edu.br");
		Email email2 = new Email("pessoa", "diegopessoa12@gmail.com");
		funcionario.setEmails(Arrays.asList(email1, email2));
		
		funcionario.setDataAdmissao(new Date());
		funcionario.setDataAdmissao(new Date());
		
		funcionario.setMatricula("123");
		funcionario.setGenero(Genero.MASCULINO);
		
		Telefone telefone1 = new Telefone("83", "9282308232");
		Telefone telefone2 = new Telefone("83", "2313223123");
		funcionario.setTelefones(Arrays.asList(telefone1, telefone2));
		
		funcionario.setCargo("Professor");
		
		Endereco endereco = new Endereco();
		endereco.setRua("Rua José da Silva");
		endereco.setCep("58203-383");
		endereco.setCidade("Cajazeiras");
		endereco.setEstado("Paraíba");
		
		funcionario.setEndereco(endereco);
		
		funcionario.setDataCriacao(new Date());
		funcionario.setCriador("diego");
		
		pessoaDao.salvar(funcionario);
		
	}
	
	@Test
	public void testeGerenciamentoEntidades() throws CadastroFuncionarioException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Diego");
		funcionario.setDataAdmissao(Date.from(Instant.parse("2011-03-10")));
		funcionario.setDataNascimento(Date.from(Instant.parse("1988-06-12")));
		
		Email email1 = new Email("institucional", "diego.pessoa@ifpb.edu.br");
		Email email2 = new Email("pessoa", "diegopessoa12@gmail.com");
		funcionario.setEmails(Arrays.asList(email1, email2));
		
		funcionario.setDataAdmissao(new Date());
		funcionario.setDataAdmissao(new Date());
		
		funcionario.setMatricula("123");
		funcionario.setGenero(Genero.MASCULINO);
		
		Telefone telefone1 = new Telefone("83", "9282308232");
		Telefone telefone2 = new Telefone("83", "2313223123");
		funcionario.setTelefones(Arrays.asList(telefone1, telefone2));
		
		funcionario.setCargo("Professor");
		
		Endereco endereco = new Endereco();
		endereco.setRua("Rua José da Silva");
		endereco.setCep("58203-383");
		endereco.setCidade("Cajazeiras");
		endereco.setEstado("Paraíba");
		
		funcionario.setEndereco(endereco);
		
		funcionarioService.criarFuncionario(funcionario);
		
		em.detach(funcionario);
		
		em.find(Funcionario.class, funcionario.getId());
		
		em.refresh(funcionario);
		
		em.merge(funcionario);
		
		System.out.println("ID = " + funcionario.getId());
		
	}
	
}
