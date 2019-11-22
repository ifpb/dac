package br.edu.ifpb.testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.edu.ifpb.entidades.Departamento;
import br.com.edu.ifpb.entidades.Dependente;
import br.com.edu.ifpb.entidades.Dependente.TipoParentesco;
import br.com.edu.ifpb.entidades.Funcionario;
import br.com.edu.ifpb.entidades.Pessoa;
import br.edu.com.ifpb.dao.DepartamentoDAO;
import br.edu.com.ifpb.dao.FuncionarioDAO;
import br.edu.com.ifpb.dao.PessoaDAO;

@RunWith(Arquillian.class)
public class JpaTest {

	private static Logger log = Logger.getLogger(JpaTest.class.getName());

	@EJB
	PessoaDAO pessoaDao;

	@EJB
	FuncionarioDAO funcionarioDAO;

	@EJB
	DepartamentoDAO departamentoDAO;

	@Deployment
	public static WebArchive criarArquivoTeste() {
		return ShrinkWrap.create(WebArchive.class).addPackage(PessoaDAO.class.getPackage())
				.addPackage(Pessoa.class.getPackage()).addAsResource("META-INF/persistence.xml");
	}

	@Test
	public void popularBanco() throws Exception {
		
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

		log.info("Iniciando importação de dados no banco");
		/** Criando departamentos **/
		Departamento departamento = new Departamento();
		departamento.setNome("Direção de Ensino");
		departamento.setAbreviacao("DDE");
		departamentoDAO.salvar(departamento);

		departamento = new Departamento();
		departamento.setNome("Direção Geral");
		departamento.setAbreviacao("DG");
		departamentoDAO.salvar(departamento);

		departamento = new Departamento();
		departamento.setNome("Direção de Administração");
		departamento.setAbreviacao("DA");
		departamentoDAO.salvar(departamento);

		departamento = new Departamento();
		departamento.setNome("Unidade de Informática");
		departamento.setAbreviacao("UNINFO");
		departamentoDAO.salvar(departamento);

		departamento = new Departamento();
		departamento.setNome("Unidade de Indústria");
		departamento.setAbreviacao("UNIND");
		departamentoDAO.salvar(departamento);

		departamento = new Departamento();
		departamento.setNome("Unidade de Formação Geral");
		departamento.setAbreviacao("UNIFG");
		departamentoDAO.salvar(departamento);

		/** Criando funcionários **/

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Lucrécia");
		funcionario.setAdmissao(fmt.parse("2005-01-01"));
		funcionario.setCpf("112.123.123-23");
		funcionario.setMatricula("82310238");
		funcionario.setNascimento(fmt.parse("1970-10-11"));
		funcionario.setSalario(15.000f);
		Departamento dg = departamentoDAO.buscarPorAbreviacao("DG");
		funcionario.setDepartamento(dg);

		Dependente dependente1 = new Dependente();
		dependente1.setNome("Petrucci");
		dependente1.setTipoParentesco(TipoParentesco.CONJUGE);
		dependente1.setNascimento(fmt.parse("1960-07-10"));
		dependente1.setCpf("123.123.433-23");
		funcionario.addDependente(dependente1);

		Dependente dependente2 = new Dependente();
		dependente2.setNome("Lucrecinha");
		dependente2.setTipoParentesco(TipoParentesco.FILHO);
		dependente2.setNascimento(fmt.parse("2010-02-10"));
		dependente2.setCpf("123.123.233-23");
		funcionario.addDependente(dependente2);

		Dependente dependente3 = new Dependente();
		dependente3.setNome("Lucrécio");
		dependente3.setTipoParentesco(TipoParentesco.FILHO);
		dependente3.setNascimento(fmt.parse("2000-05-10"));
		dependente3.setCpf("333.123.233-23");
		funcionario.addDependente(dependente3);

		funcionarioDAO.salvar(funcionario);

		funcionario = new Funcionario();
		funcionario.setNome("Hugo");
		funcionario.setAdmissao(fmt.parse("2002-01-01"));
		funcionario.setCpf("112.135.123-23");
		funcionario.setMatricula("231334");
		funcionario.setNascimento(fmt.parse("1975-08-01"));
		funcionario.setSalario(11.000f);
		Departamento da = departamentoDAO.buscarPorAbreviacao("DA");
		funcionario.setDepartamento(da);

		dependente1 = new Dependente();
		dependente1.setNome("Margarida");
		dependente1.setTipoParentesco(TipoParentesco.CONJUGE);
		dependente1.setNascimento(fmt.parse("1980-07-10"));
		dependente1.setCpf("183.123.433-23");
		funcionario.addDependente(dependente1);

		dependente2 = new Dependente();
		dependente2.setNome("Huguinho");
		dependente2.setTipoParentesco(TipoParentesco.FILHO);
		dependente2.setNascimento(fmt.parse("2005-02-02"));
		dependente2.setCpf("123.123.993-23");
		funcionario.addDependente(dependente2);

		dependente3 = new Dependente();
		dependente3.setNome("Zezinho");
		dependente3.setTipoParentesco(TipoParentesco.FILHO);
		dependente3.setNascimento(fmt.parse("2008-05-10"));
		dependente3.setCpf("333.123.283-23");
		funcionario.addDependente(dependente3);

		Dependente dependente4 = new Dependente();
		dependente4.setNome("Luizinho");
		dependente4.setTipoParentesco(TipoParentesco.FILHO);
		dependente4.setNascimento(fmt.parse("2010-02-10"));
		dependente4.setCpf("933.123.283-23");
		funcionario.addDependente(dependente4);

		funcionarioDAO.salvar(funcionario);

		funcionario = new Funcionario();
		funcionario.setNome("Ricardo Job");
		funcionario.setAdmissao(fmt.parse("2015-03-05"));
		funcionario.setCpf("118.185.123-23");
		funcionario.setMatricula("739053");
		funcionario.setNascimento(fmt.parse("1989-04-20"));
		funcionario.setSalario(8.000f);
		Departamento de = departamentoDAO.buscarPorAbreviacao("DDE");
		funcionario.setDepartamento(de);

		dependente1 = new Dependente();
		dependente1.setNome("Carla");
		dependente1.setTipoParentesco(TipoParentesco.CONJUGE);
		dependente1.setNascimento(fmt.parse("1987-04-10"));
		dependente1.setCpf("188.123.433-23");
		funcionario.addDependente(dependente1);

		dependente2 = new Dependente();
		dependente2.setNome("Job Jr");
		dependente2.setTipoParentesco(TipoParentesco.FILHO);
		dependente2.setNascimento(fmt.parse("2019-11-05"));
		dependente2.setCpf("123.123.888-23");
		funcionario.addDependente(dependente2);

		dependente3 = new Dependente();
		dependente3.setNome("Sra. Job");
		dependente3.setTipoParentesco(TipoParentesco.MAE);
		dependente3.setNascimento(fmt.parse("1965-02-10"));
		dependente3.setCpf("399.123.283-23");
		funcionario.addDependente(dependente3);

		dependente4 = new Dependente();
		dependente4.setNome("Stive Jobs");
		dependente4.setTipoParentesco(TipoParentesco.PAI);
		dependente4.setNascimento(fmt.parse("1955-08-02"));
		dependente4.setCpf("022.123.283-23");
		funcionario.addDependente(dependente4);

		funcionarioDAO.salvar(funcionario);

		funcionario = new Funcionario();
		funcionario.setNome("Francisco Paulo");
		funcionario.setAdmissao(fmt.parse("2014-02-06"));
		funcionario.setCpf("110.105.123-23");
		funcionario.setMatricula("322332");
		funcionario.setNascimento(fmt.parse("1990-03-20"));
		funcionario.setSalario(6.500f);
		Departamento uninfo = departamentoDAO.buscarPorAbreviacao("UNINFO");
		funcionario.setDepartamento(uninfo);

		dependente1 = new Dependente();
		dependente1.setNome("Dona Chica");
		dependente1.setTipoParentesco(TipoParentesco.CONJUGE);
		dependente1.setNascimento(fmt.parse("1992-08-10"));
		dependente1.setCpf("188.100.433-23");
		funcionario.addDependente(dependente1);

		dependente2 = new Dependente();
		dependente2.setNome("Alice");
		dependente2.setTipoParentesco(TipoParentesco.FILHO);
		dependente2.setNascimento(fmt.parse("2018-11-05"));
		dependente2.setCpf("123.123.800-23");
		funcionario.addDependente(dependente2);

		funcionarioDAO.salvar(funcionario);

		funcionario = new Funcionario();
		funcionario.setNome("Fabio Bala");
		funcionario.setAdmissao(fmt.parse("2016-02-06"));
		funcionario.setCpf("110.100.183-23");
		funcionario.setMatricula("322332");
		funcionario.setNascimento(fmt.parse("1980-07-20"));
		funcionario.setSalario(6.500f);
		uninfo = departamentoDAO.buscarPorAbreviacao("UNINFO");
		funcionario.setDepartamento(uninfo);

		dependente1 = new Dependente();
		dependente1.setNome("Dona Bala");
		dependente1.setTipoParentesco(TipoParentesco.CONJUGE);
		dependente1.setNascimento(fmt.parse("1982-08-10"));
		dependente1.setCpf("188.100.000-23");
		funcionario.addDependente(dependente1);

		dependente2 = new Dependente();
		dependente2.setNome("Balinha");
		dependente2.setTipoParentesco(TipoParentesco.FILHO);
		dependente2.setNascimento(fmt.parse("2018-11-05"));
		dependente2.setCpf("333.123.800-23");
		funcionario.addDependente(dependente2);

		funcionarioDAO.salvar(funcionario);

		funcionario = new Funcionario();
		funcionario.setNome("Diego Pessoa");
		funcionario.setAdmissao(fmt.parse("2011-02-04"));
		funcionario.setCpf("943.100.183-23");
		funcionario.setMatricula("1215343");
		funcionario.setNascimento(fmt.parse("1988-06-12"));
		funcionario.setSalario(2.500f);
		uninfo = departamentoDAO.buscarPorAbreviacao("UNINFO");
		funcionario.setDepartamento(uninfo);

		dependente1 = new Dependente();
		dependente1.setNome("Nina");
		dependente1.setTipoParentesco(TipoParentesco.CONJUGE);
		dependente1.setNascimento(fmt.parse("1988-08-10"));
		dependente1.setCpf("288.100.000-23");
		funcionario.addDependente(dependente1);

		dependente2 = new Dependente();
		dependente2.setNome("Murilo");
		dependente2.setTipoParentesco(TipoParentesco.FILHO);
		dependente2.setNascimento(fmt.parse("2017-11-06"));
		dependente2.setCpf("399.123.800-23");
		funcionario.addDependente(dependente2);

		dependente3 = new Dependente();
		dependente3.setNome("Marina");
		dependente3.setTipoParentesco(TipoParentesco.FILHO);
		dependente3.setNascimento(fmt.parse("2019-01-30"));
		dependente3.setCpf("399.883.800-23");
		funcionario.addDependente(dependente3);

		funcionarioDAO.salvar(funcionario);

		/** Atualizando departamento com os gerentes **/

		dg = departamentoDAO.buscarPorAbreviacao("DG");
		Funcionario gerenteDG = funcionarioDAO.buscarPorCPF("112.123.123-23");
		dg.setGerente(gerenteDG);
		departamentoDAO.atualizar(dg);

		de = departamentoDAO.buscarPorAbreviacao("DDE");
		Funcionario gerenteDE = funcionarioDAO.buscarPorCPF("118.185.123-23");
		de.setGerente(gerenteDE);
		departamentoDAO.atualizar(de);

		uninfo = departamentoDAO.buscarPorAbreviacao("UNINFO");
		Funcionario gerenteUninfo = funcionarioDAO.buscarPorCPF("110.105.123-23");
		uninfo.setGerente(gerenteUninfo);
		departamentoDAO.atualizar(uninfo);

	}

}
