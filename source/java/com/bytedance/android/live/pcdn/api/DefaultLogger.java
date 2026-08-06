package com.bytedance.android.live.pcdn.api;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PCDNLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/pcdn/api/DefaultLogger;", "Lcom/bytedance/android/live/pcdn/api/IPCDNLogger;", "()V", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "tag", "", "msg", "e", LynxError.LYNX_THROWABLE, "", RXScreenCaptureService.KEY_INDEX, "monitorEvent", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "extraLog", BaseSwitches.V, "w", "livepcdn-api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DefaultLogger implements IPCDNLogger {
    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject extraLog) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(metric, "metric");
        Intrinsics.checkParameterIsNotNull(extraLog, "extraLog");
    }

    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void v(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Log.v(tag, msg);
    }

    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void d(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Log.v(tag, msg);
    }

    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void i(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Log.i(tag, msg);
    }

    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void w(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Log.w(tag, msg);
    }

    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void w(String tag, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        Log.w(tag, throwable);
    }

    @Override // com.bytedance.android.live.pcdn.api.IPCDNLogger
    public void e(String tag, String msg, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        Log.e(tag, msg, throwable);
    }
}
