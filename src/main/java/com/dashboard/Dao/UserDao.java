package com.dashboard.Dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserDao(){


    }

    public int createTable(){
        String query = "CREATE TABLE IF NOT EXISTS Usertest(id int primary key, name varchar(200),age int , city varchar(100))";
        int update = this.jdbcTemplate.update(query);
        System.out.println("Constructor called " + update);
        return  update;
    }

    public int insertUser(Integer id, String name, Integer age, String city){
          String query = "insert into usertest(id,name,age,city) values(?,?,?,?)";
        int update = this.jdbcTemplate.update(query, new Object[]{id, name, age, city});

        return update;
    }




}
