package com.bytedance.applog.sampling.util;

/* loaded from: classes3.dex */
public class Number128 {
    private long hiValue;
    private long lowValue;

    public Number128(long j, long j2) {
        setLowValue(j);
        setHiValue(j2);
    }

    public long getLowValue() {
        return this.lowValue;
    }

    public long getHiValue() {
        return this.hiValue;
    }

    public void setLowValue(long j) {
        this.lowValue = j;
    }

    public void setHiValue(long j) {
        this.hiValue = j;
    }
}
