package com.ltp.globalsuperstore;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MoneyValidator implements ConstraintValidator<Money, BigDecimal>{

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
       if(value.longValue() < 0) return false;
       return true;
    }

}
