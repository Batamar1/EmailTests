package ru.melnikov.emailtest;

import emailtest.model.Email;
import emailtest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static emailtest.constants.ProjectConstants.*;

@Slf4j
public class Test_CheckDraft extends TestBase{
    @Test
    public void testCase1(){
        //TODO Logging
        //log.info(">>> Test_CheckDraft");
        User user = new User(LOGIN, PASSWORD);
        applicationManager.loginAs(user);
        applicationManager.checkLoginSuccess(user);
        Email email = new Email(Arrays.asList(RECEIVER1, RECEIVER2),SUBJECT, MESSAGE);
        applicationManager.fillEmailAndSave(email);
        applicationManager.checkSave(email);
        applicationManager.logout();
        applicationManager.checkLogout();

    }

}
