package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.p029ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.p029ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushAnalyticsUtils.java */
/* renamed from: com.huawei.hms.push.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1222l {

    /* renamed from: a */
    private static final String f1691a = "l";

    /* renamed from: a */
    public static void m1967a(Context context, String str, String str2, String str3) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            return;
        }
        Bundle m1965a = m1965a(context, str, str2);
        HMSLog.m2120i(f1691a, "eventId:" + str3);
        pushAnalytics.report(context, str3, m1965a);
    }

    /* renamed from: a */
    private static Bundle m1965a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("sdkVer", String.valueOf(61300300));
        bundle.putString("pkgName", context.getPackageName());
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        PushProxy proxy = ProxyCenter.getProxy();
        if (proxy != null) {
            bundle.putString("proxyType", proxy.getProxyType());
        }
        bundle.putString(RemoteMessageConst.MSGID, str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(RemoteMessageConst.ANALYTIC_INFO, str2);
        }
        return bundle;
    }

    /* renamed from: a */
    public static void m1966a(Context context, Bundle bundle, String str) {
        PushBaseAnalytics pushAnalytics;
        if (bundle == null || (pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        bundle.putString("sdk_version", String.valueOf(61300300));
        HMSLog.m2120i(f1691a, "eventId:" + str);
        pushAnalytics.report(context, str, bundle);
    }
}
