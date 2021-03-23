package com.kerolos.trade.model.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class CalcResponse {

    // lol :D
    private BigDecimal your_total_profit_is = BigDecimal.ZERO;
    private Collection<CalcDayResponse> period;
}
