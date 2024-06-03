package ramenGo.com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ramenGo.com.demo.domain.entities.BrothEntity;
import ramenGo.com.demo.infra.repository.db.BrothRepository;
import ramenGo.com.demo.web.response.ErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/broths")

public class BrothsController {

    private BrothRepository repository;
    @Autowired
    private Environment env;

    public BrothsController(BrothRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Object> listBroths(@RequestHeader("x-api-key") String apiKey){

        if(apiKey == null || !apiKey.equals(env.getProperty("core.apiKey"))){
            return ResponseEntity.status(403).body(new ErrorResponse("x-api-key header missing"));
        }
        return ResponseEntity.ok(repository.findAll());
    }
}
