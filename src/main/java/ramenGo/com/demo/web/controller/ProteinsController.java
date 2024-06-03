package ramenGo.com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ramenGo.com.demo.domain.entities.ProteinsEntity;
import ramenGo.com.demo.infra.repository.db.ProteinsRepository;
import ramenGo.com.demo.web.response.ErrorResponse;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/proteins")

public class ProteinsController {

    @Autowired
    private Environment env;
    private ProteinsRepository repository;

    public ProteinsController(ProteinsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Object> listProteins(@RequestHeader("x-api-key") String apiKey){

        if(apiKey == null || !apiKey.equals(env.getProperty("core.apiKey"))){
            return ResponseEntity.status(403).body(new ErrorResponse("x-api-key header missing"));
        }
        return ResponseEntity.ok(repository.findAll());
    }
}
