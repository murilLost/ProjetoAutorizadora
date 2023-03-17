package br.com.fiap.autorizadora.service;

import br.com.fiap.autorizadora.entity.TransacaoEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MailSenderServiceImpl implements MailSenderService {

    @Value("${spring.mail.username}")
    private String remetenteEmail;
    private JavaMailSender mailSender; //Para pegar as configuracoes no application.yml
    public MailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public Boolean sendMail(List<TransacaoEntity> transacoesList, String destinatarioEmail) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Extrato Cartão: " + transacoesList.get(0).getCartao().getNumero() );

        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String corpoEmail = "";

        for (TransacaoEntity transacao : transacoesList) {
            corpoEmail += "Data e hora: " + transacao.getDataTransacao().format(formatoDataHora)  + ", R$ " + transacao.getValor() + "\n" ;
        }

        message.setText("Seu extrato: \n" + corpoEmail);
        message.setTo(destinatarioEmail);
        message.setFrom(remetenteEmail);
        try {
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
