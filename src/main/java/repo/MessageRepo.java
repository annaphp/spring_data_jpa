package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Message;

public interface MessageRepo extends JpaRepository<Message,Long>{
	List<Message> findTop2ByContent(String content);
	
}
