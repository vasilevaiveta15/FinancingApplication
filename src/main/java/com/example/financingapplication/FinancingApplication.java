package com.example.financingapplication;

import com.example.financingapplication.users.UserDetail;
import com.example.financingapplication.users.UserDetailDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FinancingApplication
{

  public static void main(String[] args)
  {
    ConfigurableApplicationContext cxt = SpringApplication.run(FinancingApplication.class, args);
   // insertUserAdminInDatabase(cxt);
  }

  private static void insertUserAdminInDatabase(ConfigurableApplicationContext cxt)
  {
    UserDetailDao userDao = cxt.getBean(UserDetailDao.class);
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String pass = passwordEncoder.encode("Pass!123");
    UserDetail admin = new UserDetail("Iveta", "Vasileva", "iveta_vasileva@abv.bg", pass,
        UserDetail.RoleName.valueOf("ADMIN"), "N");
    userDao.registrationUser(admin);
  }

}
