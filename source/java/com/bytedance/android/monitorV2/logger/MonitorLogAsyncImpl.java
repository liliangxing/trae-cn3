package com.bytedance.android.monitorV2.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class MonitorLogAsyncImpl implements ILogger {
    private final ILogger loggerImpl;
    private final ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

    public MonitorLogAsyncImpl(ILogger iLogger) {
        this.loggerImpl = iLogger;
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void v(final String str, final String str2) {
        this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.logger.MonitorLogAsyncImpl.1
            @Override // java.lang.Runnable
            public void run() {
                MonitorLogAsyncImpl.this.loggerImpl.v(str, str2);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void d(final String str, final String str2) {
        this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.logger.MonitorLogAsyncImpl.2
            @Override // java.lang.Runnable
            public void run() {
                MonitorLogAsyncImpl.this.loggerImpl.d(str, str2);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void i(final String str, final String str2) {
        this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.logger.MonitorLogAsyncImpl.3
            @Override // java.lang.Runnable
            public void run() {
                MonitorLogAsyncImpl.this.loggerImpl.i(str, str2);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void w(final String str, final String str2) {
        this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.logger.MonitorLogAsyncImpl.4
            @Override // java.lang.Runnable
            public void run() {
                MonitorLogAsyncImpl.this.loggerImpl.w(str, str2);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void e(final String str, final String str2) {
        this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.logger.MonitorLogAsyncImpl.5
            @Override // java.lang.Runnable
            public void run() {
                MonitorLogAsyncImpl.this.loggerImpl.e(str, str2);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void e(final String str, final String str2, final Throwable th) {
        this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.logger.MonitorLogAsyncImpl.6
            @Override // java.lang.Runnable
            public void run() {
                MonitorLogAsyncImpl.this.loggerImpl.e(str, str2, th);
            }
        });
    }
}
