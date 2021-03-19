package com.kerolos.trade.business;

import com.kerolos.trade.model.request.OlympTradeFilterResult;
import com.kerolos.trade.model.response.CalcResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class CalcBusiness {

    public CalcResponse calculatePeriodResult(OlympTradeFilterResult data) {
        AtomicReference<Double> totalProfitOrLoss = new AtomicReference<>(0d);

        data.getData().forEach(filterModel ->
                totalProfitOrLoss.updateAndGet(v -> v + filterModel.getBalance_change())
        );

        CalcResponse calcResponse = new CalcResponse();
        calcResponse.setYour_profit_today_is(totalProfitOrLoss.get());

        return calcResponse;
    }
}
