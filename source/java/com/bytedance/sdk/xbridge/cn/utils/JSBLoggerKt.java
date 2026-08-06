package com.bytedance.sdk.xbridge.cn.utils;

import android.util.Log;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.XBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSBLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¨\u0006\t"}, d2 = {"printJSBLog", "", "engine", "", DBData.FIELD_TYPE, "methodName", "msg", "", "filterMethodName", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JSBLoggerKt {
    public static /* synthetic */ void printJSBLog$default(String str, String str2, String str3, Object obj, String str4, int i, Object obj2) {
        if ((i & 16) != 0) {
            str4 = null;
        }
        printJSBLog(str, str2, str3, obj, str4);
    }

    public static final void printJSBLog(String str, String str2, String str3, Object obj, String str4) {
        Intrinsics.checkNotNullParameter(str, "engine");
        Intrinsics.checkNotNullParameter(str2, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(str3, "methodName");
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (XBridge.INSTANCE.getDebuggable()) {
            if (str4 != null && Intrinsics.areEqual(str4, str3)) {
                Log.i("AnnieX_JSB_" + str, str2 + " ===> methodName:" + str3 + " result:" + obj);
            } else {
                if (str4 != null) {
                    return;
                }
                Log.i("AnnieX_JSB" + str, str2 + " ===> methodName:" + str3 + " result:" + obj);
            }
        }
    }
}
