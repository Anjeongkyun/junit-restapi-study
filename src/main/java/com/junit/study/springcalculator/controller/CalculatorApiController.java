package com.junit.study.springcalculator.controller;

import com.junit.study.springcalculator.component.Calculator;
import com.junit.study.springcalculator.dto.Request;
import com.junit.study.springcalculator.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y){

        return calculator.sum(x,y);
    }

    @PostMapping("/minus")
    public Response minus(@RequestBody Request req){

        int minusResult = calculator.minus(req.getX(), req.getY());

        Response res = new Response();
        res.setResult(minusResult);
        res.setResponse(new Response.Body());
        return res;
    }
}
