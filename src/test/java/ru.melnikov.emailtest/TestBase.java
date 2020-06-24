package ru.melnikov.emailtest;

import emailtest.applogic.ApplicationManager;
import emailtest.config.SpringConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)

public class TestBase {
    @Autowired
    protected ApplicationManager applicationManager;
}
