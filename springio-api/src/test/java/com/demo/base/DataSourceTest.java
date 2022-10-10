package com.demo.base;

import static org.junit.Assert.assertTrue;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private StringEncryptor stringEncryptor;
    
    @Test
    public void encodePassword() {
        String password = "root";
        
        String encryption = stringEncryptor.encrypt(password);
        String decryption = stringEncryptor.decrypt(encryption);

        System.out.println("===========================================");  
        System.out.println("Encryption: " + encryption);
        System.out.println("===========================================");  
        System.out.println("Decryption: " + decryption);
        System.out.println("===========================================");
        
        assertTrue(password.equals(decryption));
    }
}
