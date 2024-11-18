package oop.pillars.streamsample;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Allocation {

    private String name;
    private BigDecimal percentage;

    public Allocation(String name, BigDecimal percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "percentage=" + percentage +
                '}';
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
