package com.bytedance.news.common.settings.api.model;

/* loaded from: classes4.dex */
public class LocalClientModel {
    private String methodName;
    private double percent;
    private String vid;

    public String getVid() {
        return this.vid;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public double getPercent() {
        return this.percent;
    }

    public void setPercent(double d) {
        this.percent = d;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String str) {
        this.methodName = str;
    }
}
