package com.kerolos.trade.controller;

import com.kerolos.trade.business.CalcBusiness;
import com.kerolos.trade.model.request.OlympTradeFilterResult;
import com.kerolos.trade.model.response.CalcResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    private final CalcBusiness calcBusiness;

    public Calculator(CalcBusiness calcBusiness) {
        this.calcBusiness = calcBusiness;
    }

    @PostMapping("/calc")
    private ResponseEntity<CalcResponse> calculatePeriodResult(@RequestBody OlympTradeFilterResult data) {
        try {
            CalcResponse calcResponse = calcBusiness.calculatePeriodResult(data);
            return new ResponseEntity<>(calcResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
