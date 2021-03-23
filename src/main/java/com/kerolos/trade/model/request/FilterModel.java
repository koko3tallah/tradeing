package com.kerolos.trade.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilterModel {

    private Long id;
    private Long account_id;
    private String group;
    private String cat;
    private Long user_id;
    private BigDecimal amount;
    private BigDecimal balance_change;
    private String currency;
    private String pair;
    private String dir;
    private String status;
    private BigDecimal winperc;
    private BigDecimal duration;
    private String time_open;
    private String time_close;
    private String time_close_default;
    private BigDecimal curs_open;
    private BigDecimal curs_strike;
    private BigDecimal curs_close;
    private Boolean riskfree;
    private Boolean is_time;
    private Boolean refunded;

}
