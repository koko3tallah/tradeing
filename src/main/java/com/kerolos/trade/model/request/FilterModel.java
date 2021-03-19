package com.kerolos.trade.model.request;

import lombok.Data;

@Data
public class FilterModel {

    private Long id;
    private Long account_id;
    private String group;
    private String cat;
    private Long user_id;
    private Double amount;
    private Double balance_change;
    private String currency;
    private String pair;
    private String dir;
    private String status;
    private Double winperc;
    private Double duration;
    private Double time_open;
    private Double time_close;
    private Double time_close_default;
    private Double curs_open;
    private Double curs_strike;
    private Double curs_close;
    private Boolean riskfree;
    private Boolean is_time;
    private Boolean refunded;

}
