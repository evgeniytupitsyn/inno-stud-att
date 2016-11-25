package com.nixmash.springdata.mail;

import com.nixmash.springdata.jpa.common.ApplicationSettings;
import com.nixmash.springdata.jpa.model.User;
import com.nixmash.springdata.jpa.service.UserService;
import com.nixmash.springdata.mail.common.MailSettings;
import com.nixmash.springdata.mail.components.MailSender;
import com.nixmash.springdata.mail.dto.MailDTO;
import com.nixmash.springdata.mail.service.FmMailService;
import com.nixmash.springdata.mail.service.FmMailServiceImpl;
import freemarker.template.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTests extends MailContext {

    private MailSender mockMailSender;
    private MailDTO mailDTO;

    private FmMailService mockMailService;
    private MailSettings mailSettings;
    private ApplicationSettings applicationSettings;
    private Configuration fm;
    private Environment environment;

    @Autowired
    UserService userService;

    @Before
    public void setUp() {
        mockMailSender = mock(MailSender.class);
        mockMailService =
                new FmMailServiceImpl(mockMailSender, mailSettings, applicationSettings, fm, environment);
        mailDTO = MailTestUtils.testMailDTO();
    }

    @Test
    public void contactSendsMimeMessage() throws MessagingException {
        mockMailService.sendContactMail(mailDTO);
        verify(mockMailSender, Mockito.times(1)).send(any(MimeMessagePreparator.class));
    }

    @Test
    public void passwordResetSendsMimeMessage() throws MessagingException {
        Optional<User> user = userService.getUserById(2L);
        String token = UUID.randomUUID().toString();
        mockMailService.sendResetPasswordMail(user.get(), token);
        verify(mockMailSender, Mockito.times(1)).send(any(MimeMessagePreparator.class));
    }

}
