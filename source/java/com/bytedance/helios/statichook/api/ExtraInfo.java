package com.bytedance.helios.statichook.api;

import java.util.Map;

/* loaded from: classes3.dex */
public class ExtraInfo {
    Map<String, Object> extra;
    public int hashTokenValue;
    boolean isReflection;
    String parameterSignature;
    public String proxyCallerToken;

    public ExtraInfo(boolean z) {
        this.isReflection = z;
    }

    public ExtraInfo(boolean z, String str) {
        this.isReflection = z;
        this.parameterSignature = str;
    }

    public ExtraInfo(boolean z, String str, String str2) {
        this.isReflection = z;
        this.parameterSignature = str;
        this.proxyCallerToken = str2;
    }

    public ExtraInfo(boolean z, String str, String str2, int i) {
        this.isReflection = z;
        this.parameterSignature = str;
        this.proxyCallerToken = str2;
        this.hashTokenValue = i;
    }

    public ExtraInfo(boolean z, String str, int i) {
        this.isReflection = z;
        this.parameterSignature = str;
        this.hashTokenValue = i;
    }

    public ExtraInfo(boolean z, String str, Map<String, Object> map) {
        this.isReflection = z;
        this.parameterSignature = str;
        this.extra = map;
    }

    public boolean isReflection() {
        return this.isReflection;
    }

    public String getParameterSignature() {
        return this.parameterSignature;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void setHashTokenValue(int i) {
        this.hashTokenValue = i;
    }
}
