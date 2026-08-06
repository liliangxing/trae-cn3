package com.bytedance.applog.monitor;

import com.bytedance.applog.ILogReportMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class LogReportMonitor {
    public static final String DB_DELETE_LOG_ERROR = "DB_DELETE_LOG_ERROR";
    public static final String DB_DELETE_LOG_FAILED = "DB_DELETE_LOG_FAILED";
    public static final String REQUEST_FAILED_ENCRYPT_EXCEPTION = "REQUEST_FAILED_ENCRYPT_EXCEPTION";
    public static final String REQUEST_FAILED_EXCEPTION = "REQUEST_FAILED_EXCEPTION";
    public static final String REQUEST_FAILED_RESPONSE_EMPTY = "REQUEST_FAILED_RESPONSE_EMPTY";
    public static final String REQUEST_FAILED_RESPONSE_INVALID = "REQUEST_FAILED_RESPONSE_INVALID";
    private final CopyOnWriteArraySet<ILogReportMonitor> observers = new CopyOnWriteArraySet<>();

    public void onRequestFailed(String str, String str2) {
        Iterator<ILogReportMonitor> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onRequestFailed(str, str2);
        }
    }

    public void onDbError(String str, Throwable th) {
        if (this.observers.isEmpty() || th == null) {
            return;
        }
        String th2 = th.toString();
        Iterator<ILogReportMonitor> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onDbError(str, th2);
        }
    }

    public void onDbError(String str, String str2) {
        if (this.observers.isEmpty()) {
            return;
        }
        Iterator<ILogReportMonitor> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onDbError(str, str2);
        }
    }

    public void addMonitor(ILogReportMonitor iLogReportMonitor) {
        if (iLogReportMonitor == null) {
            return;
        }
        this.observers.add(iLogReportMonitor);
    }

    public void removeMonitor(ILogReportMonitor iLogReportMonitor) {
        if (iLogReportMonitor == null) {
            return;
        }
        this.observers.remove(iLogReportMonitor);
    }
}
