package com.keelient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    private int gasLevel;
    private String color;
    private List<String> passengers;
    private List<String> trunkContents;

    @FunctionalInterface
    interface CarCriterion {
        boolean test(Car car);

        default int getNum(){return 1;};
    }

    //private static final Predicate<Car> RED_CAR_CRITERION = c -> c.color.equals("Red");

    private static final CarCriterion RED_CAR_CRITERION = c -> c.color.equals("Red");

    public static CarCriterion getRedCarCriterion(){
        return RED_CAR_CRITERION;
    }

    private static final Comparator<Car> gasComparator = (o1, o2) -> o1.gasLevel - o2.gasLevel;

    private static Comparator<Car> getGasComparator(){
        return gasComparator;
    }

    DoubleStream
}
