package Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;

public class AppMail {

    public static void main(String[] args) {
        try {
            new MailJavaSender().senderMail(new MailJava("Pedro Freitas","soufreitas.pedro@gmail.com","Saiu para Entrega"));
            System.out.print("Feito");
        } catch (UnsupportedEncodingException | MessagingException e) {
            System.out.print(e.getMessage());
        }
    }
}
