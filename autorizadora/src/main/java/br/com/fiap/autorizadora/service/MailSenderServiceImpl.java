package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.MailDTO;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSenderServiceImpl implements MailSenderService {
    private JavaMailSender javaMailSender;

    @Override
    public JavaMailSender createConnection(MailDTO mailDTO) {
        return null;
    }
}
