package com.eaprovide.electroapparat.controller;

import com.eaprovide.electroapparat.dto.MailOrderStructure;
import com.eaprovide.electroapparat.dto.MailQuestionStructure;
import com.eaprovide.electroapparat.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public String sendMailOrder(@RequestBody MailOrderStructure mailOrderStructure) {
        mailService.sendMailOrder(mailOrderStructure);
        return "message of order sent successfully";
    }

    @PostMapping("/question")
    @ResponseStatus(HttpStatus.OK)
    public String sendMailQuestion(@RequestBody MailQuestionStructure mailQuestionStructure) {
        mailService.sendMailQuestion(mailQuestionStructure);
        return "message of question sent successfully";
    }
}
