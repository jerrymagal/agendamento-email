package br.com.alura.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemErroDto {
	
	private List<String> mensagens;
	private Date dataErro;

	public static MensagemErroDto build(List<String> mensagens) {
		MensagemErroDto dto = new MensagemErroDto();
		dto.setMensagens(mensagens);
		dto.setDataErro(new Date());
		return dto;
	}
}
