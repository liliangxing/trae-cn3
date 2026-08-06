package com.bytedance.push.monitor.opentracing;

import com.ss.android.ug.bus.IUgBusService;

/* loaded from: classes4.dex */
public interface ITracingMonitor extends IUgBusService {
    void endInit();

    void endRegisterSender(boolean z, int i, int i2, String str);

    void endRequestSender(boolean z, int i, String str);

    void endSenderCheck(String str, boolean z);

    void start();

    void startInit();

    void startRegisterSender(int i);

    void startRequestSender();

    void startSenderCheck(String str, boolean z);
}
