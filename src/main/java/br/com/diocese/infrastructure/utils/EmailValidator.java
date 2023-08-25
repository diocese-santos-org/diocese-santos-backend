package br.com.diocese.infrastructure.utils;

import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class EmailValidator {

    public static boolean validandoEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
