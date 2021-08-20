package com.ftn.ApotekaApp.listener;

import com.ftn.ApotekaApp.event.OnRegistrationCompleteEvent;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private KorisnikService korisnikService;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
        Korisnik user = onRegistrationCompleteEvent.getUser();
        String token = UUID.randomUUID().toString();
        korisnikService.createRegistrationVerificationToken(user, token);

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("bsepmejl@outlook.com");
        email.setTo(user.getEmail());
        email.setSubject("Apoteka - Potvrdite registraciju");
        email.setText("http://localhost:8080/auth/registration-confirm/" + token);
        mailSender.send(email);

        System.out.println("ISSUED TOKEN: " + token);
    }
}
