package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AggregationOption {
    MIN(0),
    MAX(1),
    MAJORITY(2);

    private int value;

    AggregationOption(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == MIN ? "AggregationOptionMin" : this == MAX ? "AggregationOptionMax" : this == MAJORITY ? "AggregationOptionMajority" : "AggregationOptionMin";
    }
}
