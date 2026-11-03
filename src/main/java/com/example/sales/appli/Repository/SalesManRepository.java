package com.example.sales.appli.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.appli.Entity.SalesManLogin;
import java.util.List;


@Repository 
public interface SalesManRepository extends JpaRepository<SalesManLogin, Long> {
    
    SalesManLogin findBySalesName(String salesName);
}
