package com.bytedance.sdk.xbridge.cn.utils;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/DefaultLogger;", "Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeLogger;", "()V", "log", "", "msg", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultLogger implements XBridgeLogger {
    @Override // com.bytedance.sdk.xbridge.cn.utils.XBridgeLogger
    public void log(CharSequence msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.i("BDXBridgeKit", msg.toString());
    }
}
