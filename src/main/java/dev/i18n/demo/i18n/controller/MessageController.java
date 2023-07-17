package dev.i18n.demo.i18n.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageSource messageSource;

    public MessageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/message")
    public String acceptMessage(@RequestParam String text) {
        String returnMessage = messageSource.getMessage("word.saved", new Object[]{text}, LocaleContextHolder.getLocale());
        return returnMessage;
    }

}