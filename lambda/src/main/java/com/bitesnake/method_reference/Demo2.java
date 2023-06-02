package com.bitesnake.method_reference;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public static class Apple {
        public String color;
        public Integer weight;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
        public static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.getColor());
        }

        public static boolean isHeavyApple(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public interface ApplePredicate<T> extends Predicate<T> {
        boolean test(T t);
    }



    public static List<Apple> filterApples(List<Apple> inventory,
                                           Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
            for (Apple apple: inventory) {
                if (p.test(apple)) {
                    result.add(apple);
                }
            }
            return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        filterApples(inventory, Apple::isGreenApple);
        filterApples(inventory, Apple::isHeavyApple);

        // From passing methods to lambdas
        filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);
    }





}
