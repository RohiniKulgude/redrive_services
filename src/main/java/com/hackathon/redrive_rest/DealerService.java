package com.hackathon.redrive_rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DealerService {

    private static final String FILE_NAME = "C:\\Users\\malir\\Desktop\\redrive_rest\\src\\main\\resources\\d_auth.json";

    public ObjectMapper mapper = new ObjectMapper();

    public List<Dealer> getDealers(){
        TypeReference<List<Dealer>> mapType = new TypeReference<List<Dealer>>() {};
        List<Dealer> dealers = null;
        try {
            JsonNode jsonDealers = Util.getJsonNode(FILE_NAME);
            dealers = mapper.readValue(jsonDealers.toString(), mapType);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return dealers;
    }


    public  Dealer getDealer(String username){
        try {
            JsonNode dealers = Util.getJsonNode(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDealer(Dealer dealer) {
        Dealer d = new Dealer(dealer);
        ObjectNode dealerNode = mapper.createObjectNode();
        dealerNode.put("username",d.getUsername());
        dealerNode.put("password",d.getPassword());
        dealerNode.put("name",d.getName());
        dealerNode.put("id",d.getId());
        List<Dealer> dealers = getDealers();
        if(dealers == null){
            System.out.println(dealers);
            dealers = new ArrayList<>();

        }
        dealers.add(d);
        System.out.println(dealers);

        try {
            mapper.writeValue(new File(FILE_NAME), dealers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
