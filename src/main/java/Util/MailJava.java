package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailJava {

    public String nome;
    public String email;
    public static final String TYPE_TEXT_PLAIN = "text/plain";
    public static final String TYPE_TEXT_HTML = "text/html";
    private final String smtpHostMail = "smtp.gmail.com";
    private final String smtpPortMail = "587";
    private final String smtpAuth = "true";
    private String smtpStarttls = "true";
    private String fromNameMail = "Uai Food Delivery";
    private final String userMail = "uaifat.delivery@gmail.com";
    private final String passMail = "padrao2018";
    private String subjectMail = "Atualização do estado do Pedido UaiFood - ";
    private String estado;
    private final String charsetMail = "ISO-8859-1";
    private final String typeTextMail = MailJava.TYPE_TEXT_HTML;
    private final String caminho = System.getProperty("user.dir") + "\\src\\main\\webapp\\email.html";

    public MailJava(String nome, String email, String estado) {
        this.nome = nome;
        this.email = email;
        this.subjectMail = subjectMail + estado.toUpperCase();
        this.estado = estado;
    }

    public String getSmtpStarttls() {
        return smtpStarttls;
    }

    public void setSmtpStarttls(String smtpStarttls) {
        this.smtpStarttls = smtpStarttls;
    }

    public String getFromNameMail() {
        return fromNameMail;
    }

    public void setFromNameMail(String fromNameMail) {
        this.fromNameMail = fromNameMail;
    }

    public String getToMailUser() {
        return this.email;
    }

    public String getToMailUserName() {
        return this.nome;
    }

    public String getBodyMail() {
        try {
            return getEmail();
        } catch (IOException ex) {
            Logger.getLogger(MailJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getSmtpHostMail() {
        return smtpHostMail;
    }

    public String getSmtpPortMail() {
        return smtpPortMail;
    }

    public String getSmtpAuth() {
        return smtpAuth;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getPassMail() {
        return passMail;
    }

    public String getSubjectMail() {
        return subjectMail;
    }

    public String getCharsetMail() {
        return charsetMail;
    }

    public String getTypeTextMail() {
        return typeTextMail;
    }

    private String getEmail() throws IOException, FileNotFoundException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("$nome", this.nome);
        map.put("$estado", this.estado);
        map.put("$subjectMail", this.subjectMail);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(caminho), "UTF8"));
        StringBuilder emailEnviar = new StringBuilder();
        for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linha = this.searchAndReplace(linha, entry.getKey(), entry.getValue());
            }
            emailEnviar.append(linha);

        }
        br.close();
        return emailEnviar.toString();
    }

    private String searchAndReplace(String linha, String search, String replace) {
        return linha.replace(search, replace);
    }
}
