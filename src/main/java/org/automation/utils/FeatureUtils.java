package org.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.automation.entity.Account;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class FeatureUtils {
    public static String URL = "http://127.0.0.1:9001";
    public static Account getMockAccount() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("Account.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Account.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
