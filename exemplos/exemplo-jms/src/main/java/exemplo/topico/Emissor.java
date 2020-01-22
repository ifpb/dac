package exemplo.topico;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Emissor {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) ic.lookup("jms/connectionFactory");
		
		Topic topico = (Topic) ic.lookup("jms/notificacoes");
		
		Session session = connectionFactory.createConnection().createSession();
		
		MessageProducer producer = session.createProducer(topico);
		
		Message msg = session.createTextMessage("Sao 08:50 do dia 22 de janeiro de 2020!");
		msg.setStringProperty("tipo", "tempo");
		
		Message msg2 = session.createTextMessage("24C");
		msg2.setStringProperty("tipo", "temperatura");
		
		producer.send(msg);
		producer.send(msg2);
		
		System.out.println("Mensagem enviada");
		
	}
	
}
