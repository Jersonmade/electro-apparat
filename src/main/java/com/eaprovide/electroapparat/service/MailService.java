package com.eaprovide.electroapparat.service;

import com.eaprovide.electroapparat.dto.mail.MailOrderStructure;
import com.eaprovide.electroapparat.dto.mail.MailQuestionStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMailOrder(MailOrderStructure mailOrderStructure) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject("Оформление заказа");
        simpleMailMessage.setText("Общая стоимость - " + mailOrderStructure.getPrice() + "\n" +
                "Продукция:" + "\n" + mailOrderStructure.getProduct() + "\n" +
                "Фамилия - " + mailOrderStructure.getSurname() + "\n" +
                "Имя - " + mailOrderStructure.getName() + "\n" +
                "Название организации - " + mailOrderStructure.getNameOfOrganization() + "\n" +
                "ИНН - " + mailOrderStructure.getInn() + "\n" +
                "E-mail - " + mailOrderStructure.getEmail() + "\n" +
                "Телефон - " + mailOrderStructure.getNumberOfTelephone() + "\n" +
                "Адрес доставки - " + mailOrderStructure.getAddress()
        );
        simpleMailMessage.setTo("t.eltecshop@ea-provide.com");

        javaMailSender.send(simpleMailMessage);
    }

    public void sendMailQuestion(MailQuestionStructure mailQuestionStructure) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject("Вопрос");
        simpleMailMessage.setText("Имя - " + mailQuestionStructure.getName() + "\n" +
                "Фамилия - " + mailQuestionStructure.getSurname() + "\n" +
                "Телефон - " + mailQuestionStructure.getNumberOfTelephone() + "\n" +
                "E-mail - " + mailQuestionStructure.getEmail() + "\n" +
                "Вопрос - " + mailQuestionStructure.getQuestion()
        );
        simpleMailMessage.setTo("t.eltecshop@ea-provide.com");

        javaMailSender.send(simpleMailMessage);
    }
}
