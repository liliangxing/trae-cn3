package com.monitor.cloudmessage.consts;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface CloudControlInf {
    public static final String ABTEST = "abtest";
    public static final String ALOG = "alog";
    public static final String CACHE = "new_diskdir";
    public static final String DATA_CLEAR = "data_clear";
    public static final String DB = "db";
    public static final String HEAP_OOM = "heap_oom";
    public static final String MONITOR_LOG = "monitor_log";
    public static final String NETWORK = "network";
    public static final String NET_FLOW = "net_flow";
    public static final String PATCH = "patch";
    public static final String PERMISSION = "permission";
    public static final String PLUGIN = "plugin";
    public static final String ROUTE = "route";
    public static final String SP = "sp";
    public static final String STAT = "stat";
    public static final String TEMPLATE = "custom";
    public static final String UPLOAD = "new_file";
}
