package com.bytedance.android.live.setting;

import android.content.Context;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: ILiveSettingDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J.\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/setting/ILiveSettingDepend;", "", "e", "", "tag", "", "msg", LynxError.LYNX_THROWABLE, "", "ensureNotReachHere", "logType", "getContext", "Landroid/content/Context;", RXScreenCaptureService.KEY_INDEX, "isLocalText", "", "isSettingDebug", "monitorEvent", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "w", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public interface ILiveSettingDepend {
    void e(String tag, String msg);

    void e(String tag, String msg, Throwable throwable);

    void e(String tag, Throwable throwable);

    void ensureNotReachHere(String logType, Throwable throwable, String msg);

    Context getContext();

    void i(String tag, String msg);

    boolean isLocalText();

    boolean isSettingDebug();

    void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject extraLog);

    void w(String tag, String msg);
}
