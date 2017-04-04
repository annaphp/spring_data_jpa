package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Message;
import repo.MessageRepo;


@Service
public class MessageService {
	
	@Autowired
	MessageRepo repo;
	
	@Autowired
	MessageService2 service2;
	
	private static final boolean THROW_X = true;
	private static final boolean DONT_THROW_X = false;
	/*
	 * message won'be saved because transactional method
	 * throws exception, when proxy sees exception transaction
	 * is rolled back
	 */

	/*
	 * outer transaction succeeds, inner fails
	 * inner method throws exception and rolls back its own transaction
	 * it has it's own transaction because of REQUIRES_NEW annotation
	 * outer transaction succeeds because of try catch block - excepiton was
	 * handled. Without try catch outer transaction is rolled back too
     * because exception is thrown
	 */
	@Transactional
	public Message save1(Message m){
		
		try{
			service2.saveInNewTransaction(new Message("Pupla"), THROW_X);
		}catch(RuntimeException re){}
		
		Message saved = repo.save(m);
		return saved;
	}
	
	/*
	 * inner succeeds outer fails
	 * inner succeeds because exception is not thrown in it, and since
	 * it has its own transaction it executes successfully 
	 * outer fails because of the thrown exception 
	 */
	@Transactional
     public Message save2(Message m){
		service2.saveInNewTransaction(new Message("Pupla"), DONT_THROW_X);
		Message saved = repo.save(m);
	    throw new RuntimeException();
	}

	/*
	 * outer and inner succeed 
	 * because no exception is thrown 
	 */
	@Transactional
	public Message save3(Message m){
	    service2.saveInNewTransaction(new Message("Pupla"), DONT_THROW_X);	
		Message saved = repo.save(m);
		return saved;
	 
	}

}
