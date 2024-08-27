package com.example.gestionclientes.services;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service("jetMailService")
public class JetMailService implements IEmailService{

    @Autowired
    private TemplateEngine templateEngine;





    @Override
    public void sendEmail(String asunto, List<String> to, String body) {

        //Todo Introducir tus keys para utilizar tu servicio de correo
        String apiKey = "apiKey";
        String apiSecret = "apiSecret";


            MailjetClient client;
            MailjetRequest request;
            MailjetResponse response;
            client = new MailjetClient(apiKey, apiSecret); //, new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "sergioprofe27@gmail.com")
                                        .put("Name", "Sergio S"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", to.get(0))))
                                .put(Emailv31.Message.SUBJECT, asunto)
                                .put(Emailv31.Message.TEXTPART, "Gracias por registrarse")
                                .put(Emailv31.Message.HTMLPART, body)));
            try {
                response = client.post(request);
            } catch (MailjetException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response.getStatus());
            System.out.println(response.getData());
        }


    @Override
    public void enviarEmailDeBienvenida(String asunto, List<String> to, String nombre) {
        Context context = new Context();
        context.setVariable("nombre", nombre);
        String mensajeHtml =  templateEngine.process("email", context);
        sendEmail(asunto, to, mensajeHtml);
    }
}
