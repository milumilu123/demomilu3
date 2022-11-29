package pe.interbank.openbanking.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static String getTemplate(String templatePath) {
        try{
            return IOUtils.toString(new ClassPathResource(templatePath).getInputStream(), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
