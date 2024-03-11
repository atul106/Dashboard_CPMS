package com.dashboard.Dao;

import com.dashboard.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface tableRepository extends JpaRepository<Contact,Integer> {
//    @Query("from Contact as c WHERE c.user.id=:id")
//    public List<Contact> findContactByUser(@Param("id") int id);
}
