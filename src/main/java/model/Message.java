package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	private String content;

	public Message(String content) {
		this.content = content;
	}

	public Message() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}
	
	
	
	

}
