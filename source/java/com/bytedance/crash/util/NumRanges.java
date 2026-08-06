package com.bytedance.crash.util;

import java.util.Arrays;

/* loaded from: classes3.dex */
public class NumRanges {
    Long[] mSortedArray;
    String mUnit;

    public NumRanges(String str) {
        this.mUnit = str;
    }

    public String get(long j) {
        long j2;
        Long[] lArr = this.mSortedArray;
        if (lArr == null) {
            return "";
        }
        int length = lArr.length;
        int i = 0;
        long j3 = Long.MIN_VALUE;
        while (true) {
            if (i >= length) {
                j2 = Long.MAX_VALUE;
                break;
            }
            Long l = lArr[i];
            if (j >= l.longValue()) {
                j3 = l.longValue();
                i++;
            } else {
                j2 = l.longValue() - 1;
                break;
            }
        }
        String str = (j3 != Long.MIN_VALUE ? "[" + j3 + this.mUnit : "[") + " - ";
        if (j2 != Long.MAX_VALUE) {
            str = str + j2 + this.mUnit;
        }
        return str + "]";
    }

    public void set(Long[] lArr) {
        Arrays.sort(lArr);
        this.mSortedArray = lArr;
    }

    public void set(long j, long j2, long j3) {
        int i = ((int) ((j2 - j) / j3)) + 1;
        Long[] lArr = new Long[i];
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i2 < i3) {
                lArr[i2] = Long.valueOf((i2 * j3) + j);
                i2++;
            } else {
                lArr[i3] = Long.valueOf(j2);
                set(lArr);
                return;
            }
        }
    }
}
