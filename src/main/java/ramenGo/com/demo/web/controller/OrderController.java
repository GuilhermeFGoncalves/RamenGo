package ramenGo.com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ramenGo.com.demo.domain.service.OrderService;
import ramenGo.com.demo.web.request.OrderCreateRequest;
import ramenGo.com.demo.web.response.ErrorResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    private Environment env;

    private OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody @Valid OrderCreateRequest request, @RequestHeader("x-api-key") String apiKey){

        if(apiKey == null || !apiKey.equals(env.getProperty("core.apiKey"))){
            return ResponseEntity.status(403).body(new ErrorResponse("x-api-key header missing"));
        }

        try{
            return ResponseEntity.ok(service.createOrder(request));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new ErrorResponse("both brothId and proteinId are required"));
        }
    }
}
