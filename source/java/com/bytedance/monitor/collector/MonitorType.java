package com.bytedance.monitor.collector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface MonitorType {
    public static final String ATRACE_MONITOR = "atrace_event";
    public static final String BINDER_MONITOR = "binder_monitor";
    public static final String IO_MONITOR = "io_monitor";
    public static final String LOCK_MONITOR = "lock_monitor";
    public static final String LOOPER_MONITOR = "block_looper_info";
    public static final String MEMORY_MONITOR = "memory_monitor";
    public static final String PROC_MONITOR = "proc_monitor";
    public static final String PROFILER_MONITOR = "profiler_monitor";
}
