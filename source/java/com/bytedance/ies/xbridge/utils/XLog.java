package com.bytedance.ies.xbridge.utils;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XLog;", "", "()V", "TAG", "", "debug", "", "msg", "error", "info", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XLog {
    public static final XLog INSTANCE = new XLog();
    private static final String TAG = "BDXBridgeKit";

    private XLog() {
    }

    public final void info(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        IXLogService iXLogService = (IXLogService) XServiceManager.INSTANCE.getService(IXLogService.class);
        if (iXLogService != null) {
            iXLogService.info(TAG, msg);
        } else {
            Log.i(TAG, msg);
        }
    }

    public final void debug(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        IXLogService iXLogService = (IXLogService) XServiceManager.INSTANCE.getService(IXLogService.class);
        if (iXLogService != null) {
            iXLogService.debug(TAG, msg);
        } else {
            Log.d(TAG, msg);
        }
    }

    public final void error(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        IXLogService iXLogService = (IXLogService) XServiceManager.INSTANCE.getService(IXLogService.class);
        if (iXLogService != null) {
            iXLogService.error(TAG, msg);
        } else {
            Log.e(TAG, msg);
        }
    }
}
