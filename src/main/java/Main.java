import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
import model.Message;
import repo.MessageRepo;

public class Main {
	
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MessageRepo repo = context.getBean("messageRepo", MessageRepo.class);
		
	    repo.save(new Message("Hello"));
	    repo.save(new Message("Hello2"));
	    repo.save(new Message("Hello2"));
	    repo.save(new Message("Hello"));
	    //repo.delete(1L);
	    
	    for(Message mes : repo.findTop2ByContent("Hello")){
	    	System.out.println(mes);
	    }
		
//		for(String beanName : context.getBeanDefinitionNames()){
//			System.out.println(beanName);
//		}
		
	}

}
