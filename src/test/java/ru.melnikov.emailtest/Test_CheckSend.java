package ru.melnikov.emailtest;

import emailtest.model.Email;
import emailtest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static emailtest.constants.ProjectConstants.*;
import static emailtest.constants.ProjectConstants.MESSAGE;

@Slf4j
public class Test_CheckSend extends TestBase{
    @Test
    public void testCase1(){
        User user = new User(LOGIN, PASSWORD);
        applicationManager.loginAs(user);
        applicationManager.checkLoginSuccess(user);
        Email email = new Email(Arrays.asList(RECEIVER1, RECEIVER2),SUBJECT, MESSAGE);
        applicationManager.fillEmailAndSend(email);
        applicationManager.checkSend(email);
        applicationManager.logout();
        applicationManager.checkLogout();
    }
}
