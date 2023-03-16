package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.dto.MailDTO;
import br.com.fiap.autorizadora.entity.TransacaoEntity;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public interface MailSenderService {
    Boolean sendMail(List<TransacaoEntity> transacoesList, String email);



}

