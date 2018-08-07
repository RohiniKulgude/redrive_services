package com.hackathon.redrive_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private DealerService service;

    @RequestMapping(value = "/")
    public String hello(){
        return "hello!!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Dealer getDealer(String username){
        return service.getDealer(username);
    }

    @RequestMapping(value = "/dealers", method = RequestMethod.GET)
    public List<Dealer> getDealers(){
        return service.getDealers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addDealer(@RequestBody Dealer dealer){
        System.out.println("In post!!");
        service.addDealer(dealer);
    }

}
