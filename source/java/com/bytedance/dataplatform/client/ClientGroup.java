package com.bytedance.dataplatform.client;

/* loaded from: classes3.dex */
public class ClientGroup<T> {
    private double percent;
    private T result;
    private String vid;

    public ClientGroup(String vid, double percent, T result) {
        this.vid = vid;
        this.percent = percent;
        this.result = result;
    }

    public String getVid() {
        return this.vid;
    }

    public double getPercent() {
        return this.percent;
    }

    public T getResult() {
        return this.result;
    }
}
