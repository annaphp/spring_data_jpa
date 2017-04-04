import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
import model.Message;
import service.MessageService;

public class Main {
	
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		
		
		MessageService service= context.getBean("messageService", MessageService.class);
		
	    service.save(new Message("Hello buddha"));
	   
	    
	    
	}

}
