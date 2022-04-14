package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class Adjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek day = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int add = 1;
        switch (day) {
            case FRIDAY:
                add = 3;
                break;
            case SATURDAY:
                add = 2;
        }
        return temporal.plus(add, ChronoUnit.DAYS);
    }

    public static Adjuster getInstance() {
        return new Adjuster();
    }
}
