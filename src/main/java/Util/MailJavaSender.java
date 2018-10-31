package Util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MailJavaSender {

    //cria as propriedades necessarias para o envio de email
    public void senderMail(final MailJava mail) throws
            UnsupportedEncodingException, MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mail.getSmtpHostMail());
        props.setProperty("mail.smtp.auth", mail.getSmtpAuth());
        props.setProperty("mail.smtp.starttls.enable", mail.getSmtpStarttls());
        props.setProperty("mail.smtp.port", mail.getSmtpPortMail());
        props.setProperty("mail.mime.charset", mail.getCharsetMail());
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.ssl", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //classe anonima que realiza a autenticacao
        //do usuario no servidor de email.
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        mail.getUserMail(), mail.getPassMail()
                );
            }
        };

        // Cria a sessao passando as propriedades e a autenticacao
        Session session = Session.getDefaultInstance(props, auth);
        // Gera um log no console referente ao processo de envio
        session.setDebug(false);

        //cria a mensagem setando o remetente e seus destinatarios
        Message msg = new MimeMessage(session);
        //aqui seta o remetente
        msg.setFrom(new InternetAddress(
                mail.getUserMail(), mail.getFromNameMail())
        );
        //setamos o 1° destinatario
        msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress(mail.getToMailUser(), mail.getToMailUserName())
        );

        // Adiciona um Assunto a Mensagem
        msg.setSubject(mail.getSubjectMail());

        // Cria o objeto que recebe o texto do corpo do email
        MimeBodyPart textPart = new MimeBodyPart();

        textPart.setContent(mail.getBodyMail(), mail.getTypeTextMail());

        // Monta a mensagem SMTP  inserindo o conteudo, texto e anexos
        Multipart mps = new MimeMultipart();

        //adiciona o corpo texto da mensagem
        mps.addBodyPart(textPart);

        //adiciona a mensagem o conteudo texto e anexo
        msg.setContent(mps);

        // Envia a Mensagem
        Transport.send(msg);
    }
}
