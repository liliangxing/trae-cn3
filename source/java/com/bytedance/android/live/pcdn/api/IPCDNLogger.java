package com.bytedance.android.live.pcdn.api;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IPCDNLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/pcdn/api/IPCDNLogger;", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "tag", "", "msg", "e", LynxError.LYNX_THROWABLE, "", RXScreenCaptureService.KEY_INDEX, "monitorEvent", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "extraLog", BaseSwitches.V, "w", "livepcdn-api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IPCDNLogger {
    void d(String tag, String msg);

    void e(String tag, String msg, Throwable throwable);

    void i(String tag, String msg);

    void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject extraLog);

    void v(String tag, String msg);

    void w(String tag, String msg);

    void w(String tag, Throwable throwable);
}
