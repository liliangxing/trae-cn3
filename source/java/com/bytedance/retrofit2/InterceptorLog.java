package com.bytedance.retrofit2;

/* loaded from: classes4.dex */
public class InterceptorLog {
    public Exception e;
    public long end;
    public String name;
    public long start;

    public InterceptorLog(String str, long j) {
        this.name = str;
        this.start = j;
        this.end = j;
    }
}
