package com.example.sales.appli.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.appli.Entity.SalesManLogin;
import com.example.sales.appli.Repository.SalesManRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service 
public class SalesManService {
    
    @Autowired  SalesManRepository salesManRepository;
    @Autowired  PasswordEncoder passwordEncoder;

    public SalesManLogin addlogin(SalesManLogin salesManLogin){
        String encodedPassword = 
                   passwordEncoder.encode(salesManLogin.getPassword());
                   salesManLogin.setPassword(encodedPassword);
                   return salesManRepository.save(salesManLogin);
    }

public boolean verifyLogin(String salesName, String rawPassword) {

    SalesManLogin salesman =
            salesManRepository.findBySalesName(salesName);

    if (salesman == null) {
        return false;
    }

    return passwordEncoder.matches(
            rawPassword,
            salesman.getPassword()
    );
}
}