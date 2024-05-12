package com.study.tdd.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths=payData.getPayAmount()/10_000;
        if(payData.getFirstBillingDate()!=null){
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            if(payData.getFirstBillingDate().getDayOfMonth()!=
                    candidateExp.getDayOfMonth()){
                return candidateExp.withDayOfMonth(
                        payData.getFirstBillingDate().getDayOfMonth());
            }//if-2
        }//if-1
        return payData.getBillingDate().plusMonths(addedMonths);
    }
}
