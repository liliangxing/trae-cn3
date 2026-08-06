package com.bytedance.apm6.java_alloc;

/* loaded from: classes3.dex */
public interface IRecordReader {
    void onHeadInfo(String str, long j, long j2, int i, JavaAllocConfig javaAllocConfig, long j3, long j4);

    boolean onItem(String str, int i, int i2, Trace trace, int i3);
}
