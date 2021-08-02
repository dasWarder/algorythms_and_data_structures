package com.example.testing.hashing;

public class Item {

    private Integer data;

    public Item(Integer data) {
        this.data = data;
    }

    public Integer getKey(){
        return data;
    }
}
