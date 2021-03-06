package kr.co.inslab.utils;


import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SesMailSendingService implements MailSending {

    private final Logger logger = LoggerFactory.getLogger(SesMailSendingService.class);

    private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;

    public SesMailSendingService(AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync) {
        this.amazonSimpleEmailServiceAsync = amazonSimpleEmailServiceAsync;
    }

    @Override
    public void sendHtmlEmail(String from, String to, String subject, String html) {
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withBody(new Body()
                                .withHtml(new Content()
                                        .withCharset("UTF-8").withData(html))
                                .withText(new Content()
                                        .withCharset("UTF-8").withData(html)))
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(subject)))
                .withSource(from);

        amazonSimpleEmailServiceAsync.sendEmail(request);
    }
}
