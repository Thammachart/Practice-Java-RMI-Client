package org.rmi.clients;

import java.math.BigDecimal;
import java.io.Serializable;

import org.rmi.components.Task;

public class FactorialTask implements Task<BigDecimal>, Serializable {
    private static final long serialVersionUID = 927798721894L;

    private final int factorial;

    public FactorialTask(int factorial) {
        this.factorial = factorial;
    }

    @Override
    public BigDecimal execute() {
        return performFactorial(BigDecimal.valueOf(factorial),BigDecimal.valueOf(factorial));
    }

    private BigDecimal performFactorial(BigDecimal n, BigDecimal accumulator) {
        if(n.equals(BigDecimal.ONE)) {
            return accumulator;
        }

        BigDecimal lessOne = n.subtract(BigDecimal.ONE);
        return performFactorial(lessOne, accumulator.multiply(lessOne));
    }
}
