import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Percorrer {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) ic.lookup("jms/connectionFactory");
		
		Connection connection = connectionFactory.createConnection();
		
		Queue filaIfpbcz = (Queue) ic.lookup("jms/ifpbcz");
		
		Session session = connection.createSession();
		
		QueueBrowser navegador = session.createBrowser(filaIfpbcz);
		
		Enumeration itens = navegador.getEnumeration();
		
		while(itens.hasMoreElements()) {
			TextMessage message = (TextMessage)itens.nextElement();
			System.out.println("Mensagem = "+message.getText());
		}
		
	}
	
}
