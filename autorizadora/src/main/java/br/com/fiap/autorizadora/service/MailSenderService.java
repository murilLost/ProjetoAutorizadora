package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.entity.TransacaoEntity;

import java.util.List;

public interface MailSenderService {
    Boolean sendMail(List<TransacaoEntity> transacoesList, String email);

}

