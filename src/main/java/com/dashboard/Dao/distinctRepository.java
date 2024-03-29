package com.dashboard.Dao;

import com.dashboard.entities.Cpms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface distinctRepository extends JpaRepository<Cpms,Integer> {
    @Query("SELECT COUNT(DISTINCT d.id) FROM Cpms d")
    Long cpms();

    @Query("SELECT COUNT(c) FROM Cpms c WHERE c.City = 'Mumbai'")
    Long countByCityMumbai();
}
