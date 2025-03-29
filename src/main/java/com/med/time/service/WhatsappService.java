package com.med.time.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsappService {

    @Value("${SEU_ACCOUNT_SID_AQUI}")
    private String accountSid;

    @Value("${SEU_AUTH_TOKEN_AQUI}")
    private String authToken;

    @Value("${SEU_NUMERO_TWILIO}")
    private String fromNumber;

    private boolean initialized = false;

    private void init() {
        if (!initialized) {
            Twilio.init(accountSid, authToken);
            initialized = true;
        }
    }

    public void enviarMensagem(String telefone, String mensagem) {
        init();

        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + telefone),
                new PhoneNumber( fromNumber),
                mensagem
        ).create();

        System.out.println("📤 Mensagem enviada com SID: " + message.getSid());
    }
}
