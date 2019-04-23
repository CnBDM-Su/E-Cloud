package com.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MythicalMyproductsService {

    private final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    private DynamoDBMapper mapper = new DynamoDBMapper(client);

    public Myproducts getAllMyproducts() {

        List<Myproduct> myproducts = mapper.scan(Myproduct.class, new DynamoDBScanExpression());
        Myproducts allMyproducts = new Myproducts(myproducts);

        return allMyproducts;
    }

    public Myproduct getMyproduct(String productID){

        return mapper.load(Myproduct.class, productID);
    }

    public void saleMyproduct(String productID) {

        Myproduct myproductToUpdate = mapper.load(Myproduct.class, productID);
        Integer sales = myproductToUpdate.getCount() - 1;
        myproductToUpdate.setCount(sales);
        mapper.save(myproductToUpdate);

    }
}
