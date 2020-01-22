package exemplo.fila;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Emissor {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) ic.lookup("jms/connectionFactory");
		
		Queue filaIfpbcz = (Queue) ic.lookup("jms/ifpbcz");
		
		Session session = connectionFactory.createConnection().createSession();
		
		MessageProducer producer = session.createProducer(filaIfpbcz);
		
		Message msg = session.createTextMessage("Palmeiras não tem mundial!");
		
		producer.send(msg);
		
		System.out.println("Mensagem enviada");
		
	}
	
}
