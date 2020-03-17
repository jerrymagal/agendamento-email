package br.com.alura.exception;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ApplicationException;

import lombok.Getter;

@Getter
@ApplicationException(rollback = true)
public class BusinessException extends Exception {
	
	private List<String> mensagens;

	private static final long serialVersionUID = 1L;
	
	public BusinessException() {
		mensagens = new ArrayList<>();
	}

	public BusinessException(String msg) {
		super(msg);
		mensagens = new ArrayList<>();
		mensagens.add(msg);
	}
	
	public void addMensagem(String msg) {
		mensagens.add(msg);
	}
}
