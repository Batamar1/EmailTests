package emailtest.model;

import lombok.Data;

import java.util.List;

@Data
public class Email {
    List<String> receivers;
    String subject;
    String text;
}
