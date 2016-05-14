package dk.topdanmark.registration.control;

import dk.topdanmark.registration.entity.User;

import javax.annotation.Resource;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendConfirmationEmail {

    @Resource(name = "email/system")
    Session mailSession;

    @Inject
    Logger logger;

    public void execute(@Observes User user) {
        logger.log(Level.INFO, "user.toString() = " + user.toString());
        Message msg = new MimeMessage(mailSession);
        try {
            msg.setSubject("Confirmation Mail");
            msg.setSentDate(new Date());
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail().getAddress()));
            msg.setText(createMailBody(user));
//            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String createMailBody(User user) {
        String mailBody = new StringBuilder()
                .append("Hello " + user.getName() + ", ")
                .append("\n\n")
                .append("Thanks for creating a user at the online auction house!")
                .append("\n")
                .append("You can now login to the auction using your email and the password 1234.")
                .append("\n")
                .append("You will be asked to change the provided password the first time you log into the system.")
                .append("\n\n")
                .append("Kind regards, Joe the digital auction user administrator")
                .toString();
        return mailBody;
    }

}
