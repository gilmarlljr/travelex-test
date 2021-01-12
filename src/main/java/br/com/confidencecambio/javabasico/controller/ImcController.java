package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.response.Response;
import br.com.confidencecambio.javabasico.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/imc")
public class ImcController {
    @Autowired
    private ImcService service;

    @GetMapping(params = {"peso", "altura"})
    public ResponseEntity<Response<BigDecimal>> getImac(@RequestParam("peso") String peso, @RequestParam("altura") String altura) {
        List<String> errors = new ArrayList<>();
        try {
            return ResponseEntity.ok(new Response<>(service.getImc(peso, altura)));
        } catch (Exception e) {
            errors.add(e.getMessage());
            return ResponseEntity.badRequest().body(new Response<>(errors));
        }
    }
}
