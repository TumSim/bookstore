package tssof03.bookstore;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tssof03.bookstore.domain.User;
import tssof03.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class UserRepositoryTest {

@Autowired
private UserRepository userRepository;

@Test
public void newUser(){
    User user = new User("Test1234", "Testpassword", "test@test.com", "ADMIN");

    userRepository.save(user);
    assertThat(user.getUsername()).isEqualTo("Test1234");
}

@Test
public void deleteUser(){
    User user = new User("Test1234", "Testpassword", "test@test.com", "ADMIN");
    userRepository.delete(user);
    assertThat(userRepository.findByUsername(user.getUsername())).isNull();
}

@Test
public void findUser(){
    User user = userRepository.findByUsername("admin");

    assertThat(user.getEmail()).isEqualTo("admin@admin.com");
}



}
