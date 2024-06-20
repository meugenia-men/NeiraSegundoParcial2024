package Exceptions;

import java.util.PrimitiveIterator;

public class ExceptionTemperature extends RuntimeException{
    private Integer nroTest;
    private String neighborhood;

    public ExceptionTemperature(String message, Integer nroTest, String neighborhood) {
        super(message);
        this.nroTest = nroTest;
        this.neighborhood = neighborhood;
    }

    public Integer getNroTest() {
        return nroTest;
    }

    public String getNeighborhood() {
        return neighborhood;
    }
}
