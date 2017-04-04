package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Message;
import repo.MessageRepo;


@Service
public class MessageService2 {
	
	@Autowired
	MessageRepo repo;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Message saveInNewTransaction(Message m, boolean throwEx){
		Message saved = repo.save(m);
		if(throwEx) throw new RuntimeException();
		return saved;
	}

}
