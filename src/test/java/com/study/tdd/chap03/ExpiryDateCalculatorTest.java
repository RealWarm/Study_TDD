package com.study.tdd.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpiryDateCalculatorTest {

    private void assertExpiryDate(
            LocalDate billingDate,
            int payAmount,
            LocalDate expectedExpiryDate
    ){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }//assertExpiryDate

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨1(){
        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(LocalDate.of(2019, 4, 1), expiryDate);
        //////////////////////////////////////////////////////////////////////////////
        LocalDate billingDate2 = LocalDate.of(2019, 5, 5);
        int payAmount2 = 10_000;
        ExpiryDateCalculator cal2=new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);
        assertEquals(billingDate2.of(2019, 6, 5), expiryDate2);
    }//만원_납부하면_한달_뒤가_만료일이_됨

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨_리팩토링(){
        assertExpiryDate(LocalDate.of(2019, 3, 1), 10_000, LocalDate.of(2019, 4, 1));
        assertExpiryDate(LocalDate.of(2019, 5, 1), 10_000, LocalDate.of(2019, 6, 5));
    }//만원_납부하면_한달_뒤가_만료일이_됨_리팩토링

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음(){
        assertExpiryDate(LocalDate.of(2019, 1, 31), 10_000, LocalDate.of(2019, 2, 28));
        assertExpiryDate(LocalDate.of(2019, 5, 31), 10_000, LocalDate.of(2019, 6, 30));
        assertExpiryDate(LocalDate.of(2020, 1, 31), 10_000, LocalDate.of(2020, 2, 29));
    }//납부일과_한달_뒤_일자가_같지_않음

}//end






























