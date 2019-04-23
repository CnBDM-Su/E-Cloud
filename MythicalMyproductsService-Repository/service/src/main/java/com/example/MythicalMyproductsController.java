package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
public class MythicalMyproductsController {

    @Autowired
    private MythicalMyproductsService mythicalMyproductsService = new MythicalMyproductsService();

    @RequestMapping(value="/myproducts", method=RequestMethod.GET)
    public Myproducts getMyproducts() {

        Myproducts myproducts;

        myproducts = mythicalMyproductsService.getAllMyproducts();

        return myproducts;
    }


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String healthCheckResponse() {
        return "Nothing here, used for health check. Try /myproducts instead.";
    }

    @RequestMapping(value="/myproducts/{productID}", method=RequestMethod.GET)
    public Myproduct getMyproduct(@PathVariable("productID") String productID) {

        Myproduct myproduct;
        myproduct = mythicalMyproductsService.getMyproduct(productID);

        return myproduct;
    }

    @RequestMapping(value="/myproducts/{productID}/sale", method=RequestMethod.GET)
    public ResponseEntity saleMyproduct(@PathVariable("productID") String productID) {

        mythicalMyproductsService.saleMyproduct(productID);

        return new ResponseEntity(HttpStatus.OK);
    }
}