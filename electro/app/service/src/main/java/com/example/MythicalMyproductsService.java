package com.example;

import org.springframework.stereotype.Service;


@Service
public class MythicalMyproductsService {

    private Myproducts allMyproducts;

    public void save(Myproducts myproducts) {
        allMyproducts = myproducts;
    }

    public Myproducts getAllMyproducts() {
        return allMyproducts;
    }
}
