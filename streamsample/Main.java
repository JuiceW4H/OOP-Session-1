package oop.pillars.streamsample;

import java.util.*;
import java.math.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {

        List<Allocation> allocations = new ArrayList<>();

        List<Allocation> twoDecimalPlace = new ArrayList<>();

        List<Allocation> roundUpSize = new ArrayList<>();
        List<Allocation> roundDownSize = new ArrayList<>();

        allocations.add(new Allocation("", new BigDecimal("0.234798")));
        allocations.add(new Allocation("", new BigDecimal("0.095678")));
        allocations.add(new Allocation("crypto", new BigDecimal("0.007448")));
        allocations.add(new Allocation("", new BigDecimal("0.439865")));
        allocations.add(new Allocation("", new BigDecimal("0.181233")));
        allocations.add(new Allocation("", new BigDecimal("0.040978")));

        // Ascending Order
        List<Allocation> ascendingOrder = allocations.stream().sorted(comparing(v -> v.getPercentage())).toList();

        // Descending Order
        List<Allocation> descendingOrder = allocations.stream().sorted(comparing(v -> v.getPercentage(), Comparator.reverseOrder())).toList();

        // 1st Task

        for(Allocation element: ascendingOrder){
            twoDecimalPlace.add(new Allocation(element.getName(), element.getPercentage().setScale(2, RoundingMode.HALF_EVEN)));
        }

        BigDecimal totalPercentage1T = twoDecimalPlace.stream()
                .map(Allocation::getPercentage) // Extract the percentage
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 2nd Task

        List<Allocation> bigThree = descendingOrder.stream().limit(3).toList();

        for(Allocation element: bigThree){
            roundUpSize.add(new Allocation(element.getName(), element.getPercentage().setScale(3, RoundingMode.HALF_UP)));
        }

        BigDecimal totalPercentage2Ta = roundUpSize.stream()
                .map(Allocation::getPercentage) // Extract the percentage
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<Allocation> smallThree = ascendingOrder.stream().limit(3).toList();

        for(Allocation element: smallThree){
            roundDownSize.add(new Allocation(element.getName(), element.getPercentage().setScale(3, RoundingMode.HALF_DOWN)));
        }

        BigDecimal totalPercentage2Tb = roundDownSize.stream()
                .map(Allocation::getPercentage) // Extract the percentage
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        System.out.println("Task 1: "+ twoDecimalPlace);
        System.out.println("Total = " + totalPercentage1T + "\n");

        System.out.println("Task 2:");
        System.out.println(roundUpSize);
        System.out.println(roundDownSize);
        System.out.println("Total = " + totalPercentage2Ta.add(totalPercentage2Tb) + "\n");

    }
}
