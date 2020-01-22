import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Receptor {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) ic.lookup("jms/connectionFactory");
		
		Connection connection = connectionFactory.createConnection();
		
		Queue filaIfpbcz = (Queue) ic.lookup("jms/ifpbcz");
		
		Session session = connection.createSession();
		
		MessageConsumer consumer = session.createConsumer(filaIfpbcz);
		
		System.out.println("Esperando mensagem chegar");
		
		connection.start();
		TextMessage message = (TextMessage) consumer.receive();
		
		System.out.println("Mensagem recebida = "+message.getText());
		
	}
	
}
