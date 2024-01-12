package funciones;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FuncionEnvioCorreos {
    public static int numeroVerificacion = 0;

    /**
     * Esta función sirve para enviar mails desde el gestor, con un destinatario, asunto y cuerpo.
     * @param destinatario
     * @param asunto
     * @param cuerpo
     */
    public static void enviarGmailGestor(String destinatario, String asunto, String cuerpo) {
        String remitente = "david.galan.1005@fernando3martos.com";
        String clave = "mapvlhnpqjtcskwt";

        Properties props = getProperties();
        // Se obtiene la sesión en el servidor de correo
        Session session = Session.getDefaultInstance(props);
        try {
            // Creación del mensaje a enviar
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            //message.setText(cuerpo); // Para enviar texto plano
            message.setContent(cuerpo, "text/html; charset=utf-8"); // Para enviar html
            // Definición de los parámetros del protocolo de transporte
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    /**
     * Esta función se usa para la configuración del servidor de Google
     * @return Devuelve la configuración del servidor.
     */
    public static Properties getProperties() {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Google
        props.put("mail.smtp.user", "david.galan.1005@fernando3martos.com");
        props.put("mail.smtp.clave", "mapvlhnpqjtcskwt");
        props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); // Conectar de manera segura
        props.put("mail.smtp.port", "587"); // Puerto SMTP seguro de Google
        return props;
    }
    public static void destinatarioGmail() {
        numeroVerificacion = (int) (Math.random() * (9999 - 999 + 1)) + 999;
        String destinatario = "davidgalan001@gmail.com";
        String asunto = "Código de Verificación 2 pasos";
        String cuerpo = "<h1>Este correo es privado</h1>" +
                "<p>Código: <strong>" + numeroVerificacion + "</strong></p>";
        enviarGmailGestor(destinatario, asunto, cuerpo);
    }

    /**
     * Esta función es la encargada de mandar los códigos de verificación de los correos electrónicos enviados por el programa
     * @param correoElectronico
     */
    public static void destinatarioGmail2(String correoElectronico) {
        numeroVerificacion = (int) (Math.random() * (9999 - 999 + 1)) + 999;
        String destinatario = correoElectronico;
        String asunto = "Código de Verificación 2 pasos";
        String cuerpo = "<h1>Este correo es privado</h1>" +
                "<p>Código: <strong>" + numeroVerificacion + "</strong></p>";
        enviarGmailGestor(destinatario, asunto, cuerpo);
    }
}
