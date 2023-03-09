package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.MailDTO;
import org.springframework.mail.javamail.JavaMailSender;

public interface MailSenderService {
    JavaMailSender createConnection(MailDTO mailDTO);

}
