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
	/*
	 * message won'be saved because transactional method
	 * throws exception, when proxy sees exception transaction
	 * is rolled back
	 */
	@Transactional
	public Message save(Message m){
		Message saved = repo.save(m);
		
		if(true) throw new RuntimeException();
		return saved;
	}

}
