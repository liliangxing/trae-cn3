package com.bytedance.pia.core.metrics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface ErrorType {
    public static final String BOOT = "boot";
    public static final String BRIDGE = "bridge";
    public static final String CACHE = "cache";
    public static final String MANIFEST = "manifest";
    public static final String NETWORK = "network";
    public static final String NSR_RENDER = "nsr_render";
    public static final String NSR_WORKER = "nsr_worker";
    public static final String PREFETCH = "prefetch";
    public static final String SETTINGS = "settings";
    public static final String SNAPSHOT = "snapshot";
    public static final String WORKER = "worker";
}
