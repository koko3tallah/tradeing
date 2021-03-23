package com.kerolos.trade.business;

import com.kerolos.trade.model.request.FilterModel;
import com.kerolos.trade.model.request.OlympTradeFilterResult;
import com.kerolos.trade.model.response.CalcDayResponse;
import com.kerolos.trade.model.response.CalcResponse;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalcBusiness {

    public CalcResponse calculatePeriodResult(OlympTradeFilterResult data) {

        Map<String, CalcDayResponse> CalcDayResponses = new HashMap<>();
        CalcResponse calcResponse = new CalcResponse();
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");


        for (FilterModel filterModel : data.getData()) {
            Date openDate = new Timestamp(Long.parseLong(filterModel.getTime_open().replace(".", "")));
            String openDateFormatted = f.format(openDate);
            CalcDayResponse CalcDayResponse;
            if (CalcDayResponses.get(openDateFormatted) == null) {
                CalcDayResponse = new CalcDayResponse();
                CalcDayResponse.setIs(filterModel.getBalance_change());
                CalcDayResponse.setYour_profit_for(openDateFormatted);
                CalcDayResponses.put(openDateFormatted, CalcDayResponse);
            } else {
                CalcDayResponse = CalcDayResponses.get(openDateFormatted);
                CalcDayResponse.setIs(CalcDayResponse.getIs().add(filterModel.getBalance_change()));
            }
            calcResponse.setYour_total_profit_is(calcResponse.getYour_total_profit_is().add(filterModel.getBalance_change()));
        }

        calcResponse.setPeriod(CalcDayResponses.values());
        return calcResponse;
    }

}
