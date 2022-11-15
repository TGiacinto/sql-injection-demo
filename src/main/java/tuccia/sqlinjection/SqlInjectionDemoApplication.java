package tuccia.sqlinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tuccia.sqlinjection.model.User;
import tuccia.sqlinjection.repository.UserRepository;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

@SpringBootApplication
public class SqlInjectionDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SqlInjectionDemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("abc123".getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        userRepository.save(User.builder()
                        .lastname("Tuccia")
                        .username("test@test.it")
                        .firstname("Giak")
                        .password(myHash)
                .build());

    }
}
