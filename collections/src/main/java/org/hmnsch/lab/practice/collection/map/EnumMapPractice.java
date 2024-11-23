package org.hmnsch.lab.practice.collection.map;

import java.util.EnumMap;

public class EnumMapPractice {
    public static void main(String[] args) {
        enum Day {
            mon, tues, wed, thurs, fri, sat, sun
        }

        // there is no need to calculate hash as the index is already calculated using ordinal of enums
        // order of the enum is maintained in the enum map
        // array size is same as enum size
        // faster than hashmap
        // efficient in memory management
        EnumMap<Day, String> dayStringEnumMap = new EnumMap<>(Day.class);
        dayStringEnumMap.put(Day.wed, "a");
        dayStringEnumMap.put(Day.fri, "b");
        dayStringEnumMap.put(Day.mon, "c");

        // {mon=c, wed=a, fri=b}
        System.out.println(dayStringEnumMap);

    }


}
