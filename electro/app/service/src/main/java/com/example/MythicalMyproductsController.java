package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MythicalMyproductsController {

    @Autowired
    private MythicalMyproductsService mythicalMyproductsService = new MythicalMyproductsService();

    @RequestMapping(value="/myproducts", method=RequestMethod.GET)
    public Myproducts getMyproducts(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return mythicalMyproductsService.getAllMyproducts();
    }


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String healthCheckResponse() {
        return "Nothing here, used for health check. Try /myproducts instead.";
    }

}