package application.features.auth.application.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public  class PasswordUtils {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validator(String password, String hashed) {
        return passwordEncoder.matches(password, hashed);
    }

    public String hash(String value){
        return passwordEncoder.encode(value);
    }

}
