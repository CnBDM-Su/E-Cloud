package com.example;

import java.util.List;

public class Myproducts {

    private List<Myproduct> Myproducts;

    public Myproducts(List<Myproduct> Myproducts) {
        this.Myproducts = Myproducts;
    }

    public Myproducts() {}

    public java.util.List<Myproduct> getMyproducts() {
        return Myproducts;
    }

    public void setMyproducts(List<Myproduct> Myproducts) {
        this.Myproducts = Myproducts;
    }
}
