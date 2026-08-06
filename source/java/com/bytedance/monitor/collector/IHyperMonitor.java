package com.bytedance.monitor.collector;

/* loaded from: classes4.dex */
public interface IHyperMonitor {

    /* loaded from: classes4.dex */
    public interface ILogInstance {
        void d(String str, String str2);

        void e(String str, String str2);

        long getNativeReference();

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    ILogInstance getLogInstance();
}
