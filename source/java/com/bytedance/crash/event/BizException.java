package com.bytedance.crash.event;

import java.util.Map;

/* loaded from: classes3.dex */
public class BizException {
    private Map<String, String> customData;
    private Map<String, String> filters;
    private String message;
    private Throwable throwable;

    public BizException(Throwable th, String str, Map<String, String> map, Map<String, String> map2) {
        this.throwable = th;
        this.message = str;
        this.filters = map;
        this.customData = map2;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, String> getFilters() {
        return this.filters;
    }

    public Map<String, String> getCustomData() {
        return this.customData;
    }
}
