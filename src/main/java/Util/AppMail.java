package Util;

import Modelos.Colaborador;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;

public class AppMail {

    public static void main(String[] args) {
        List<Colaborador> colaboradores = new ArrayList<>();
        colaboradores.add(new Colaborador("soufreitas.pedro@gmail.com", "Pedro Freitas"));
        colaboradores.add(new Colaborador("diasjp1997@gmail.com", "João Paulo Dias"));
        List<MailJava> emails = new ArrayList<>();
        for(Colaborador colaborador:colaboradores){
        }

        try {
            new MailJavaSender().senderMail(new MailJava());
            System.out.print("Feito");
        } catch (UnsupportedEncodingException | MessagingException e) {
            System.out.print(e.getMessage());
        }
    }
}
