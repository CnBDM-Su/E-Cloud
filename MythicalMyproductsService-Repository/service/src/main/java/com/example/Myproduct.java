package com.example;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="MyproductsTable")
public class Myproduct {

    private String productID;
    private String name;
    private String price;
    private String currentPrice;
    private String description;
    private String profileImageUri;
    private Integer count;
    public Myproduct() {
    }

    @DynamoDBHashKey(attributeName="ProductID")
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @DynamoDBAttribute(attributeName="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName="Price")
     public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    @DynamoDBAttribute(attributeName="CurrentPrice")
     public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    @DynamoDBAttribute(attributeName="Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute(attributeName="ProfileImageUri")
    public String getProfileImageUri() {
        return profileImageUri;
    }

    public void setProfileImageUri(String profileImageUri) {
        this.profileImageUri = profileImageUri;
    }
    
    @DynamoDBAttribute(attributeName="Count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
}
