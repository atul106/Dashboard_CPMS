package com.dashboard;

import com.dashboard.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class DashboardApplication  implements CommandLineRunner {
 @Autowired
    private UserDao userDao;
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.userDao.createTable());

        this.createUser();
    }

    public void createUser() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter user ID");
        Integer id = Integer.parseInt(br.readLine());

        System.out.println("Enter user Name");
        String name = br.readLine();

        System.out.println("Enter user age");
        Integer age = Integer.parseInt(br.readLine());

        System.out.println("Enter user City");
        String city = br.readLine();

        int i = this.userDao.insertUser(id, name, age, city);

        System.out.println(i + "User Added");
    }
}
