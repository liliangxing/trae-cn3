package com.huawei.hms.push.utils.p029ha;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PushAnalyticsCenter {

    /* renamed from: a */
    private PushBaseAnalytics f1756a;

    /* renamed from: com.huawei.hms.push.utils.ha.PushAnalyticsCenter$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class C1237a {

        /* renamed from: a */
        private static PushAnalyticsCenter f1757a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return C1237a.f1757a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f1756a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f1756a = pushBaseAnalytics;
    }
}
