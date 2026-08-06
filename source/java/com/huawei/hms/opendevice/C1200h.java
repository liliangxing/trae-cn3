package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: PushBiUtil.java */
/* renamed from: com.huawei.hms.opendevice.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C1200h {
    /* renamed from: a */
    public static String m1861a(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 61300300);
    }

    /* renamed from: a */
    public static void m1862a(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 61300300);
    }

    /* renamed from: a */
    public static void m1864a(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 61300300);
    }

    /* renamed from: a */
    public static void m1863a(Context context, String str, String str2, int i) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i, 61300300);
    }
}
