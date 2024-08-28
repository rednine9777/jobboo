package com.example.jobboo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.jobboo.entity.User;
import com.example.jobboo.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  @Transactional
  @Rollback(false)
  public void testInsertAndRetrieveUser() {
    User user1 = new User(null, "권도형", "퍼실");

    userRepository.saveAll(List.of(user1));
  }
}
